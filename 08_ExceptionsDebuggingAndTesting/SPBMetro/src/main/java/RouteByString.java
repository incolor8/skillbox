import core.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteByString {
	
	public static List<Station> getRouteByString(String stringRoute, StationIndex stationIndex) {
		List<Station> route = new ArrayList<>();
		String[] stations = stringRoute.split(",+");
		
		for (String str : stations) {
			route.add(stationIndex.getStation(str));
		}
		return route;
	}
}
