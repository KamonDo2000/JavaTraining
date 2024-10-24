package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class OutputFile {
	public static void outputToFile(String fileName, DanhSachSV dssv) {
		String url = "C:\\Users\\huygi\\eclipse-workspace\\4_TestIOStream\\" + fileName + ".csv";
		try {
			File file = new File(url);
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);

			for (SinhVien sv : dssv.getDanhSachSV()) {
				oos.writeObject(sv);
			}
			oos.flush();
			System.out.println("Ghi file thanh cong!!");

			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
