package tourguide.model;

import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import tourguide.rewardservice.RewardService;

public class AttractionDistance extends Attraction implements Comparable<AttractionDistance> {

	private Location fromLocation;
	
	public AttractionDistance(Location fromLocation, Attraction toAttraction) {
		super(toAttraction.attractionName, toAttraction.city, toAttraction.state, toAttraction.latitude, toAttraction.longitude);
		this.fromLocation = fromLocation;
	}
	
	@Override
	public int compareTo(AttractionDistance that) {
		// Check that we are comparing to the same reference
		if (this.fromLocation.latitude != that.fromLocation.latitude 
				|| this.fromLocation.longitude != that.fromLocation.longitude) {
			throw new RuntimeException("Trying to compare attractions based on different origins");
		}
		double distanceToThis = RewardService.getDistance(this.fromLocation, new Location(this.latitude, this.longitude));
		double distanceToThat = RewardService.getDistance(that.fromLocation, new Location(that.latitude, that.longitude));
		return Double.valueOf(distanceToThis).compareTo(Double.valueOf(distanceToThat));
	}
}
