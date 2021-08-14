package fwew.population;

import speco.function.Function;

public interface Variation<T> extends Function<T[], T[]> {
    int[] signature();
}
