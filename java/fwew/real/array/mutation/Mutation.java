/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fwew.real.array.mutation;

import fwew.vr.Variation;
import hazarda.Hazarda;

/**
 *
 * @author jgomezpe
 */
public abstract class Mutation implements Variation<double[]>{
    protected hazarda.integer.Random components = null;
    
    public Mutation(hazarda.integer.Random components){ this.components = components; }
    
    public Mutation(){}

    public int[] components(int n) {
	if(components==null) return null;
	return Hazarda.sample(n, components.next());
    }
    
    public abstract double[] delta(double[]x, int[] components);
    
    @Override
    public double[] apply(double[] x) {
	x = x.clone();
	int[] components = components(x.length);
	double[] delta = delta(x, components);
	if( components != null )
	    for( int i=0; i<components.length; i++ )
		x[components[i]] += delta[i];
	else
	    for( int i=0; i<x.length; i++ )
		x[i] += delta[i];
	return x;
    } 

    @Override
    public int[] signature() {  return new int[] {1,1}; }
}