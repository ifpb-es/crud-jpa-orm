package br.edu.ifpb.es.daw.dao.impl;

import java.util.List;

import br.edu.ifpb.es.daw.dao.AbstractDAOImpl;
import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import br.edu.ifpb.es.daw.entities.Book;

public class BookDAOImpl extends AbstractDAOImpl implements BookDAO {

	public BookDAOImpl(EntityManagerFactory emf) {
		super(emf);
	}

	public void save(Book book) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				em.persist(book);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar salvar o livro.", pe);
			}
		}
	}

	public Book update(Book book) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Book resultado = book;
			try {
				resultado = em.merge(book);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar atualizar o livro.", pe);
			}
			return resultado;
		}
	}

	public void delete(Long bookId) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				Book book = em.find(Book.class, bookId);
				em.remove(book);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover o livro.", pe);
			}
		}
	}

	public Book getByID(Long bookId) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			Book resultado = null;
			try {
				resultado = em.find(Book.class, bookId);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar o livro com base no ID.", pe);
			}
			return resultado;
		}
	}

	public List<Book> getAll() throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			List<Book> resultado = null;
			try {
				TypedQuery<Book> query = em.createQuery("SELECT u FROM Book u", Book.class);
				resultado = query.getResultList();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todos os livros.", pe);
			}
			return resultado;
		}
	}

}
