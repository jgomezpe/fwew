package fwew.local;

import fwew.AdaptVariation;
import fwew.Goal;

public class HillClimbing<T> implements Replacement<T> {
    protected boolean neutral = true;
    protected Goal<T> goal; 
    protected T current = null;
    protected double f_current;
    protected AdaptVariation adapt=null;
    
    public HillClimbing(Goal<T> goal){ this(goal,true); }
    
    public HillClimbing(Goal<T> goal, boolean neutral ){
	this.goal = goal;
	this.neutral = neutral;
    }
    
    public void set(AdaptVariation adapt) { this.adapt = adapt; }
    
    public void reset() {
	current = null; 
	if( adapt!=null ) adapt.reset();
    }

    @Override
    public T apply(T x, T y) {
	if(current!=x) {
	    current = x;
	    f_current = goal.apply(current);
	}
	double f_y = goal.apply(y);
	if( adapt!= null )  adapt.adapt(f_current, f_y);
        if( neutral ) {
            if(goal.compare(current, y) <= 0) {
        	current = y;
        	f_current = f_y;
            }
        }else{
            if(goal.compare(current, y) < 0) {
        	current = y;
        	f_current = f_y;
            }
    	}
	return current;
    }
}
