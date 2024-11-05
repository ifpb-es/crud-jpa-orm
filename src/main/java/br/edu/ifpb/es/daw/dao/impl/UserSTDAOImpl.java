package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.DAO;
import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.st.UserST;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserSTDAOImpl extends DAO implements UserSTDAO {

	public UserSTDAOImpl(EntityManagerFactory emf) {
		super(emf);
	}

	public void save(UserST user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				em.persist(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar salvar o usuário.", pe);
			}
		}
	}

	public UserST update(UserST user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			UserST resultado = user;
			try {
				resultado = em.merge(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar atualizar o usuário.", pe);
			}
			return resultado;
		}
	}

	public void delete(UserST user) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			try {
				user = em.find(UserST.class, user.getId());
				em.remove(user);
				transaction.commit();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar remover o usuário.", pe);
			}
		}
	}

	public UserST getByID(int userId) throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			UserST resultado = null;
			try {
				resultado = em.find(UserST.class, userId);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
			}
			return resultado;
		}
	}

	public List<UserST> getAll() throws PersistenciaDawException {
		try(EntityManager em = getEntityManager()) {
			List<UserST> resultado = null;
			try {
				TypedQuery<UserST> query = em.createQuery("SELECT u FROM UserST u", UserST.class);
				resultado = query.getResultList();
			} catch (PersistenceException pe) {
				pe.printStackTrace();
				throw new PersistenciaDawException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
			}
			return resultado;
		}
	}
}
