package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;


public class MainBookDelete {
	
	public static void main(String[] args) throws DawException {
		BookDAO dao = new BookDAO();
		try {
			// Primeiro salvar
			Book book = new Book();

			book.setTitle("Título " + System.nanoTime());
			book.setDescription("Descrição " + System.nanoTime());
			book.setIsbn("" + System.nanoTime());
			book.setNbOfPage(123);
			book.setPrice(100f);
			book.setIllustrations(true);
			
			dao.save(book);

			System.out.println(dao.getAll().size());
			
			
			// Depois apagar
			
			dao.delete(book);
			
			System.out.println(dao.getAll().size());
		} finally {
			dao.close();
		}
	}

}
