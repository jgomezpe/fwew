package fwew.graph.search;
import speco.array.Array;
import fwew.graph.GraphSpace;
import fwew.graph.goal.OptionCost;
import fwew.space.Space;

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
public interface PathSearch<T,O>{
    Array<O> apply( T current, GraphSpace<T,O> space, OptionCost<T,O> cost );
    
    default Array<O> apply( Space<T> space, T x ){
	@SuppressWarnings("unchecked")
	GraphSpace<T,O> g_space = (GraphSpace<T,O>)space;
	OptionCost<T,O> cost = g_space.cost();
	return apply( x, g_space, cost);
    }
}