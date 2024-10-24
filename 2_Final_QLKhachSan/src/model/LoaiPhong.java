package model;

public class LoaiPhong {
	private String iDLoaiPhong;
	private String tenLoaiPhong;

	public LoaiPhong() {
		super();
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

	/**
	 * @return the tenLoaiPhong
	 */
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	/**
	 * @param tenLoaiPhong the tenLoaiPhong to set
	 */
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

}
