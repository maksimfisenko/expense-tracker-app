package dev.app.expense_tracker.user.source.service.impl;

import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.repository.SourceRepository;
import dev.app.expense_tracker.user.source.service.SourceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceServiceImpl implements SourceService {

    SourceRepository sourceRepository;

    @Override
    public Source createSource(Source source) {
        return sourceRepository.save(source);
    }

    @Override
    public Source updateSource(Source source) {
        return sourceRepository.save(source);
    }

    @Override
    public Optional<Source> findSourceById(Long id) {
        return sourceRepository.findById(id);
    }

    @Override
    public void deleteSource(Long id) {
        sourceRepository.deleteById(id);
    }
}
