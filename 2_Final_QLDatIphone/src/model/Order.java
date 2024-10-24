package model;

import java.time.LocalDate;

public class Order {

	private String maOder;
	private String tenKhachHang;
	private String soDienThoai;
	private String tenSanPham;
	private int soLuong;
	private int donGia;
	private LocalDate ngayOrder;

	public Order() {
		super();
	}

	public String getMaOder() {
		return maOder;
	}

	public void setMaOder(String maOder) {
		this.maOder = maOder;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public LocalDate getNgayOrder() {
		return ngayOrder;
	}

	public void setNgayOrder(LocalDate ngayOrder) {
		this.ngayOrder = ngayOrder;
	}

}
