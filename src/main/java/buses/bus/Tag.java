package buses.bus;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "tag")
	private Set<BusStop> stop;

	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<BusStop> getStop() {
		return stop;
	}
	
	public Tag() {
	}

}
