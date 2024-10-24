package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class InputFile {
	public static void inputToFile(String fileName, DanhSachSV dssv) {
		String url = "C:\\Users\\huygi\\eclipse-workspace\\4_TestIOStream\\" + fileName + ".csv";
		try {
			File file = new File(url);
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);

			SinhVien sv = null;

			while (is.available() > 0) {
				sv = (SinhVien) ois.readObject();
				if (sv != null) {
					dssv.themDanhSachSV(sv);
				} else {
					break;
				}
			}
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
