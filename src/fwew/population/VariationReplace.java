/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwew.population;

/**
 *
 * @author jgomez
 */
public class VariationReplace<T> implements Variation<T>{
    protected Variation<T> variation;
    protected Replacement<T> replace;
    
    public VariationReplace( Variation<T> variation, Replacement<T> replace ){
        this.variation = variation;
        this.replace = replace;
    }
    
    @Override
    public T[] apply(T[] x){
	return replace.apply(x,variation.apply(x));
    }

    @Override
    public int[] signature() {
	return new int[] {2,-1};
    }
}