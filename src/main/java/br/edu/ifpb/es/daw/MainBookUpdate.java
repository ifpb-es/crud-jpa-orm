package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;


public class MainBookUpdate {
	
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

			System.out.println(book);
			
			// Depois atualizar
			book.setTitle("Outro título " + System.nanoTime());
			
			dao.update(book);
			
			System.out.println(book);
		} finally {
			dao.close();
		}
	}

}
