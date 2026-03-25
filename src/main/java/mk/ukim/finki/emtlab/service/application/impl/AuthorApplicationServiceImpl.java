package mk.ukim.finki.emtlab.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.CreateAuthorDto;
import mk.ukim.finki.emtlab.model.dto.DisplayAuthorDto;
import mk.ukim.finki.emtlab.service.application.AuthorApplicationService;
import mk.ukim.finki.emtlab.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorApplicationServiceImpl implements AuthorApplicationService {

    private final AuthorService authorService;

    @Override
    public List<DisplayAuthorDto> findAll() {
        return authorService.findAll()
                .stream()
                .map(DisplayAuthorDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id)
                .map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto authorDto) {
        return authorService.save(authorDto)
                .map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto) {
        return authorService.update(id, authorDto)
                .map(DisplayAuthorDto::from);
    }

    @Override
    public void deleteById(Long id) {
        authorService.deleteById(id);
    }
}