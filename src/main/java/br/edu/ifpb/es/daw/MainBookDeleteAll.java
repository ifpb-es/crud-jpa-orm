package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;


public class MainBookDeleteAll {

	public static void main(String[] args) throws DawException {
		BookDAO dao = new BookDAO();
		try {
			List<Book> books = dao.getAll();
			for (Book book : books) {
				dao.delete(book);
			}
		} finally {
			dao.close();
		}
	}
	
	
}
