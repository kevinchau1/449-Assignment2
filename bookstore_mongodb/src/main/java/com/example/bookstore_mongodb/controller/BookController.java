package com.example.bookstore_mongodb.controller;

import com.example.bookstore_mongodb.entity.Book;
import com.example.bookstore_mongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // delete a book by id
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {

        // call the service and store the result in a variable
        String result = bookService.deleteBook(id);

        // check what the service returned
        if (result == "deleted") {
            // book was deleted successfully
            Map<String, String> response = new HashMap<String, String>();
            response.put("message", "book was deleted successfully");
            return ResponseEntity.ok(response);
        }

        if (result == "not found") {
            // book was not found
            Map<String, String> response = new HashMap<String, String>();
            response.put("error", "book was not found with that id");
            return ResponseEntity.status(404).body(response);
        }

        // Fallback error, safety feature just in case.
        return ResponseEntity.status(500).body("something went wrong");
    }
}