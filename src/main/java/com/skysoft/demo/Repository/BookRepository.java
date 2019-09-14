package com.skysoft.demo.Repository;


import com.skysoft.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the Book entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Long> {

    int countByAuthorId(Long id);

}
