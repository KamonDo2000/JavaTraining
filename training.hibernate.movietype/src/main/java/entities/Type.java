package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID")
	int id;

	@Column(name = "TYPE_NAME", length = 255, unique = true)
	String name;

	@Column(name = "TYPE_DESCRIPTION", length = 255)
	String description;

	@OneToMany(mappedBy = "typeMovie", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MovieType> movieTypes;

	public Type() {
		super();
	}

	public Type(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<MovieType> getMovieTypes() {
		return movieTypes;
	}

	public void setMovieTypes(Set<MovieType> movieTypes) {
		this.movieTypes = movieTypes;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
