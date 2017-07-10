package buses.bus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.swing.text.html.HTML.Tag;

@Entity
public class BusStop {

	@Id
	@GeneratedValue
	public Long id;

	public String name;
	private String imageURL;

	@Lob
	String review;

	public BusStop(Neighborhood vicVillage, String name, String string, String string2, buses.bus.Tag uncovered, buses.bus.Tag residential, buses.bus.Tag local) {
		this.name = name;
	}
	
	@ManyToMany
	private Set<Tag> tag;

	@ManyToOne
	private Neighborhood neighborhood;

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getReview() {
		return review;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public BusStop(Neighborhood neighborhood, String name, String imageURL, String review, Tag... tag) {
		this.name = name;
		this.imageURL = imageURL;
		this.review = review;
		this.neighborhood = neighborhood;
		this.tag = new HashSet<>(Arrays.asList(tag));
	}

	@Override
	public String toString() {
		return (neighborhood + " " + name + " " + imageURL + " " + review);
	}

	

	public void add(Tag toAdd) {
	tag.add(toAdd);
		
	}

	public static void save(BusStop busStop) {
		// TODO Auto-generated method stub
		
	}


}
