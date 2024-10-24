package DAO;

import java.util.List;

import entities.Movie;

public interface movieDAO {
	Movie GetMovieByID(String id);

	List<Movie> GetAllMovie();

	void UpdateMovieByID(String id, Movie room);

	void DeleteMovieById(String id);

	void InsertMovie(Movie room);
}
