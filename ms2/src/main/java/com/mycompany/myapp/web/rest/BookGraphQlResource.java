package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.IBookService;

import com.mycompany.myapp.service.dto.BookInputDTO;
import com.mycompany.myapp.domain.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BookGraphQlResource {
    private IBookService service;

    public BookGraphQlResource(IBookService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Book> books(){
        return service.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument int id){
        return service.getBookById(id);
    }

    @MutationMapping
    public Book createBook(@Argument("input") BookInputDTO input) {
        Book b = new Book();
        b.setTitle(input.getTitle());
        b.setAuthor(input.getAuthor());
        b.setDescription(input.getDescription());
        b.setIsbn(input.getIsbn());
        b.setPrice(input.getPrice());
        b.setStock(input.getStock());
        return service.createBook(b);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Book book){
         service.deleteBook(book);
         return true;
    }

@MutationMapping
public Book updateBook(@Argument int id, @Argument("input") BookInputDTO input) {
    Book b = new Book();
    b.setTitle(input.getTitle());
    b.setAuthor(input.getAuthor());
    b.setDescription(input.getDescription());
    b.setIsbn(input.getIsbn());
    b.setPrice(input.getPrice());
    b.setStock(input.getStock());
    return service.updateBook(id, b);
}
}
