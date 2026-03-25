package mk.ukim.finki.emtlab.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.DisplayBookDetailsViewDto;
import mk.ukim.finki.emtlab.repository.BookDetailsViewRepository;
import mk.ukim.finki.emtlab.service.application.BookDetailsViewApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookDetailsViewApplicationServiceImpl implements BookDetailsViewApplicationService {

    private final BookDetailsViewRepository bookDetailsViewRepository;

    @Override
    public List<DisplayBookDetailsViewDto> findAll() {
        return bookDetailsViewRepository.findAll()
                .stream()
                .map(DisplayBookDetailsViewDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDetailsViewDto> findById(Long id) {
        return bookDetailsViewRepository.findById(id)
                .map(DisplayBookDetailsViewDto::from);
    }
}