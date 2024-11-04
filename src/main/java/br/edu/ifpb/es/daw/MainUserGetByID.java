package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.entities.st.UserST;

import java.time.LocalDate;

public class MainUserGetByID {

	public static void main(String[] args) throws DawException {
		UserSTDAO dao = new UserSTDAO();
		try {
			// Primeiro salvar
			UserST user = new UserST();

			user.setBirthday(LocalDate.now());
			user.setEmail("email@gmail.com");
			user.setFirstName("Sicrano");
			user.setLastName("Silva");
			user.setCity("Esperança");
			user.setCountry("Brasil");
			user.setState("PB");
			user.setStreet("Rua do Centro");
			user.setZipcode("" + System.nanoTime());

			dao.save(user);

			// Depois recuperar pelo identificador

			UserST resultado = dao.getByID(user.getId());

			System.out.println(user.equals(resultado));
		} finally {
			dao.close();
		}
	}

}
