package mk.ukim.finki.emtlab.service.application;

import mk.ukim.finki.emtlab.model.dto.DisplayBookDetailsViewDto;

import java.util.List;
import java.util.Optional;

public interface BookDetailsViewApplicationService {
    List<DisplayBookDetailsViewDto> findAll();
    Optional<DisplayBookDetailsViewDto> findById(Long id);
}