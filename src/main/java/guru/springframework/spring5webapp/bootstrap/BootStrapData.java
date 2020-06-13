package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository1, BookRepository bookRepository1) {
		super();
		this.authorRepository = authorRepository1;
		this.bookRepository = bookRepository1;
	}

	@SuppressWarnings("boxing")
	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEjb = new Book("J2EE Development without EJB", "321321");
		rod.getBooks().add(noEjb);
		noEjb.getAuthors().add(rod);
		this.authorRepository.save(rod);
		this.bookRepository.save(noEjb);
	
		System.out.println("Bootstrapped database");
		System.out.printf("Number of authors: %d\n", this.authorRepository.count());
		System.out.printf("Number of books: %d\n", this.bookRepository.count());
	}

}
