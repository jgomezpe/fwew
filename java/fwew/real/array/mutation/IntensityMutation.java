/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fwew.real.array.mutation;
import hazarda.real.Random;

/**
 *
 * @author jgomezpe
 */
public class IntensityMutation extends Mutation{
    // Mutation definitions
    protected double sigma;
    protected Random g;
    
    public IntensityMutation( double sigma, Random g, 
	    hazarda.integer.Random components){
        super(components);
        this.sigma = sigma;
        this.g = g;
    }
    
    public IntensityMutation(double sigma, Random g ){
        this( sigma, g, null);
    }
    
    @Override
    public double[] delta(double[] x, int[] components){
    	double[] delta;
	if( components != null ) delta = new double[components.length];
	else delta = new double[x.length];
        if( components != null )
            for( int i=0; i<components.length; i++ )
        	delta[i] =  sigma*g.next();
        else
            for( int i=0; i<x.length; i++ )
        	delta[i] =  sigma*g.next();
        return delta;
    }
}