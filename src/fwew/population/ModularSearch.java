package fwew.population;

import fwew.space.Space;
import fwew.space.SpaceSampler;

public class ModularSearch<T> implements Search<T> {
    protected SpaceSampler<T> init;
    protected Variation<T> variation;
    protected StopCondition<T> stop_condition;
    protected int mu;
    
    public ModularSearch(int mu, SpaceSampler<T> init, 
	    Variation<T> variation, 
	    StopCondition<T> stop_condition) {
	this.init = init;
	this.variation = variation;
	this.stop_condition = stop_condition;
    }
    
    @Override
    public T[] init(Space<T> space) {
	@SuppressWarnings("unchecked")
	T[] obj = (T[])new Object[mu];
	for( int i=0; i<mu; i++)
	    obj[i] = init.apply(space);
	return obj; 
    }

    @Override
    public boolean stop_condition(int iter) {	
	return stop_condition.check(this, iter);
    }

    @Override
    public T[] variation(T[] x) { return variation.apply(x); }
}