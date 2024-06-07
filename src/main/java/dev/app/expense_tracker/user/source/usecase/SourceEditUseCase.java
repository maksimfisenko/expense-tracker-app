package dev.app.expense_tracker.user.source.usecase;

import dev.app.expense_tracker.user.source.web.model.SourceEditRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;

public interface SourceEditUseCase {
    SourceResponse editSource(SourceEditRequest sourceEditRequest);
}
