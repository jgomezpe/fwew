package fwew.population;
import fwew.vr.Variation;

public class LocalVariationWrap<T> implements Variation<T[]> {
    protected Variation<T> local;
    
    public LocalVariationWrap(Variation<T> local) {
	this.local = local;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T[] apply(T[] x) {
	return (T[])new Object[] {local.apply(x[0])};
    }

    @Override
    public int[] signature() { return new int[] {1,1}; }
}