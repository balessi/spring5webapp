package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import guru.springframework.spring5webapp.util.GeneralUtilities;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String city;
	private String state;

	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books;

	public Publisher() {
		super();
		this.books = new HashSet<>();
	}

	public Publisher(String name1, String city1, String state1) {
		this();
		this.name = name1;
		this.city = city1;
		this.state = state1;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id1) {
		this.id = id1;
	}

	public String getName() {
		return this.name;
	}

	public void setAddressLine1(String name1) {
		this.name = name1;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city1) {
		this.city = city1;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state1) {
		this.state = state1;
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
		Publisher other = (Publisher) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return GeneralUtilities.toJsonString(this);
	}

}
