package br.edu.ifpb.es.daw;

import java.util.List;

import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;

public class MainBookGetAll {

	public static void main(String[] args) throws DawException {

		BookDAO dao = new BookDAO();
		try {
			List<Book> books = dao.getAll();

			for (Book Book : books) {
				System.out.println(Book);
			}

		} finally {
			dao.close();
		}
	}

}
