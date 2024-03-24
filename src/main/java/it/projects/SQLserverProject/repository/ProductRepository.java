package it.projects.SQLserverProject.repository;

import it.projects.SQLserverProject.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAll();

    Optional<Product> findById(String code);

    Optional< List<Product> > findAllByDescriptionContainingIgnoreCase(String searchText);

    Optional< Product > findByCodeContainingIgnoreCase(String code);
}
