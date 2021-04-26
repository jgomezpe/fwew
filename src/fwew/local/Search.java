package fwew.local;

import fwew.space.Space;
import speco.function.Function;
import spuro.Spuro;

public interface Search<T> extends Function<Space<T>,T>{
    T init(Space<T> space);
    boolean stop_condition(int iter);
    T variation(T x);
    
    default T apply(Space<T> space) {
	T x = init(space);
	int i=0;
	Spuro.trace(this, i, x);
	while( !stop_condition(i) ) {
	    x = variation(x);
	    i++;
	    Spuro.trace(this, i, x);
	}
	return x;
    }
}
