package fwew.graph;

import fwew.graph.goal.OptionCost;
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
public class PathUtil<T,O>{
  public double evaluate( T state, GraphSpace<T,O> space, Array<O> path, OptionCost<T,O> cost ){
    double c = 0.0;
    for(O option : path){
      c += cost.evaluate( state, option);
      state = space.succesor( state, option );
    }
    return c;
  }
  
  public T final_state( T initial, GraphSpace<T,O> space, Array<O> path ){
      for(O option : path){
        initial = space.succesor( initial, option );
      }
      return initial;
  }
}
