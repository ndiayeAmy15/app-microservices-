package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Book;
import com.mycompany.myapp.repository.BookRepository;
import com.mycompany.myapp.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book bookUpd= bookRepository.getById(id);
        bookUpd.setTitle(book.getTitle());
        bookUpd.setAuthor(book.getAuthor());
        bookUpd.setDescription(book.getDescription());
        bookUpd.setPrice(book.getPrice());
        bookUpd.setStock(book.getStock());
        return bookRepository.save(bookUpd);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
