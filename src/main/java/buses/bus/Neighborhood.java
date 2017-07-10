package buses.bus;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Neighborhood {

	@Id
	@GeneratedValue
	private Long id;
	public String name;

	@OneToMany(mappedBy = "neighborhood")
	private Set<BusStop> stop;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<BusStop> getStop() {
		return stop;
	}

	@Override
	public String toString() {
		return (name + stop);
	}

	private Neighborhood(){
	}
	
	public Neighborhood(String name) {
		this.name = name;
	}

}
