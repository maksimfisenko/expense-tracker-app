package dev.app.expense_tracker.user.source.usecase;

import dev.app.expense_tracker.user.source.web.model.SourceFindRequest;
import dev.app.expense_tracker.user.source.web.model.SourcePageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SourceFindUseCase {
    SourcePageResponse findSources(@Valid SourceFindRequest sourceFindRequest);
}
