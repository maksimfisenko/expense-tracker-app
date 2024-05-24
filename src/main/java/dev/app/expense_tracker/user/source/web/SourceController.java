package dev.app.expense_tracker.user.source.web;

import dev.app.expense_tracker.user.source.usecase.SourceAddUseCase;
import dev.app.expense_tracker.user.source.usecase.SourceDeleteUseCase;
import dev.app.expense_tracker.user.source.usecase.SourceEditUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceEditRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sources")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceController {

    SourceAddUseCase sourceAddUseCase;
    SourceEditUseCase sourceEditUseCase;
    SourceDeleteUseCase sourceDeleteUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SourceResponse createSource(@Valid @RequestBody SourceAddRequest sourceAddRequest) {
        return sourceAddUseCase.addSource(sourceAddRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SourceResponse updateSource(@Valid @RequestBody SourceEditRequest sourceEditRequest) {
        return sourceEditUseCase.editSource(sourceEditRequest);
    }

    @DeleteMapping("/{sourceId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSource(@PathVariable("sourceId") Long sourceId) {
        sourceDeleteUseCase.deleteSource(sourceId);
    }

}
