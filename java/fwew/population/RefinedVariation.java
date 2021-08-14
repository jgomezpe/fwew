package fwew.population;


public class RefinedVariation<T> implements Variation<T> {
	protected fwew.local.Variation<T> refining;
	protected Variation<T> refined;
	
	public RefinedVariation( Variation<T> refined, fwew.local.Variation<T> refining ) {
		this.refined = refined;
		this.refining = refining;
	}
	
	@Override
	public T[] apply(T[] pop) {
	    T[] children = refined.apply(pop);
	    for( int i=0; i<children.length; i++ )
		children[i] = refining.apply(children[i]);
	    return children;
	}

	public int[] signature(){ return refined.signature(); }		
}