package fwew.population;

public class Generational<T> implements Replacement<T>{
	@Override
	public T[] apply(T[] current, T[] next) { return next; }
}