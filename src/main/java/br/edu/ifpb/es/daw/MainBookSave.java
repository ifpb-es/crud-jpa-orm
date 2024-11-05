package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainBookSave {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			BookDAO dao = new BookDAO(emf);
			Book book = new Book();
			
			book.setTitle("Título " + System.nanoTime());
			book.setDescription("Descrição " + System.nanoTime());
			book.setIsbn("" + System.nanoTime());
			book.setNbOfPage(123);
			book.setPrice(100f);
			book.setIllustrations(true);
			
			System.out.println(book);
			
			dao.save(book);

			System.out.println(book);
		}
	}

}
