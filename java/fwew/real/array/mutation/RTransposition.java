/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.real.array.mutation;
import fwew.vr.Variation;
import hazarda.integer.Uniform;

/**
 *
 * @author jgomez
 */
public class RTransposition implements Variation<double[]>{
	    protected Uniform g;
	    protected int d = 2;
	    public RTransposition(){
	        g = new Uniform(d);
	    }
	    
	  /**
	   * Interchange the bits between two positions randomly chosen
	   * Example:      genome = 100011001110
	   * Transposition 2-10:    101100110010
	   * @param _genome Genome to be modified
	   */
	@Override
	public double[] apply(double[] gen) {
		try {
			double[] genome = gen.clone();
	        if( d != gen.length ){
	        	d = gen.length;
	        	g = new Uniform(d);
	        }
	        int start = g.next();
	        int end = g.next();
	
	        if (start > end) {
	        	int t = start;
	        	start = end;
	            end = t;
	        }
	          
	        double tr;
	
	        while (start < end) {
	        	tr = genome[start];
	        	genome[start] = genome[end];
	        	genome[end] = tr;
	        	start++;
	        	end--;
	        }
	        return genome;
		}catch( Exception e ){}
	    return null;
	}	

	    @Override
	    public int[] signature() {  return new int[] {1,1}; }
}