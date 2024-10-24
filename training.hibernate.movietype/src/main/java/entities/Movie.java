package entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
	@Column(name = "MOVIE_ID", length = 10)
	private String id;

	@Column(name = "ACTOR", length = 255)
	private String actor;

	@Column(name = "CONTENT", length = 1000)
	private String content;

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "DURATION", precision = 5, scale = 2)
	private double duration;

	@Column(name = "FROM_DATE")
	private Date fromDate;

	@Column(name = "TO_DATE")
	private Date toDate;

	@Column(name = "MOVIE_PRODUCTION_COMPANY", length = 255)
	private String movProd;

	@Column(name = "VERSION", length = 255)
	private String ver;

	@Column(name = "MOVIE_NAME_ENG", length = 255)
	private String nameENG;

	@Column(name = "MOVIE_NAME_VN", length = 255, unique = true)
	private String nameVN;

	@Column(name = "LARGE_IMAGE", length = 255, unique = true)
	private String larIMG;

	@Column(name = "SMALL_IMAGE", length = 255)
	private String smaIMG;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MovieType> movieTypes;

	public Movie() {
		super();
	}

	public Movie(String id, String actor, String content, String director, double duration, Date fromDate, Date toDate,
			String movProd, String ver, String nameENG, String nameVN, String larIMG, String smaIMG) {
		super();
		this.id = id;
		this.actor = actor;
		this.content = content;
		this.director = director;
		this.duration = duration;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movProd = movProd;
		this.ver = ver;
		this.nameENG = nameENG;
		this.nameVN = nameVN;
		this.larIMG = larIMG;
		this.smaIMG = smaIMG;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the movProd
	 */
	public String getMovProd() {
		return movProd;
	}

	/**
	 * @param movProd the movProd to set
	 */
	public void setMovProd(String movProd) {
		this.movProd = movProd;
	}

	/**
	 * @return the ver
	 */
	public String getVer() {
		return ver;
	}

	/**
	 * @param ver the ver to set
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}

	/**
	 * @return the nameENG
	 */
	public String getNameENG() {
		return nameENG;
	}

	/**
	 * @param nameENG the nameENG to set
	 */
	public void setNameENG(String nameENG) {
		this.nameENG = nameENG;
	}

	/**
	 * @return the nameVN
	 */
	public String getNameVN() {
		return nameVN;
	}

	/**
	 * @param nameVN the nameVN to set
	 */
	public void setNameVN(String nameVN) {
		this.nameVN = nameVN;
	}

	/**
	 * @return the larIMG
	 */
	public String getLarIMG() {
		return larIMG;
	}

	/**
	 * @param larIMG the larIMG to set
	 */
	public void setLarIMG(String larIMG) {
		this.larIMG = larIMG;
	}

	/**
	 * @return the smaIMG
	 */
	public String getSmaIMG() {
		return smaIMG;
	}

	/**
	 * @param smaIMG the smaIMG to set
	 */
	public void setSmaIMG(String smaIMG) {
		this.smaIMG = smaIMG;
	}

	/**
	 * @return the movieTypes
	 */
	public Set<MovieType> getMovieTypes() {
		return movieTypes;
	}

	/**
	 * @param movieTypes the movieTypes to set
	 */
	public void setMovieTypes(Set<MovieType> movieTypes) {
		this.movieTypes = movieTypes;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", actor=" + actor + ", content=" + content + ", director=" + director
				+ ", duration=" + duration + ", fromDate=" + fromDate + ", toDate=" + toDate + ", movProd=" + movProd
				+ ", ver=" + ver + ", nameENG=" + nameENG + ", nameVN=" + nameVN + ", larIMG=" + larIMG + ", smaIMG="
				+ smaIMG + "]";
	}

}
