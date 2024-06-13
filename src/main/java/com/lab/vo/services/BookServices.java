package com.lab.vo.services;

import com.lab.vo.controller.PersonController;
import com.lab.vo.converter.DozerConverter;
import com.lab.vo.data.model.Book;
import com.lab.vo.data.vo.v1.BookVO;
import com.lab.vo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {


    @Autowired
    BookRepository bookRepository;


    public BookVO create(BookVO book) {
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
        return vo;
    }

    public List<BookVO> findAll() {
        var books = DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);

        books.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return books;
    }

    public BookVO findById(UUID id) {

        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        BookVO vo =  DozerConverter.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO update(BookVO book) {
        var entity = bookRepository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(UUID id) {
        Book entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        bookRepository.delete(entity);
    }
    public List<BookVO> createMultiple(List<BookVO> books) {
        List<Book> entities = books.stream()
                .map(book -> DozerConverter.parseObject(book, Book.class))
                .collect(Collectors.toList());

        List<Book> savedEntities = bookRepository.saveAll(entities);

        List<BookVO> vos = savedEntities.stream()
                .map(entity -> DozerConverter.parseObject(entity, BookVO.class))
                .collect(Collectors.toList());

        return vos;
    }


}
