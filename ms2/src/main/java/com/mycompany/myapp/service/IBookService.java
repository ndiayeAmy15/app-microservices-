package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book createBook(Book book);
    Book updateBook(int id ,Book book);
    void deleteBook(Book book);
}
