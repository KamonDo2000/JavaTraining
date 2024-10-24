package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cinema_Room")
public class CinemaRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Cinema_Room_ID")
	private int cinemaRoomID;

	@Column(name = "Cinema_Room_Name", length = 255, nullable = true, unique = true)
	private String cinemaRoomName;

	@Column(name = "Seat_Quantity")
	private int seatQuantity;

	@OneToOne(mappedBy = "cinemaRoomInfo")
	private CinemaRoomDetail cinemaRoomDetailInfo;

	@OneToMany(mappedBy = "cinemaInfo")
	private Set<Seat> seatList = new HashSet<>();

	public CinemaRoom(int cinemaRoomID, String cinemaRoomName, int seatQuantity) {
		super();
		this.cinemaRoomID = cinemaRoomID;
		this.cinemaRoomName = cinemaRoomName;
		this.seatQuantity = seatQuantity;
	}

	public CinemaRoom() {
		super();
	}

	public int getCinemaRoomID() {
		return cinemaRoomID;
	}

	public void setCinemaRoomID(int cinemaRoomID) {
		this.cinemaRoomID = cinemaRoomID;
	}

	public String getCinemaRoomName() {
		return cinemaRoomName;
	}

	public void setCinemaRoomName(String cinemaRoomName) {
		this.cinemaRoomName = cinemaRoomName;
	}

	public int getSeatQuantity() {
		return seatQuantity;
	}

	public void setSeatQuantity(int seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public CinemaRoomDetail getCinemaRoomDetailInfo() {
		return cinemaRoomDetailInfo;
	}

	public void setCinemaRoomDetailInfo(CinemaRoomDetail cinemaRoomDetailInfo) {
		this.cinemaRoomDetailInfo = cinemaRoomDetailInfo;
	}

	public Set<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(Set<Seat> seatList) {
		this.seatList = seatList;
	}

	@Override
	public String toString() {
		return "cinemaRoomID=" + cinemaRoomID + ", cinemaRoomName=" + cinemaRoomName + ", seatQuantity=" + seatQuantity;
	}

}
