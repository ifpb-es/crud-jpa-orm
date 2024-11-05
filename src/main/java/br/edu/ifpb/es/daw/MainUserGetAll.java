package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.dao.impl.UserSTDAOImpl;
import br.edu.ifpb.es.daw.entities.st.UserST;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUserGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			UserSTDAO dao = new UserSTDAOImpl(emf);
			List<UserST> usuarios = dao.getAll();

			for (UserST user : usuarios) {
				System.out.println(user);
			}
		}
	}

}
