package fwew.graph.uninformed;

import fwew.graph.GraphSpace;
import fwew.graph.goal.GoalTest;
import fwew.graph.goal.OptionCost;
import fwew.graph.search.ClassicSearch;
import fwew.graph.search.ClassicSearchNode;
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
public class IteratedDepthFirstSearch<T,O> extends ClassicSearch<T,O>{
    protected DepthFirstSearch<T,O> depth_search = null;
    public IteratedDepthFirstSearch( GoalTest<T> goal ) { super( goal ); }

  public IteratedDepthFirstSearch( GoalTest<T> goal, int _max_depth ) {
      super( goal, _max_depth );
  }

  public void add( ClassicSearchNode<T,O> child ){}

  public Array<O> apply( T initial, GraphSpace<T,O> space, OptionCost<T,O> cost ){
    Array<O> path = null;
    int depth = 0;
    while( path != null && depth < max_depth ){
      depth++;
      depth_search = new DepthFirstSearch<T,O>(goal,depth);
      path = depth_search.apply(initial, space, cost );
    }
    return path;
  }
}
