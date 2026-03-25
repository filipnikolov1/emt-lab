package mk.ukim.finki.emtlab.service.application;

import mk.ukim.finki.emtlab.model.dto.CreateAuthorDto;
import mk.ukim.finki.emtlab.model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<DisplayAuthorDto> findAll();
    Optional<DisplayAuthorDto> findById(Long id);
    Optional<DisplayAuthorDto> save(CreateAuthorDto authorDto);
    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto);
    void deleteById(Long id);
}