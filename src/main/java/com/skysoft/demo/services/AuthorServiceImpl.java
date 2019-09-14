package com.skysoft.demo.services;

import com.skysoft.demo.Repository.AuthorRepository;
import com.skysoft.demo.domain.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by francis on 8/22/19.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {

//        Author author1 = authorRepository.getOne(author.getId());
//
//        if(author1 != null) throw new RuntimeException("Author Already exists");

        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findOne(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
