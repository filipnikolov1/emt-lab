package mk.ukim.finki.emtlab.service.domain;

import mk.ukim.finki.emtlab.model.domain.Author;
import mk.ukim.finki.emtlab.model.dto.CreateAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(CreateAuthorDto authorDto);
    Optional<Author> update(Long id, CreateAuthorDto authorDto);
    void deleteById(Long id);
}
