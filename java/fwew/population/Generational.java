package fwew.population;

import fwew.vr.Replacement;

public class Generational<T> implements Replacement<T[]>{
	@Override
	public T[] apply(T[] current, T[] next) { return next; }
}