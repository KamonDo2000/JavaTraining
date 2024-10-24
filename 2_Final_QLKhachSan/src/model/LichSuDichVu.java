package model;

import java.time.LocalDate;

public class LichSuDichVu {
	private String iDSuDungDichVu;
	private String trangThai;
	private int soLuong;
	private LocalDate ngaySuDung;
	private String iDChiTietDP;
	private String iDPhong;
	private String iDDichVu;

	public LichSuDichVu() {
		super();
	}

	/**
	 * @return the iDSuDungDichVu
	 */
	public String getiDSuDungDichVu() {
		return iDSuDungDichVu;
	}

	/**
	 * @param iDSuDungDichVu the iDSuDungDichVu to set
	 */
	public void setiDSuDungDichVu(String iDSuDungDichVu) {
		this.iDSuDungDichVu = iDSuDungDichVu;
	}

	/**
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	/**
	 * @return the ngaySuDung
	 */
	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	/**
	 * @param ngaySuDung the ngaySuDung to set
	 */
	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
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
	 * @return the iDPhong
	 */
	public String getiDPhong() {
		return iDPhong;
	}

	/**
	 * @param iDPhong the iDPhong to set
	 */
	public void setiDPhong(String iDPhong) {
		this.iDPhong = iDPhong;
	}

	/**
	 * @return the iDDichVu
	 */
	public String getiDDichVu() {
		return iDDichVu;
	}

	/**
	 * @param iDDichVu the iDDichVu to set
	 */
	public void setiDDichVu(String iDDichVu) {
		this.iDDichVu = iDDichVu;
	}

}
