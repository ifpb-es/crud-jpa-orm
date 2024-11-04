package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.entities.st.UserST;

import java.util.List;

public class MainUserGetAll {

	public static void main(String[] args) throws DawException {

		UserSTDAO dao = new UserSTDAO();
		try {
			List<UserST> usuarios = dao.getAll();

			for (UserST user : usuarios) {
				System.out.println(user);
			}

		} finally {
			dao.close();
		}
	}

}
