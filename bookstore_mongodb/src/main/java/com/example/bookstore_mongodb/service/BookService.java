package com.example.bookstore_mongodb.service;

import com.example.bookstore_mongodb.entity.Book;
import com.example.bookstore_mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // create a book
    public Book createBook(Book book) {
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    // get all books
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        allBooks = bookRepository.findAll();
        return allBooks;
    }

    // delete a book by id
    public String deleteBook(String id) {

        // Check if book exists BY ID
        Optional<Book> foundBook = bookRepository.findById(id);

        if (foundBook.isPresent() == false) {
            return "not found";
        }

        // the book exists
        Book theBook = foundBook.get();
        bookRepository.delete(theBook);

        return "deleted";
    }

}