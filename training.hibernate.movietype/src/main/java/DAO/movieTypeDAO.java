package DAO;

import java.util.List;

import entities.MovieType;

public interface movieTypeDAO {
	List<MovieType> GetMovieTypeByTypeID(int id);

	List<MovieType> GetAllMovieType();

	void UpdateMovieTypeByID(int id, MovieType room);

	void DeleteMovieTypeById(int id);

	void InsertMovieType(MovieType room);
}
