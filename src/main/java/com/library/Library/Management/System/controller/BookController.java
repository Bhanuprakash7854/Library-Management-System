package com.library.Library.Management.System.controller;

import com.library.Library.Management.System.model.Book;
import com.library.Library.Management.System.model.User;
import com.library.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController
{
    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable int id)
    {
        return bookService.getBook(id);
    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Optional<Book>> deleteBook(@PathVariable int id)
    {
        return bookService.deleteBook(id);
    }

    @PostMapping("{bid}/borrow/{uid}")
    public ResponseEntity<Book> borrowBook(@PathVariable int bid,@PathVariable int uid)
    {
        return bookService.borrowBook(bid,uid);
    }

    @PostMapping("{bid}/return")
    public ResponseEntity<Book> returnBook(@PathVariable int bid)
    {
        return bookService.returnBook(bid);
    }
}
