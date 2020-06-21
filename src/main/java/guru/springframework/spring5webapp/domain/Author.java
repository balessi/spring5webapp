package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import guru.springframework.spring5webapp.util.GeneralUtilities;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;

	// JPA needs a zero args constructor
	public Author() {
		super();
		this.books = new HashSet<>();
	}

	public Author(String firstName1, String lastName1) {
		this();
		this.firstName = firstName1;
		this.lastName = lastName1;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id1) {
		this.id = id1;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName1) {
		this.firstName = firstName1;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName1) {
		this.lastName = lastName1;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books1) {
		this.books = books1;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return GeneralUtilities.toJsonString(this);
	}

}
