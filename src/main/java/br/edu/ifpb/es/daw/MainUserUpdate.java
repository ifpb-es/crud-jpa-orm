package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.entities.st.UserST;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainUserUpdate {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			UserSTDAO dao = new UserSTDAO(emf);
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

			System.out.println(user);

			// Depois atualizar
			user.setFirstName("Beltrano");
			user.setStreet("Rua da Igreja");

			dao.update(user);

			System.out.println(user);
		}
	}

}
