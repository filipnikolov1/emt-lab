package mk.ukim.finki.emtlab.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAuthorDto(
        @NotBlank(message = "Name is required.")
        String name,
        @NotBlank(message = "Surname is required.")
        String surname,
        @NotNull(message = "Country is required.")
        Long countryId
) {
}
