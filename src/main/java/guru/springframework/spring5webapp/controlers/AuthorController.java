package guru.springframework.spring5webapp.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-21
 */
@Controller
public class AuthorController {

	private final AuthorRepository authRepo;

	public AuthorController(final AuthorRepository authRepo1) {
		super();
		this.authRepo = authRepo1;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", this.authRepo.findAll());
		return "authors/list";
	}
	
}
