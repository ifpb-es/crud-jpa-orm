package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;


public class MainBookGetByID {
	
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

			// Depois recuperar pelo identificador
			
			Book resultado = dao.getByID(book.getId());
			
			System.out.println(book.equals(resultado));
		} finally {
			dao.close();
		}
	}

}