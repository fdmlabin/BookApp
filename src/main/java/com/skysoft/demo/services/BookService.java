package com.skysoft.demo.services;

import com.skysoft.demo.domain.Book;

import java.util.List;

/**
 * Created by francis on 8/22/19.
 */
public interface BookService {

    /**
     * Save a book.
     *
     * @param book
     *            the entity to save
     * @return the persisted entity
     */
    Book save(Book book);

    /**
     * Get all the book.
     *
     * @return the list of entities
     */
    List<Book> findAll();

    /**
     * Get the "id" book.
     *
     * @param id
     *            the id of the entity
     * @return the entity
     */
    Book findOne(Long id);

    /**
     * Delete the "id" book.
     *
     * @param id
     *            the id of the entity
     */
    void delete(Long id);
}
