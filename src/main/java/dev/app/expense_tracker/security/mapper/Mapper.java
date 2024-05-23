package dev.app.expense_tracker.security.mapper;

public interface Mapper<D, S> {
    D map(S s);
}
