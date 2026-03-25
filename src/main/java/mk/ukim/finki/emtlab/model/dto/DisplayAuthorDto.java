package mk.ukim.finki.emtlab.model.dto;

import mk.ukim.finki.emtlab.model.domain.Author;
import mk.ukim.finki.emtlab.model.domain.Country;

public record DisplayAuthorDto(
        Long id,
        String name,
        String surname,
        Country country
) {
    public static DisplayAuthorDto from(Author author) {
        return new DisplayAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getCountry()
        );
    }
}
