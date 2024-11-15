package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_BOOK", uniqueConstraints = { 
		@UniqueConstraint(name = "UC_LIVRO", columnNames = { "TITLE", "DESCRIPTION" })
})
public class Book {

	@Id
	@GeneratedValue(generator = "jpa_book_seq")
	@SequenceGenerator(name = "jpa_book_seq", sequenceName = "tb_book_seq")
	private Long id;

	private String title;

	private Float price;

	private String description;

	private String isbn;

	private Integer nbOfPage;

	private Boolean illustrations;

	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return Objects.equals(title, book.title) &&
				Objects.equals(price, book.price) &&
				Objects.equals(description, book.description) &&
				Objects.equals(isbn, book.isbn) &&
				Objects.equals(nbOfPage, book.nbOfPage) &&
				Objects.equals(illustrations, book.illustrations);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, price, description, isbn, nbOfPage, illustrations);
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", isbn='" + isbn + '\'' +
				", nbOfPage=" + nbOfPage +
				", illustrations=" + illustrations +
				'}';
	}

}
