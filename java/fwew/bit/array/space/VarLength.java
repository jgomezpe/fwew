package fwew.bit.array.space;

import hazarda.Hazarda;
import hazarda.integer.Uniform;
import speco.bit.array.Array;

public class VarLength implements fwew.space.Space<Array> {
    protected int minLength;
    protected int maxVarGenes;
    protected int gene_size;
    protected Uniform g;
    protected Uniform gi = new Uniform(speco.integer.Util.HIGHEST_BIT >>> 1);
	
    public VarLength( int minLength, int maxLength ){ this(minLength, maxLength, 1); }

    public VarLength( int minLength, int maxLength, int gene_size ){
	this.minLength = minLength;
	this.gene_size = gene_size;
	this.maxVarGenes = (maxLength-minLength)/gene_size;
	g = maxVarGenes>0?new Uniform(maxVarGenes):null;
    }
	
    @Override
    public boolean feasible(Array x) {
	return minLength <= x.size() && x.size()<=minLength+maxVarGenes*gene_size;
    }

    @Override
    public double feasibility(Array x) { return feasible(x)?1:0; }

    @Override
    public Array repair(Array x) {
	int maxLength = minLength + maxVarGenes * gene_size;
	if( x.size() > maxLength ) return x.subArray(0,maxLength);
	if( x.size() < minLength ){
	    Array x2 = create(minLength);
	    try{ for( int i=0; i<minLength;i++)	x2.set(i,x.get(i)); }catch(Exception e){}
	    return x2;
	}else return x;
    }
	
    protected Array create( int n ) {
	int m = (n+speco.integer.Util.INTEGER_SIZE-1)/ speco.integer.Util.INTEGER_SIZE;
	int[] data = new int[m];
	gi.generate( data, 0, m );
	for (int i = 0; i<m; i++) if(Hazarda.bool()) data[i] = -data[i];
 	return new Array(data, n);	
    }
    
    @Override
    public Array pick() { return create( minLength + (g!=null?gene_size*g.next():0) ); }
}