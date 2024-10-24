package main;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import DAO.MovieDAOiml;
import DAO.MovieTypeDaoIml;
import DAO.TypeDAOIml;
import entities.Movie;
import entities.MovieType;
import entities.Type;

public class Main {

	private static MovieDAOiml mDao = new MovieDAOiml();
	private static TypeDAOIml tDao = new TypeDAOIml();
	private static MovieTypeDaoIml tmDao = new MovieTypeDaoIml();

	public static void main(String[] args) {

		Type type1 = new Type("Comedy", "Funny movies");
		Type type2 = new Type("Sci-Fi", "Movies with futuristic themes");
		Type type3 = new Type("Action", "High-intensity movies with lots of explosions");

		@SuppressWarnings("deprecation")
		Movie movie1 = new Movie("m001", "Tom Cruise", "Action movie", "Steven Spielberg", 120.5, new Date(2023, 5, 1),
				new Date(2023, 6, 30), "Warner Bros.", "2D", "Top Gun: Maverick", "Phi công siêu đẳng",
				"top_gun_maverick_large.jpg", "top_gun_maverick_small.jpg");

		@SuppressWarnings("deprecation")
		Movie movie2 = new Movie("m002", "Margot Robbie", "Drama", "David Fincher", 135.0, new Date(2024, 2, 14),
				new Date(2024, 4, 30), "Netflix", "3D", "Babylon", "Babylon", "babylon_large.jpg", "babylon_small.jpg");

		Set<Type> listType = new HashSet<>(Arrays.asList(type1, type2, type3));
		Set<Type> listType2 = new HashSet<>(Arrays.asList(type1, type2));

//		insert

		tDao.InsertType(type1);
		tDao.InsertType(type2);
		tDao.InsertType(type3);

		mDao.InsertMovie(movie1);
		mDao.InsertMovie(movie2);

		listType.forEach(e -> {
			MovieType movT = new MovieType(movie1, e, "Day la types cua firm");
			tmDao.InsertMovieType(movT);
		});
		listType2.forEach(e -> {
			MovieType movT = new MovieType(movie2, e, "cac type cua firm 2");
			tmDao.InsertMovieType(movT);
		});

//		get data

//		System.out.println(mDao.GetMovieByID("m001").toString());
//		System.out.println();
//		System.out.println(tDao.GetTypeByID(2).toString());
//		System.out.println();
//		tmDao.GetMovieTypeByTypeID(1).forEach(e -> {
//			System.out.println(e.toString());
//		});

//		get All data

//		tmDao.GetAllMovieType().forEach(e -> {
//			System.out.println(e.toString());
//		});
//		System.out.println();
//		tDao.GetAllType().forEach(e -> {
//			System.out.println(e.toString());
//		});
//		System.out.println();
//		mDao.GetAllMovie().forEach(e -> {
//			System.out.println(e.toString());
//		});

//		delete
//		mDao.DeleteMovieById("m001");
//		tDao.DeleteTypeById(1);

//		update
		Type typeUpdate = new Type("Updatess", "Movies update futuristic themes");
		tDao.UpdateTypeByID(2, typeUpdate);

		Movie movieUpdate = new Movie("m001", "Up", "date", "dateeeee", 120.5, null, null, "f", "2D", "f", "s", "d",
				"d");
		mDao.UpdateMovieByID("m001", movieUpdate);
	}

}
