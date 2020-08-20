package tourguide.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import tourguide.model.AttractionData;
import tourguide.model.User;
import tourguide.model.VisitedLocationData;

@FeignClient(name="gps", url="http://localhost:8080")
public interface GpsClient {

	@PatchMapping("/trackAllUserLocations")
	public List<User> trackAllUserLocations(@RequestBody List<User> userList);

	@GetMapping("/getAllAttractions")
	public List<AttractionData> getAllAttractions();

	@GetMapping("/getCurrentUserLocation")
	public VisitedLocationData getCurrentUserLocation(@RequestParam("userId") String userId);
}
