package model;

import java.time.LocalDate;

public class LichSuDatPhong {
	private String iDDatPhong;
	private String trangThai;
	private String truongPhong;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String iDKhachHang;
	private String iDChiTietDP;
	private String iDPhong;
	private long giaPhong;
	private long ngayLuuTru;

	public LichSuDatPhong() {
		super();
	}

	/**
	 * @return the iDDatPhong
	 */
	public String getiDDatPhong() {
		return iDDatPhong;
	}

	/**
	 * @param iDDatPhong the iDDatPhong to set
	 */
	public void setiDDatPhong(String iDDatPhong) {
		this.iDDatPhong = iDDatPhong;
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
	 * @return the truongPhong
	 */
	public String getTruongPhong() {
		return truongPhong;
	}

	/**
	 * @param truongPhong the truongPhong to set
	 */
	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}

	/**
	 * @return the ngayBatDau
	 */
	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	/**
	 * @param ngayBatDau the ngayBatDau to set
	 */
	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	/**
	 * @return the ngayKetThuc
	 */
	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	/**
	 * @param ngayKetThuc the ngayKetThuc to set
	 */
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
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
	 * @return the giaPhong
	 */
	public long getGiaPhong() {
		return giaPhong;
	}

	/**
	 * @param giaPhong the giaPhong to set
	 */
	public void setGiaPhong(long giaPhong) {
		this.giaPhong = giaPhong;
	}

	/**
	 * @return the ngayLuuTru
	 */
	public long getNgayLuuTru() {
		return ngayLuuTru;
	}

	/**
	 * @param ngayLuuTru the ngayLuuTru to set
	 */
	public void setNgayLuuTru(long ngayLuuTru) {
		this.ngayLuuTru = ngayLuuTru;
	}

}
