package dev.app.expense_tracker.user.source.usecase;

import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;

import java.util.Collection;

public interface SourceFindUseCase {
    Collection<SourceResponse> findSources();
}
