package fwew;

public interface StopCondition<T> {
    boolean check(ModularSearch<T> search, T current, int iter);
}
