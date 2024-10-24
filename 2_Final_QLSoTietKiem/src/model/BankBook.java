package model;

import java.time.LocalDate;

public class BankBook {

	private String maSoTK;
	private String hoTen;
	private String cmnd;
	private String diaChi;
	private String soDienThoai;
	private LocalDate ngayGuiTK;
	private float soTien;
	private String kyHan;
	private int ptTaiTuc;

	public BankBook() {
		super();
	}

	public String getMaSoTK() {
		return maSoTK;
	}

	public void setMaSoTK(String maSoTK) {
		this.maSoTK = maSoTK;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public LocalDate getNgayGuiTK() {
		return ngayGuiTK;
	}

	public void setNgayGuiTK(LocalDate ngayGuiTK) {
		this.ngayGuiTK = ngayGuiTK;
	}

	public float getSoTien() {
		return soTien;
	}

	public void setSoTien(float soTien) {
		this.soTien = soTien;
	}

	public String getKyHan() {
		return kyHan;
	}

	public void setKyHan(String kyHan) {
		this.kyHan = kyHan;
	}

	public int getPTTaiTuc() {
		return ptTaiTuc;
	}

	public void setPTTaiTuc(int pTTaiTuc) {
		ptTaiTuc = pTTaiTuc;
	}

}
