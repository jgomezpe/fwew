package fwew.real.array.mutation;

import fwew.Adapt;

public class AdaptIntensityMutation implements Adapt{
    protected double sigma;
    protected double alpha;
    protected IntensityMutation mutation;
    
    public AdaptIntensityMutation( double alpha, IntensityMutation mutation, double sigma) {
	this.alpha = alpha;
	this.sigma = sigma;
	this.mutation = mutation;
	mutation.sigma = sigma;
    }
    
    @Override
    public void punish() {
	mutation.sigma *= alpha;
    }

    @Override
    public void reward() {
	mutation.sigma /= alpha;
	
    }

    @Override
    public void reset() {
	mutation.sigma = sigma;
    }
}