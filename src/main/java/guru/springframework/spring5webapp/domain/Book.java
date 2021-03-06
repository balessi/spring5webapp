package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import guru.springframework.spring5webapp.util.GeneralUtilities;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String isbn;

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;

	@ManyToOne
	private Publisher publisher;

	// JPA needs a zero args constructor
	public Book() {
		super();
		this.authors = new HashSet<>();
	}

	public Book(String title1, String isbn1) {
		this();
		this.title = title1;
		this.isbn = isbn1;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id1) {
		this.id = id1;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title1) {
		this.title = title1;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn1) {
		this.isbn = isbn1;
	}

	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors1) {
		this.authors = authors1;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher1) {
		this.publisher = publisher1;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Book other = (Book) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return GeneralUtilities.toJsonString(this);
	}

}
