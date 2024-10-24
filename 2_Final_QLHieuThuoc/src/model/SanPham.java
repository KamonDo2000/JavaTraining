package model;

import java.time.LocalDate;

public class SanPham {

	private String id;
	private String name;
	private LocalDate hanSuDung;
	private int soLuongNhapVao;
	private int soLuongDaBan;

	public SanPham() {
		this.soLuongDaBan = 0;
	}

	public SanPham(String id, String name, LocalDate hanSuDung, int soLuongNhapVao) {
		super();
		this.id = id;
		this.name = name;
		this.hanSuDung = hanSuDung;
		this.soLuongNhapVao = soLuongNhapVao;
		this.soLuongDaBan = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(LocalDate hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public int getSoLuongNhapVao() {
		return soLuongNhapVao;
	}

	public void setSoLuongNhapVao(int soLuongNhapVao) {
		this.soLuongNhapVao = soLuongNhapVao;
	}

	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}

	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}

}
