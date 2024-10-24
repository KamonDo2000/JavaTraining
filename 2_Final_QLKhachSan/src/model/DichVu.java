package model;

public class DichVu {
	private String iDDichVu;
	private long giaDichVu;
	private String tenDichVu;
	private int soLuong;

	public DichVu() {
		super();
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

	/**
	 * @return the giaDichVu
	 */
	public long getGiaDichVu() {
		return giaDichVu;
	}

	/**
	 * @param giaDichVu the giaDichVu to set
	 */
	public void setGiaDichVu(long giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	/**
	 * @return the tenDichVu
	 */
	public String getTenDichVu() {
		return tenDichVu;
	}

	/**
	 * @param tenDichVu the tenDichVu to set
	 */
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
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

}
