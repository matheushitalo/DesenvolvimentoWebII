package unipam.edu.br.projetoFinal.repository;

import unipam.edu.br.projetoFinal.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // JpaRepository já fornece: save, findById, findAll, deleteById, etc.
}
