package fwew.graph.uninformed;

import fwew.graph.goal.GoalTest;
import fwew.graph.search.ClassicSearch;
import fwew.graph.search.ClassicSearchNode;

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
public class BreadthFirstSearch<T,O> extends ClassicSearch<T,O> {
    public BreadthFirstSearch( GoalTest<T> goal ) { super( goal ); }

    public BreadthFirstSearch( GoalTest<T> goal, int _max_depth ) {
	super( goal, _max_depth );
    }

    public void add( ClassicSearchNode<T,O> child ){
	list.add(child);
    }
}
