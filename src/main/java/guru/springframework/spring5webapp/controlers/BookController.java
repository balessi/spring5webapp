package guru.springframework.spring5webapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-21
 */
@Controller
public class BookController {

	private final BookRepository bookRepo;

	public BookController(BookRepository bookRepo1) {
		super();
		this.bookRepo = bookRepo1;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", this.bookRepo.findAll());
		return "books/list";
	}

}
