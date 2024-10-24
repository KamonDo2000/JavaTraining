package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputToFile {
	public static DanhSachSV inputToFile(String fileName) {
		DanhSachSV dssv = new DanhSachSV();
		try {

			FileReader fr = new FileReader(fileName+".csv");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String[] txt = line.split(",");
				SinhVien sv = new SinhVien();
				sv.setMaSinhVien(txt[0]);
				sv.setHoTen(txt[1]);
				sv.setNamSinh(Integer.parseInt(txt[2]));
				sv.setDiemTrungBinh(Float.parseFloat(txt[3]));

				dssv.themDanhSachSV(sv);
			}

			br.close();
			fr.close();
			System.out.println("suscess!");
		} catch (Exception e) {
			e.getStackTrace();
		}
		return dssv;
	}
}
