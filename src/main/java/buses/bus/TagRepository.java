package buses.bus;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository <Tag, Long> {

	Tag findByName(String name);

	Long countByName(String name);

}

