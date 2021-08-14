package fwew.local;

import fwew.space.Space;
import fwew.space.SpaceSampler;

public class ModularSearch<T> implements Search<T> {
    protected SpaceSampler<T> init;
    protected Variation<T> variation;
    protected StopCondition<T> stop_condition;
    
    public ModularSearch(SpaceSampler<T> init, Variation<T> variation, 
	    StopCondition<T> stop_condition) {
	this.init = init;
	this.variation = variation;
	this.stop_condition = stop_condition;
    }
    
    @Override
    public T init(Space<T> space) { return init.apply(space); }

    @Override
    public boolean stop_condition(int iter) {	
	return stop_condition.check(this, iter);
    }

    @Override
    public T variation(T x) { return variation.apply(x); }
}