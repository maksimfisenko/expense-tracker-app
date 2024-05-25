package dev.app.expense_tracker.user.source.web;

import dev.app.expense_tracker.user.source.usecase.SourceAddUseCase;
import dev.app.expense_tracker.user.source.usecase.SourceDeleteUseCase;
import dev.app.expense_tracker.user.source.usecase.SourceEditUseCase;
import dev.app.expense_tracker.user.source.usecase.SourceFindUseCase;
import dev.app.expense_tracker.user.source.web.model.*;
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
    SourceFindUseCase sourceFindUseCase;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SourcePageResponse findUserSources(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        SourceFindRequest sourceFindRequest = new SourceFindRequest(page, limit);
        return sourceFindUseCase.findSources(sourceFindRequest);
    }

}
