package com.skysoft.demo.Repository;

import com.skysoft.demo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


/**
 * Spring Data JPA repository for the Author entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findById(Long id);
}
