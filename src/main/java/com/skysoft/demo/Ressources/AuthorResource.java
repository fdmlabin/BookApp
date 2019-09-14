package com.skysoft.demo.Ressources;

import com.skysoft.demo.Repository.AuthorRepository;
import com.skysoft.demo.Repository.BookRepository;
import com.skysoft.demo.domain.Author;
import com.skysoft.demo.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Author.
 */
@RestController
@RequestMapping("/api")
public class AuthorResource {

    private final Logger log = LoggerFactory.getLogger(AuthorResource.class);

    private static final String ENTITY_NAME = "author";

    @Inject
    private AuthorService authorService;

    @Inject
    private BookRepository bookRepository;

//    private final AuthorService authorService;
//    private final BookRepository bookRepository;
//
//    public AuthorResource(AuthorService authorService, BookRepository bookRepository) {
//        this.authorService = authorService;
//        this.bookRepository = bookRepository;
//    }


    /**
     * POST  /authors : Create a new author.
     *
     * @param author the author to create
     * @return the ResponseEntity with status 201 (Created) and with body the new author, or with status 400 (Bad Request) if the author has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) throws URISyntaxException {
        log.debug("REST request to save Author : {}", author);
        if (author.getId() != null) {
            return author;
        }
        Author result = authorService.save(author);
        return result;
    }

    /**
     * PUT  /authors : Updates an existing author.
     *
     * @param author the author to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated author,
     * or with status 400 (Bad Request) if the author is not valid,
     * or with status 500 (Internal Server Error) if the author couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) throws URISyntaxException {
        log.debug("REST request to update Author : {}", author);
        if (author.getId() == null) {
            return createAuthor(author);
        }
        Author result = authorService.save(author);
        return result;
    }

    /**
     * GET  /authors : get all the authors.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of authors in body
     */
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        log.debug("REST request to get a page of Authors");
        List<Author> authors = authorService.findAll();


        //boucle permettant de liste le nombre de livre
//        for (Author author:authors){
//            author.setNbLivre(bookRepository.countByAuthorId(author.getId()));
//        }

        return authors;
    }


    //Rest permettant de retourner le nombre de livre en fonction de l'id d'un auteur
    @GetMapping("/nombreLivres/{id}")
    public Integer getNbLivre(@PathVariable Long id) {
       return bookRepository.countByAuthorId(id);
    }


    //Rest permettant de retourner le nombre de livre en fonction de l'id d'un auteur
    @GetMapping("/nombreLivres")
    public Integer getNbLivres(@RequestParam(name = "id") Long id) {
        return bookRepository.countByAuthorId(id);
    }

    /**
     * GET  /authors/:id : get the "id" author.
     *
     * @param id the id of the author to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the author, or with status 404 (Not Found)
     */
    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        log.debug("REST request to get Author : {}", id);
        Author author = authorService.findOne(id);
        return author;
    }

    /**
     * DELETE  /authors/:id : delete the "id" author.
     *
     * @param id the id of the author to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/deleteAuthors/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAuthor(@PathVariable Long id) {
        log.debug("REST request to delete Author : {}", id);
        authorService.delete(id);
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAllAuthors2(){
        return authorService.findOne((long) 6);
    }
}
