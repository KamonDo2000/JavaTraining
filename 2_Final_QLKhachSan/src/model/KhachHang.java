package model;

import java.time.LocalDate;

public class KhachHang {
	private String iDKhachHang;
	private String hoVaTen;
	private String cmnd;
	private String soDienThoai;
	private String email;
	private LocalDate ngaySinh;
	private String gioiTinh;

	public KhachHang() {
		super();
	}

	/**
	 * @return the iDKhachHang
	 */
	public String getiDKhachHang() {
		return iDKhachHang;
	}

	/**
	 * @param iDKhachHang the iDKhachHang to set
	 */
	public void setiDKhachHang(String iDKhachHang) {
		this.iDKhachHang = iDKhachHang;
	}

	/**
	 * @return the hoVaTen
	 */
	public String getHoVaTen() {
		return hoVaTen;
	}

	/**
	 * @param hoVaTen the hoVaTen to set
	 */
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	/**
	 * @return the cmnd
	 */
	public String getCmnd() {
		return cmnd;
	}

	/**
	 * @param cmnd the cmnd to set
	 */
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}

	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ngaySinh
	 */
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
