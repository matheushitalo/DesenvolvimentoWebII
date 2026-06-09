package unipam.edu.br.projetoFinal.controller;

import unipam.edu.br.projetoFinal.model.Categoria;
import unipam.edu.br.projetoFinal.model.Livro;
import unipam.edu.br.projetoFinal.repository.CategoriaRepository;
import unipam.edu.br.projetoFinal.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository,
                           CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {
        Long categoriaId = livro.getCategoria().getId();
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Categoria não encontrada: id " + categoriaId));
        livro.setCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/busca/titulo")
    public ResponseEntity<?> buscarPorTituloExato(@RequestParam String valor) {
        return livroRepository.findByTitulo(valor)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Livro não encontrado com título: " + valor));
    }

    @GetMapping("/busca/titulo-parcial")
    public ResponseEntity<List<Livro>> buscarPorTituloParcial(@RequestParam String valor) {
        return ResponseEntity.ok(livroRepository.findByTituloContainingIgnoreCase(valor));
    }

    @GetMapping("/busca/categoria/{id}")
    public ResponseEntity<?> buscarPorCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Categoria não encontrada: id " + id));
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        return ResponseEntity.ok(livros);
    }
}
