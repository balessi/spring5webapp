package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Publisher;

/**
 * @author Bruno S. Alessi <bruno_alessi@yahoo.com.br>
 * @since 2020-06-13
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
	//
}
