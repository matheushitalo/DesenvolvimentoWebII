package unipam.edu.br.projetoFinal.repository;

import unipam.edu.br.projetoFinal.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // JpaRepository já fornece: save, findById, findAll, deleteById, etc.
}
