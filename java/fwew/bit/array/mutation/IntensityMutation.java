package fwew.bit.array.mutation;

import kopii.Copier;
import fwew.vr.Variation;
import hazarda.Hazarda;
import hazarda.integer.Random;
import speco.bit.array.Array;

public class IntensityMutation implements Variation<Array>{

    protected Random ri;
	
    public IntensityMutation(Random ri) { this.ri = ri; }
	
    @Override
    public Array apply(Array gen) {
	gen = (Array)Copier.apply(gen);
	int[] idx = Hazarda.sample(gen.size(), ri.next());
	for( int i=0; i<idx.length; i++ ){ gen.not(idx[i]); }
	return gen;
    }	
    @Override
    public int[] signature() { return new int[] {1,1}; }
}