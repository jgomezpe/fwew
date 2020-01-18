package nsgl.graph;

import nsgl.generic.array.DynArray;
import nsgl.search.space.Space;

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
public interface GraphSpace<T,O>  extends Space<T>{
	public T succesor( T state, O action );
	public DynArray<O> succesor( T state );
	public OptionCost<T,O> cost();
}