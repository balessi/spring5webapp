package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	private String addressLine1;
	private String city;
	private String state;
	private Integer zip;

	@OneToMany
	private Set<Book> books;

	public Publisher() {
		super();
		this.books = new HashSet<>();
	}

	public Publisher(String addressLine11, String city1, String state1, int zip1) {
		this();
		this.addressLine1 = addressLine11;
		this.city = city1;
		this.state = state1;
		this.zip = Integer.valueOf(zip1);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id1) {
		this.id = id1;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine11) {
		this.addressLine1 = addressLine11;
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

	public Integer getZip() {
		return this.zip;
	}

	public void setZip(Integer zip1) {
		this.zip = zip1;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books1) {
		this.books = books1;
	}

	@Override
	public int hashCode() {
		return this.id != null ? this.id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return this.id != null ? this.id.equals(other.id) : other.id == null;
	}

	@Override
	public String toString() {
		return GeneralUtilities.toJsonString(this);
	}

}
