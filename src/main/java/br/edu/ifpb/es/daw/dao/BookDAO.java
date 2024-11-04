package br.edu.ifpb.es.daw.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import br.edu.ifpb.es.daw.entities.Book;

public class BookDAO extends DAO {
	
	public void save(Book book) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
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
		} finally {
			em.close();
		}
	}

	public Book update(Book book) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
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
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Book book) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			book = em.find(Book.class, book.getId());
			em.remove(book);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover o livro.", pe);
		} finally {
			em.close();
		}
	}

	public Book getByID(long bookId) throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		Book resultado = null;
		try {
			resultado = em.find(Book.class, bookId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar o livro com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Book> getAll() throws PersistenciaDawException {
		EntityManager em = getEntityManager();
		List<Book> resultado = null;
		try {
			TypedQuery<Book> query = em.createQuery("SELECT u FROM Book u", Book.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todos os livros.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}

}
