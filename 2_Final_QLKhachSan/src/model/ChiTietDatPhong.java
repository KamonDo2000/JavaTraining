package model;

import java.time.LocalDate;

public class ChiTietDatPhong {
	private String iDChiTietDP;
	private String tenDoan;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private long giaSuDungPhong;
	private long giaSuDungDichVu;
	private long tongTien;

	public ChiTietDatPhong() {
		super();
	}

	/**
	 * @return the iDChiTietDP
	 */
	public String getiDChiTietDP() {
		return iDChiTietDP;
	}

	/**
	 * @param iDChiTietDP the iDChiTietDP to set
	 */
	public void setiDChiTietDP(String iDChiTietDP) {
		this.iDChiTietDP = iDChiTietDP;
	}

	/**
	 * @return the tenDoan
	 */
	public String getTenDoan() {
		return tenDoan;
	}

	/**
	 * @param tenDoan the tenDoan to set
	 */
	public void setTenDoan(String tenDoan) {
		this.tenDoan = tenDoan;
	}

	/**
	 * @return the checkIn
	 */
	public LocalDate getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public LocalDate getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the giaSuDungPhong
	 */
	public long getGiaSuDungPhong() {
		return giaSuDungPhong;
	}

	/**
	 * @param giaSuDungPhong the giaSuDungPhong to set
	 */
	public void setGiaSuDungPhong(long giaSuDungPhong) {
		this.giaSuDungPhong = giaSuDungPhong;
		this.tongTien = this.giaSuDungPhong + this.giaSuDungDichVu;
	}

	/**
	 * @return the giaSuDungDichVu
	 */
	public long getGiaSuDungDichVu() {
		return giaSuDungDichVu;
	}

	/**
	 * @param giaSuDungDichVu the giaSuDungDichVu to set
	 */
	public void setGiaSuDungDichVu(long giaSuDungDichVu) {
		this.giaSuDungDichVu = giaSuDungDichVu;
		this.tongTien = this.giaSuDungPhong + this.giaSuDungDichVu;
	}

	/**
	 * @return the TongTien
	 */
	public long getTongTien() {
		return tongTien;
	}

}
