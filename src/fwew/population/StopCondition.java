package fwew.population;

public interface StopCondition<T> {
    boolean check(ModularSearch<T> search, int iter);
}
