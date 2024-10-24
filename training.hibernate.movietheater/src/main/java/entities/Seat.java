package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Seat_ID")
	private int seatID;

	@Column(name = "Seat_Column", length = 255)
	private String seatColumn;

	@Column(name = "Seat_Row")
	private int seatRow;

	@Column(name = "Seat_Status", length = 255)
	private String seatStatus;

	@Column(name = "Seat_Type", length = 255)
	private String seatType;

	@ManyToOne
	@JoinColumn(name = "Cinema_Room_ID")
	private CinemaRoom cinemaInfo;

	public Seat() {
		super();
	}

	public Seat(int seatID, String seatColumn, int seatRow, String seatStatus, String seatType, CinemaRoom cinemaInfo) {
		super();
		this.seatID = seatID;
		this.seatColumn = seatColumn;
		this.seatRow = seatRow;
		this.seatStatus = seatStatus;
		this.seatType = seatType;
		this.cinemaInfo = cinemaInfo;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public CinemaRoom getCinemaInfo() {
		return cinemaInfo;
	}

	public void setCinemaInfo(CinemaRoom cinemaInfo) {
		this.cinemaInfo = cinemaInfo;
	}

	@Override
	public String toString() {
		return "Seat [seatID=" + seatID + ", seatColumn=" + seatColumn + ", seatRow=" + seatRow + ", seatStatus="
				+ seatStatus + ", seatType=" + seatType + ", cinemaInfo=" + cinemaInfo + "]";
	}

}
