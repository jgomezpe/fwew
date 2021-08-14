package fwew.bit.array.mutation;

import fwew.local.Variation;
import hazarda.integer.Uniform;
import kopii.Copier;
import speco.bit.array.Array;

/**
 * <p>Title: SingleBitMutation</p>
 * <p>Description: Flips one bit in the chromosome. The flipped bit is randomly selected
 * with uniform probability distribution</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class SingleBitMutation implements Variation<Array> {
	protected Uniform g = new Uniform(0);
	/**
	 * Flips a bit in the given genome
	 * @param genome Genome to be modified
	 * @return Index of the flipped bit
	 */
	public Array apply(Array genome) {
		genome = (Array)Copier.apply(genome);
		int pos = -1;
		try{
			g.set(genome.size());
			pos = g.next();
			genome.not(pos);
			return genome;
		}catch(Exception e){ System.err.println("[Mutation]" + e.getMessage()); }          
		return null;
	}
}