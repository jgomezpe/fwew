package nsgl.bit.variation;

import nsgl.bit.array.Array;
import nsgl.integer.random.Random;
import nsgl.random.Shuffle;
import nsgl.search.variation.Variation_1_1;

public class IntensityMutation implements Variation_1_1<Array>{

	protected Random ri;
	
	public IntensityMutation(Random ri) { this.ri = ri; }
	
	@Override
	public Array apply(Array gen) {
		gen = (Array)gen.copy();
		int k = ri.next() % gen.size();
		int[] idx = Shuffle.apply(gen.size());
		
		for( int i=0; i<k; i++ ){ gen.not(idx[i]); }
		return gen;
	}	
}