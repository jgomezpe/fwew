package fwew.graph.search;
import fwew.graph.GraphSpace;
import fwew.graph.PathUtil;
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
public class ClassicSearchNode<T,O> {
  protected Array<O> path;
  protected double cost;
  public ClassicSearchNode( Array<O> _path, double _cost ) {
    path = _path;
    cost = _cost;
  }
  
  public Array<O> path(){
	  return path;
  }
  
  public T state( GraphSpace<T,O> space, T initial_state ){
	  PathUtil<T,O> util = new PathUtil<T,O>();
	  return util.final_state(initial_state, space, path);
  }
}
