package fwew.population;

import fwew.Goal;
import hazarda.selection.Elitism;
import hazarda.selection.Selection;

public class TotalSelectionReplacement<T> implements Replacement<T> {
    protected Selection selection=null;
    protected Goal<T> goal;
    protected int mu;
	
    public TotalSelectionReplacement(Goal<T> goal){
	this(-1, goal, new Elitism(1.0, 0.0));
    }
	
    public TotalSelectionReplacement(int mu, Goal<T> goal){
	this(mu, goal, new Elitism(1.0, 0.0));
    }
	
    public TotalSelectionReplacement(Goal<T> goal, Selection selection){
	this(-1, goal, selection);
    }
	
    public TotalSelectionReplacement(int mu, Goal<T> goal, Selection selection ){
	this.mu = mu;
	this.goal = goal;
	this.selection = selection;
    }
	
    @Override
    public T[] apply(T[] current, T[] next) {
	double[] q = new double[current.length+next.length];
	for( int i=0; i<current.length; i++ ) q[i] = goal.apply(current[i]);
	
	int k=current.length;
	for( int i=0; i<next.length; i++ ) q[k++] = goal.apply(next[i]);
	
	int[] s;
	int mu = (this.mu==-1)?current.length:this.mu;
	if(goal.maximize()) s = selection.natural(mu, q);
	else s = selection.reversed(mu, q);
	@SuppressWarnings("unchecked")
	T[] parent = (T[])new Object[mu];
	for( int i=0; i<mu; i++ )
	    if(s[i]<current.length) parent[i] = current[s[i]];
	    else parent[i] = next[s[i]-current.length];
	
	goal.keep(parent);
	return parent;
    }
    
    @Override
    public int range() { return mu; }
}