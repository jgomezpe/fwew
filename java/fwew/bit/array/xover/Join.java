package fwew.bit.array.xover;
import fwew.population.Variation;
import kopii.Copier;
import speco.bit.array.Array;

/**
 * <p>Title: Join</p>
 * <p>Description: Joins two chromosomes</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author Jonatan Gomez
 * @version 1.0
 */

public class Join implements Variation<Array>{
    /**
     * Apply the simple point crossover operation over the given genomes
     * @param c1 The first parent
     * @param c2 The second parent
     */
    public Array[] apply(Array c1, Array c2) {
	try {
	    Array genome1 = (Array)Copier.apply(c1);
	    genome1.add(c2);
	    Array genome2 = (Array)Copier.apply(c2);
	    genome2.add(c1);
	    return new Array[]{genome1, genome2};
	} catch (Exception e) {}
	return null;
    }

    @Override
    public Array[] apply(Array[] parents) {
	return apply(parents[0],parents[1]);
    }

    @Override
    public int[] signature() { return new int[] {2,2}; }
}