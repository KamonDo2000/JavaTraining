package model;

public class Phong {
	private String iDPhong;
	private long giaPhong;
	private int soNguoiTrongPhong;
	private int soNguoiToiDa;
	private String trangThai;
	private String iDLoaiPhong;

	public Phong() {
		super();
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
	 * @return the soNguoiTrongPhong
	 */
	public int getSoNguoiTrongPhong() {
		return soNguoiTrongPhong;
	}

	/**
	 * @param soNguoiTrongPhong the soNguoiTrongPhong to set
	 */
	public void setSoNguoiTrongPhong(int soNguoiTrongPhong) {
		this.soNguoiTrongPhong = soNguoiTrongPhong;
	}

	/**
	 * @return the soNguoiToiDa
	 */
	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}

	/**
	 * @param soNguoiToiDa the soNguoiToiDa to set
	 */
	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
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
	 * @return the iDLoaiPhong
	 */
	public String getiDLoaiPhong() {
		return iDLoaiPhong;
	}

	/**
	 * @param iDLoaiPhong the iDLoaiPhong to set
	 */
	public void setiDLoaiPhong(String iDLoaiPhong) {
		this.iDLoaiPhong = iDLoaiPhong;
	}

}
