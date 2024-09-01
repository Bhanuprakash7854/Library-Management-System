package com.library.Library.Management.System.service;

import com.library.Library.Management.System.model.Book;
import com.library.Library.Management.System.model.User;
import com.library.Library.Management.System.repo.BookRepo;
import com.library.Library.Management.System.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;

    public Book addBook(Book book)
    {
        return bookRepo.save(book);
    }

    public Optional<Book> getBook(int id)
    {
        return bookRepo.findById(id);
    }

    public List<Book> getAllBooks()
    {
        return bookRepo.findAll();
    }

    public ResponseEntity<Optional<Book>> deleteBook(int id)
    {
        if(bookRepo.existsById(id))
        {
            Optional<Book> temp = bookRepo.findById(id);
            bookRepo.deleteById(id);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Book> borrowBook(int bookId,int userId)
    {
        User user = userRepo.findById(userId).orElse(null);
        Book book = bookRepo.findById(bookId).orElse(null);

        if(user != null && book != null && book.isBorrowed() == false)
        {
            book.setBorrowed(true);
            book.setBorrowedBy(user);
            bookRepo.save(book);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Book> returnBook(int bookId)
    {
        Book book = bookRepo.findById(bookId).orElse(null);
        if(book!=null && book.isBorrowed()==true)
        {
            book.setBorrowed(false);
            book.setBorrowedBy(null);
            bookRepo.save(book);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
