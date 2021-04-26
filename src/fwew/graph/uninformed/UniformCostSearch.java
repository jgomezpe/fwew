package fwew.graph.uninformed;

import fwew.graph.goal.GoalTest;
import fwew.graph.search.ClassicSearch;
import fwew.graph.search.ClassicSearchNode;
import fwew.graph.search.ClassicSearchNodeOrder;
import speco.array.Sorted;

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
public class UniformCostSearch<T,O> extends ClassicSearch<T,O> {
    public UniformCostSearch( GoalTest<T> goal ) { super(goal); }

    public UniformCostSearch( GoalTest<T> goal, int _max_depth ) {
	super( goal, _max_depth );
	list = new Sorted<ClassicSearchNode<T,O>>( new ClassicSearchNodeOrder<T,O>() );
    }

    public void add( ClassicSearchNode<T,O> child ){
	list.add(child);
    }
}