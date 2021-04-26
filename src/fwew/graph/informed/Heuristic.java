package fwew.graph.informed;
import fwew.graph.*;
import fwew.graph.goal.OptionCost;

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
public abstract class Heuristic<T,O> implements OptionCost<T,O>{
  protected GraphSpace<T,O> space;
  public Heuristic( GraphSpace<T,O> _space ) {
    space = _space;
  }
}
