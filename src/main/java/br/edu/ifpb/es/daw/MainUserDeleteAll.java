package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.entities.st.UserST;

import java.util.List;

public class MainUserDeleteAll {

	public static void main(String[] args) throws DawException {
		UserSTDAO dao = new UserSTDAO();
		try {
			List<UserST> usuarios = dao.getAll();
			for (UserST usuario : usuarios) {
				dao.delete(usuario);
			}
		} finally {
			dao.close();
		}
	}

}
