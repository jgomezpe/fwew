package fwew.graph.search;

import fwew.graph.*;
import fwew.graph.goal.GoalTest;
import fwew.graph.goal.OptionCost;
import kopii.Copier;
import speco.array.Array;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: Universidad Nacional de Colombia</p>
 *
 * @author Jonatan Gómez
 * @version 1.0
 */
public abstract class ClassicSearch<T,O> implements PathSearch<T,O> {
    protected Array<ClassicSearchNode<T,O>> list;
    protected int max_depth;

    protected GoalTest<T> goal;
	
    public ClassicSearch( GoalTest<T> goal ) { this(goal, Integer.MAX_VALUE); }
    public ClassicSearch( GoalTest<T> goal, int _max_depth ) {
	max_depth = _max_depth;
	list = new Array<ClassicSearchNode<T,O>>();
	this.goal = goal;
    }

    public double evaluate( T state, O option, double actual_cost, OptionCost<T,O> option_cost ){
	return actual_cost + option_cost.evaluate(state, option);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Array<O> apply( T initial, GraphSpace<T,O> space, OptionCost<T,O> cost ){
	list.clear();
	ClassicSearchNode<T,O> node = new ClassicSearchNode<T,O>( new Array<O>(), 0.0 );
	list.add(node);
	T state = initial;
	while( node != null && !goal.check(state) ){
	    list.remove(0);
	    if( node.path.size() < max_depth ){
		Array<O> actions = space.succesor(state);
		for(O action : actions) {
		    T child_state = space.succesor(state, action);
		    if( space.feasible(child_state) ){
			double path_cost = evaluate(state, action, node.cost, cost);
			Array<O> path;
			path = (Array<O>)Copier.apply(node.path);
			path.add(action);
			ClassicSearchNode<T,O> child_node = new ClassicSearchNode<T,O>( path, path_cost);
			add(child_node);
		    }
		}
	    }
	    try{ 
		node = list.get(0);
		state = node.state(space, initial);
	    }catch( Exception e ){ node=null; }
	}
	if( node != null ) return node.path;
	return null;
    }

    protected abstract void add(ClassicSearchNode<T, O> child_node);
}