package fwew.bit.array.xover;
import fwew.vr.Variation;
import hazarda.Hazarda;
import kopii.Copier;
import speco.bit.array.Array;

/**
 * <p>Title: XOver</p>
 * <p>Description: The simple point crossover operator (variable length)</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class XOver implements Variation<Array[]>{
    public XOver(){}

    /**
     * The crossover point of the last xover execution
     */
    protected int cross_over_point;

    /**
     * Apply the simple point crossover operation over the given genomes at the given
     * cross point
     * @param parent1 The first parent
     * @param parent2 The second parent
     * @param xoverPoint crossover point
     * @return The crossover point
     */
    protected Array[] apply(Array parent1, Array parent2, int xoverPoint) {
	try{
	    Array child1_1 = (Array)Copier.apply(parent1);
	    Array child2_1 = (Array)Copier.apply(parent2);
	    Array child1_2 = (Array)Copier.apply(parent1);
	    Array child2_2 = (Array)Copier.apply(parent2);

	    cross_over_point = xoverPoint;

	    child1_2.leftSetToZero(cross_over_point);
	    child2_2.leftSetToZero(cross_over_point);
	    child1_1.rightSetToZero(cross_over_point);
	    child2_1.rightSetToZero(cross_over_point);
	    child2_1.or(child1_2);
	    child1_1.or(child2_2);
	    return new Array[]{child1_1, child2_1};
	}catch( Exception e ){}
	return null;
    }

    /**
     * Apply the simple point crossover operation over the given genomes
     * @param child1 The first parent
     * @param child2 The second parent
     * @return The crossover point
     */
    public Array[] apply( Array parent1, Array parent2 ){
	return apply(parent1, parent2, 
		      Hazarda.uniform(Math.min(parent1.size(), parent2.size())));
    }    

    /**
     * Apply the simple point crossover operation over the given genomes
     * @param child1 The first parent
     * @param child2 The second parent
     * @return The crossover point
     */
      @Override
    public Array[] apply( Array[] parent ){
    	return apply(parent[0],parent[1]);
    }

    @Override
    public int[] signature() { return new int[] {2,2}; }    
}