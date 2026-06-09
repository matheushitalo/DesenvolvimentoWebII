package unipam.edu.br.projetoFinal.repository;

import unipam.edu.br.projetoFinal.model.Livro;
import unipam.edu.br.projetoFinal.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    
    Optional<Livro> findByTitulo(String titulo);

    
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    
    List<Livro> findByCategoria(Categoria categoria);
}
