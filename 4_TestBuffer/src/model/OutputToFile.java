package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class OutputToFile {
	public static void outputToFile(String fileName, DanhSachSV dssv) {

		try {
			File file = new File("fileName.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (SinhVien sv : dssv.getDanhSachSV()) {
				bw.write(sv.toString());
				bw.newLine();
			}

			bw.close();
			fw.close();

			System.out.println("Success!");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
