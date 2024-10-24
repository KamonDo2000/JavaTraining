package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cinema_Room_Detail")
public class CinemaRoomDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Cinema_Room_Detail_ID")
	private int cinemaRoomDetailID;

	@Column(name = "Room_Rate")
	private int roomRate;

	@Column(name = "Active_Date")
	private Date activeDate;

	@Column(name = "Room_Description", length = 250)
	private String roomDescription;

	@OneToOne
	@JoinColumn(name = "Cinema_Room_ID")
	private CinemaRoom cinemaRoomInfo;

	public CinemaRoomDetail(int cinemaRoomDetailID, int roomRate, Date activeDate, String roomDescription,
			CinemaRoom cinemaRoomInfo) {
		super();
		this.cinemaRoomDetailID = cinemaRoomDetailID;
		this.roomRate = roomRate;
		this.activeDate = activeDate;
		this.roomDescription = roomDescription;
		this.cinemaRoomInfo = cinemaRoomInfo;
	}

	public CinemaRoomDetail() {
		super();
	}

	public int getCinemaRoomDetailID() {
		return cinemaRoomDetailID;
	}

	public void setCinemaRoomDetailID(int cinemaRoomDetailID) {
		this.cinemaRoomDetailID = cinemaRoomDetailID;
	}

	public int getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(int roomRate) {
		this.roomRate = roomRate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public CinemaRoom getCinemaRoomInfo() {
		return cinemaRoomInfo;
	}

	public void setCinemaRoomInfo(CinemaRoom cinemaRoomInfo) {
		this.cinemaRoomInfo = cinemaRoomInfo;
	}

	@Override
	public String toString() {
		return "CinemaRoomDetail [cinemaRoomDetailID=" + cinemaRoomDetailID + ", roomRate=" + roomRate + ", activeDate="
				+ activeDate + ", roomDescription=" + roomDescription + ", cinemaRoomInfo=" + cinemaRoomInfo + "]";
	}

}
