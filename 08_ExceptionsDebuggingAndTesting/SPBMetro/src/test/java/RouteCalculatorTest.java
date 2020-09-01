import core.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class RouteCalculatorTest {
	
	private List<Station> route;
	
	private StationIndex stationIndex;
	private RouteCalculator routeCalculator;
	
	@Before
	public void setUp() throws Exception {
 
/**									Схема метро.
		 
		(Первая)                    								  		(Вторая)
	Девяткино[1.1]															Парнас[2.1]
			|																	|
			|					   			(Третья)							|
Лесная[1.2]/Беговая[3.1]   ---	Новокрестовская[3.2]   ---	Приморская[3.3] / Купчино[2.2]
			|                                                 					|
			|                                                 					|
	Академическая[1.3]                                               		Озерки[2.3]
			|																	|
			|																	|
	Политехническая[1.4] 													Удельная[2.4]
			|																	|
			|																	|
	Площадь Мужества[1.5]													Пионерская[2.5]
      
*/
      
		stationIndex = new StationIndex();
		route = new ArrayList<>();

		//линии
		Line line1 = new Line(1, "Первая");
		Line line2 = new Line(2, "Вторая");
		Line line3 = new Line(3, "Третья");

		//станции
		Station station11 = new Station("Девяткино", line1);
		Station station12 = new Station("Лесная", line1);
		Station station13 = new Station("Академическая", line1);
		Station station14 = new Station("Политехническая", line1);
		Station station15 = new Station("Площадь Мужества", line1);

		Station station21 = new Station("Парнас", line2);
		Station station22 = new Station("Купчино", line2);
		Station station23 = new Station("Озерки", line2);
		Station station24 = new Station("Удельная", line2);
		Station station25 = new Station("Пионерская", line2);

		Station station31 = new Station("Беговая", line3);
		Station station32 = new Station("Новокрестовская", line3);
		Station station33 = new Station("Приморская", line3);
		
		//добавляем станции в линии
		line1.addStation(station11);
		line1.addStation(station12);
		line1.addStation(station13);
		line1.addStation(station14);
		line1.addStation(station15);

		line2.addStation(station21);
		line2.addStation(station22);
		line2.addStation(station23);
		line2.addStation(station24);
		line2.addStation(station25);

		line3.addStation(station31);
		line3.addStation(station32);
		line3.addStation(station33);

		//добавляем линии
		stationIndex.addLine(line1);
		stationIndex.addLine(line2);
		stationIndex.addLine(line3);

		//добавляем станции в метро
		for (Station station : line1.getStations())
			stationIndex.addStation(station);
		for (Station station : line2.getStations())
			stationIndex.addStation(station);
		for (Station station : line3.getStations())
			stationIndex.addStation(station);
		
		//добавляем пересадки в метро
		stationIndex.addConnection(new ArrayList<>(Arrays.asList(station12, station31)));
		stationIndex.addConnection(new ArrayList<>(Arrays.asList(station33, station22)));
		
		routeCalculator = new RouteCalculator(stationIndex);
		
		//маршрут для теста testCalculateDuration()
		String str = "Площадь Мужества,Политехническая,Академическая,Лесная" +
						",Беговая,Новокрестовская,Приморская,Купчино,Парнас";
		route.addAll(RouteByString.getRouteByString(str, stationIndex));
	}
	
	@Test
	public void testCalculateDuration() { // тест - расчет времени
		
		double actual = RouteCalculator.calculateDuration(route);
		double expected = 22.;
		double delta = 0.5;
		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testShortestRoute() { // тест - кратчайший маршрут
		
		List<Station> shortestRoute = new ArrayList<>();
		
		String str = "Девяткино,Лесная,Беговая,Новокрестовская,Приморская,Купчино";
		shortestRoute.addAll(RouteByString.getRouteByString(str, stationIndex));

		List<Station> actual = routeCalculator.getShortestRoute(
				stationIndex.getStation("Девяткино", 1),
				stationIndex.getStation("Купчино", 2));
		
		System.out.println(shortestRoute);
		System.out.println(actual);
		
		assertEquals(shortestRoute, actual);
	}
	
	@Test
	public void testRouteOnTheLine() { // тест - маршрут  без пересадок
		
		List<Station> routeOnTheLine = new ArrayList<>();
		
		String str = "Пионерская,Удельная,Озерки,Купчино,Парнас";
		routeOnTheLine.addAll(RouteByString.getRouteByString(str, stationIndex));
		
		List<Station> actual = routeCalculator.getShortestRoute(
				stationIndex.getStation("Пионерская"),
				stationIndex.getStation("Парнас"));
		
		System.out.println(routeOnTheLine);
		System.out.println(actual);
		
		assertEquals(routeOnTheLine, actual);
	}
	
	@Test
	public void testRouteWithOneConnection() { // тест - с одной пересадкой
		
		List<Station> routeWithOneConnection = new ArrayList<>();
		
		String str = "Девяткино,Лесная,Беговая,Новокрестовская";
		routeWithOneConnection.addAll(RouteByString.getRouteByString(str, stationIndex));
		
		List<Station> actual = routeCalculator.getShortestRoute(
				stationIndex.getStation("Девяткино"),
				stationIndex.getStation("Новокрестовская"));
		
		assertEquals(routeWithOneConnection, actual);
	}
	
	@Test
	public void testRouteWithTwoConnections() { // тест - с двумя пересадками
		List<Station> routeWithTwoConnections = new ArrayList<>();
		String str =
				"Парнас,Купчино,Приморская,Новокрестовская,Беговая,Лесная,Академическая";
		routeWithTwoConnections.addAll(RouteByString.getRouteByString(str, stationIndex));
		
		List<Station> actual = routeCalculator.getShortestRoute(
				stationIndex.getStation("Парнас"),
				stationIndex.getStation("Академическая"));
		
		assertEquals(routeWithTwoConnections, actual);
	}
	
	@Test
	public void testNullStation() { // тест - станции нет
		Station emptyStation = null;
		Station actual = stationIndex.getStation("Международная");
		
		assertEquals(emptyStation, actual);
	}
	
}