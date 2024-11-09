package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.st.UserST;

import java.util.List;

public interface UserSTDAO {

    void save(UserST user) throws PersistenciaDawException;

    UserST update(UserST user) throws PersistenciaDawException;

    void delete(Integer userId) throws PersistenciaDawException;

    UserST getByID(Integer userId) throws PersistenciaDawException;

    List<UserST> getAll() throws PersistenciaDawException;
}
