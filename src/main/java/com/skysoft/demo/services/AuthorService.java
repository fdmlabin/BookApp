package com.skysoft.demo.services;

import com.skysoft.demo.domain.Author;

import java.util.List;

/**
 * Created by francis on 8/22/19.
 */
public interface AuthorService {

    /**
     * Save a author.
     *
     * @param author
     *            the entity to save
     * @return the persisted entity
     */
    Author save(Author author);

    /**
     * Get all the authors.
     *
     * @return the list of entities
     */
    List<Author> findAll();

    /**
     * Get the "id" authors.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    Author findOne(Long id);

    /**
     * Delete the "id" authors.
     *
     * @param id
     *            the id of the entity
     */
    void delete(Long id);
}
