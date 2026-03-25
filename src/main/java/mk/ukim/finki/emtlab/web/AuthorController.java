package mk.ukim.finki.emtlab.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emtlab.model.dto.CreateAuthorDto;
import mk.ukim.finki.emtlab.model.dto.DisplayAuthorDto;
import mk.ukim.finki.emtlab.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emtlab.service.application.AuthorApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorApplicationService authorApplicationService;

    @GetMapping
    public ResponseEntity<List<DisplayAuthorDto>> findAll() {
        return ResponseEntity.ok(authorApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAuthorDto> findById(@PathVariable Long id) {
        return authorApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<DisplayAuthorDto> save(@RequestBody @Valid CreateAuthorDto authorDto) {
        return authorApplicationService.save(authorDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisplayAuthorDto> update(@PathVariable Long id,
                                                   @RequestBody @Valid CreateAuthorDto authorDto) {
        return authorApplicationService.update(id, authorDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorApplicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}