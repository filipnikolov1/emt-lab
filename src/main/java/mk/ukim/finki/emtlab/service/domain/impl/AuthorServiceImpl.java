package mk.ukim.finki.emtlab.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.domain.Author;
import mk.ukim.finki.emtlab.model.dto.CreateAuthorDto;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import mk.ukim.finki.emtlab.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(CreateAuthorDto authorDto) {
        return countryRepository.findById(authorDto.countryId())
                .map(country -> {
                    Author author = new Author();
                    author.setName(authorDto.name());
                    author.setSurname(authorDto.surname());
                    author.setCountry(country);
                    return authorRepository.save(author);
                });
    }

    @Override
    public Optional<Author> update(Long id, CreateAuthorDto authorDto) {
        return authorRepository.findById(id)
                .flatMap(author -> countryRepository.findById(authorDto.countryId())
                        .map(country -> {
                            author.setName(authorDto.name());
                            author.setSurname(authorDto.surname());
                            author.setCountry(country);
                            return authorRepository.save(author);
                        }));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
