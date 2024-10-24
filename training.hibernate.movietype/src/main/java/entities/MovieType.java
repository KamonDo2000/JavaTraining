package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE_TYPE")
public class MovieType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

	@Id
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private Type typeMovie;

	@Column(name = "MT_DESCRIPTION")
	String description;

	public MovieType() {
		super();
	}

	public MovieType(Movie movie, Type typeMovie, String description) {
		super();
		this.movie = movie;
		this.typeMovie = typeMovie;
		this.description = description;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Type getTypeMovie() {
		return typeMovie;
	}

	public void setTypeMovie(Type typeMovie) {
		this.typeMovie = typeMovie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MovieType [movie=" + movie.getActor() + ", typeMovie=" + typeMovie.getName() + ", description="
				+ description + "]";
	}

}
