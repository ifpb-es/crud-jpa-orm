package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainBookGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			BookDAO dao = new BookDAO(emf);
			List<Book> books = dao.getAll();

			for (Book Book : books) {
				System.out.println(Book);
			}
		}
	}

}
