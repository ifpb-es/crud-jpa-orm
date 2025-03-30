package br.edu.ifpb.es.daw.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public abstract class AbstractDAOImpl {

	private EntityManagerFactory emf;

	public AbstractDAOImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
