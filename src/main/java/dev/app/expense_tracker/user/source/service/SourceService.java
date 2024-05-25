package dev.app.expense_tracker.user.source.service;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.model.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SourceService {
    Source createSource(Source source);
    Source updateSource(Source source);
    Optional<Source> findSourceById(Long id);
    void deleteSource(Long id);
    Page<Source> findAllSources(UserProfile owner, Pageable pageable);
}
