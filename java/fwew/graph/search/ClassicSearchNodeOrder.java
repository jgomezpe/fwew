package fwew.graph.search;

import kompari.Order;

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
public class ClassicSearchNodeOrder<T,O> implements Order<ClassicSearchNode<T, O>>{
	public int compare( ClassicSearchNode<T,O> one, ClassicSearchNode<T,O> two ){ return (int)(one.cost - two.cost); }
}
