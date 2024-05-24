package dev.app.expense_tracker.user.source.usecase;

import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;

public interface SourceAddUseCase {
    SourceResponse addSource(SourceAddRequest sourceAddRequest);
}
