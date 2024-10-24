package control;

import model.SinhVien;
import view.InputSV;

public class InputSVControl {
	public static SinhVien inputSV() {
		SinhVien sv = new SinhVien();

		sv.setMaSinhVien(InputSV.mssv());
		sv.setHoTen(InputSV.hoVaTen());
		sv.setNamSinh(InputSV.namSinh());
		sv.setDiemTrungBinh(InputSV.diemSo());

		return sv;
	}
}
