package tourguide;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gpsUtil.GpsUtil;
import rewardCentral.RewardCentral;
import tripPricer.TripPricer;

@Configuration
public class TourGuideModule {
	
	@Bean
	public RewardCentral rewardCentral() {
		return new RewardCentral();
	}
	
	@Bean
	public GpsUtil gpsUtil() {
    	Locale.setDefault(Locale.ENGLISH);
		return new GpsUtil();
	}
	
	@Bean
	public TripPricer tripPricer() {
		return new TripPricer();
	}
}
