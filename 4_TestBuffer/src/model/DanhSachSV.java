package model;

import java.util.ArrayList;

public class DanhSachSV {
	private ArrayList<SinhVien> arrSV;

	public DanhSachSV() {
		this.arrSV = new ArrayList<>();
	}

	public DanhSachSV(ArrayList<SinhVien> sv) {
		this.arrSV = sv;
	}

	public void themDanhSachSV(SinhVien sv) {
		this.arrSV.add(sv);
	}

	public ArrayList<SinhVien> getDanhSachSV() {
		return this.arrSV;
	}

	public void xoaDanhSachSV() {
		this.arrSV.clear();
	}
}
