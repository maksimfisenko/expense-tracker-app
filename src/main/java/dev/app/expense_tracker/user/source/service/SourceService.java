package dev.app.expense_tracker.user.source.service;

import dev.app.expense_tracker.user.source.model.Source;

import java.util.Optional;

public interface SourceService {
    Source createSource(Source source);
    Source updateSource(Source source);
    Optional<Source> findSourceById(Long id);
    void deleteSource(Long id);
}
