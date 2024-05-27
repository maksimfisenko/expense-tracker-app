package dev.app.expense_tracker.common.mapper;

public interface Mapper<D, S> {
    D map(S s);
}
