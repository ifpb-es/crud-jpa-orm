package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MainBookUpdate {
	
	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			BookDAO dao = new BookDAO(emf);
			// Primeiro salvar
			Book book = new Book();
			
			book.setTitle("Título " + System.nanoTime());
			book.setDescription("Descrição " + System.nanoTime());
			book.setIsbn("" + System.nanoTime());
			book.setNbOfPage(123);
			book.setPrice(100f);
			book.setIllustrations(true);

			dao.save(book);

			System.out.println(book);
			
			// Depois atualizar
			book.setTitle("Outro título " + System.nanoTime());
			
			dao.update(book);
			
			System.out.println(book);
		}
	}

}
