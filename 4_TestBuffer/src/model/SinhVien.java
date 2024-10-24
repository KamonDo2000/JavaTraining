package model;


public class SinhVien {

	private String maSinhVien;
	private String hoTen;
	private int namSinh;
	private float diemTrungBinh;

	public SinhVien() {
	}

	public SinhVien(String maSinhVien, String hoTen, int namSinh, float diemTrungBinh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diemTrungBinh = diemTrungBinh;
	}

	/**
	 * @return the maSinhVien
	 */
	public String getMaSinhVien() {
		return maSinhVien;
	}

	/**
	 * @param maSinhVien the maSinhVien to set
	 */
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return the namSinh
	 */
	public int getNamSinh() {
		return namSinh;
	}

	/**
	 * @param namSinh the namSinh to set
	 */
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	/**
	 * @return the diemTrungBinh
	 */
	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}

	/**
	 * @param diemTrungBinh the diemTrungBinh to set
	 */
	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	@Override
	public String toString() {
		return maSinhVien + "," + hoTen + "," + namSinh + "," + diemTrungBinh;
	}

}
