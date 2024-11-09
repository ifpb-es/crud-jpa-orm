package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Book;

import java.util.List;

public interface BookDAO {

    void save(Book book) throws PersistenciaDawException;

    Book update(Book book) throws PersistenciaDawException;

    void delete(Long bookId) throws PersistenciaDawException;

    Book getByID(Long bookId) throws PersistenciaDawException;

    List<Book> getAll() throws PersistenciaDawException;

}
