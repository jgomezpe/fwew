package fwew.graph.informed;

import fwew.graph.goal.GoalTest;
import fwew.graph.goal.OptionCost;
import fwew.graph.uninformed.UniformCostSearch;

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
public class Astar<T,O> extends UniformCostSearch<T,O>{
    protected Heuristic<T,O> heuristic;
    public Astar( GoalTest<T> goal, int _max_depth, Heuristic<T,O> _heuristic ) {
	super( goal, _max_depth );
	heuristic = _heuristic;
    }
  
    public Astar( GoalTest<T> goal, Heuristic<T,O> _heuristic ) {
	super( goal );
	heuristic = _heuristic;
    }

    public double evaluate( T state, O action, double actual_cost,
                          OptionCost<T,O> action_cost ){
	return actual_cost + action_cost.evaluate(state, action) +
           heuristic.evaluate(state,action);
    }
}