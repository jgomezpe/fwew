/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fwew.real.array.xover;

import fwew.vr.Variation;

/**
 * <p>Title:  RealArityTwo</p>
 * <p>Description: An Arity Two real vector genetic operator</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */
public abstract class RealArityTwo implements Variation<double[][]>{

    public abstract double[][] apply( double[] one, double[] two);
 
    @Override
    public double[][] apply(double[][] parents) {
	return apply(parents[0],parents[1]);
    }

    @Override
    public int[] signature() { return new int[] {2,2}; }
}