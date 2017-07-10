package buses.bus;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BusController {

	@Resource
	private NeighborhoodRepository neighborhoodRepo;

	@Resource
	private BusStopRepository busStopRepo;
	
	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/neighborhood")
	public String retrieveNeighborhoods(Model model) {
		model.addAttribute("orange", neighborhoodRepo.findAll());
		return "neighborhood";
	}

	@RequestMapping("/busStop")
	public String retrieveSingleNeighborhood(@RequestParam("id") long id, Model model) {
		model.addAttribute("yellow", neighborhoodRepo.findOne(id));
		return "busStopsInThisNeighborhood";
	}

	@RequestMapping("/review")
	public String retrieveBusStop(@RequestParam("id") long id, Model model) {
		BusStop selectedBusStop = busStopRepo.findOne(id);
		model.addAttribute("green", selectedBusStop);
		return "currentReview";
	}
	@RequestMapping("/tag")
	public String fetchTagDetail(@RequestParam("id") Long id, Model model) {
		Tag selectedTag = tagRepo.findOne(id);
		model.addAttribute(selectedTag);
		return "tag";
	}

	@RequestMapping("/tags")
	public String fetchTags(Model model) {
		model.addAttribute("tag", tagRepo.findAll());
		return "tagList";
	}

	@RequestMapping("/createTag")
	public String createTag(@RequestParam(value = "id") Long id, String name) {
		Tag tag = new Tag(name);
		tagRepo.save(tag);
		BusStop busStop = busStopRepo.findOne(id);
		BusStop.save(busStop);
		return "redirect:/busStop?id=" + id;
	}

	public BusController() {
		// TODO Auto-generated constructor stub
	}

}
