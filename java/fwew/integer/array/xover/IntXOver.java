/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.integer.array.xover;

import fwew.vr.Variation;
import hazarda.Hazarda;

/**
 *
 * @author Jonatan
 */
public class IntXOver implements Variation<int[][]>{
    public IntXOver(){}
   
    /**
     * The crossover point of the last xover execution
     */
    protected int cross_over_point;

    /**
     * Apply the simple point crossover operation over the given genomes at the given
     * cross point
     * @param child1 The first parent
     * @param child2 The second parent
     * @param xoverPoint crossover point
     * @return The crossover point
     */
    public int[][] generates(int[] child1, int[] child2, int xoverPoint) {
	int[] child1_1 = child1.clone();
	int[] child2_1 = child2.clone();

	cross_over_point = xoverPoint;

	for(int i=xoverPoint;i<child1.length; i++){
	    child1_1[i] = child2[i];
	    child2_1[i] = child1[i];              
	}
      
	return new int[][]{child1_1,child2_1};
    }

    /**
     * Apply the simple point crossover operation over the given genomes
     * @param child1 The first parent
     * @param child2 The second parent
     * @return The crossover point
     */
    public int[][] apply( int[] child1, int[] child2 ){
	return generates(child1, child2, Hazarda.uniform(Math.min(child1.length, child2.length)));
    }

    @Override
    public int[][] apply(int[][] parents) { return apply(parents[0], parents[1]);}

    @Override
    public int[] signature() { return new int[] {2,2}; }
}