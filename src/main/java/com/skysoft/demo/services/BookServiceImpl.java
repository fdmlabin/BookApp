package com.skysoft.demo.services;

import com.skysoft.demo.Repository.BookRepository;
import com.skysoft.demo.domain.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by francis on 8/22/19.
 */

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
