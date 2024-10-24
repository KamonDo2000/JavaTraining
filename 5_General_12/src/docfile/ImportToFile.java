package docfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import object_class.DanhSachSV;
import object_class.SinhVien;

public class ImportToFile {

	public static void input(String fileName) {
		DanhSachSV dssv = new DanhSachSV();
		List<String> listErr = new ArrayList<>();

		try {

			FileReader fr = new FileReader(fileName + ".csv");
			BufferedReader br = new BufferedReader(fr);

			// line value in file
			String line = "";
			// index of row value
			int linessn = 0;

			while (true) {
				line = br.readLine();
				StringBuilder popErr = new StringBuilder();

				if (line == null) {
					break;
				} else {
					linessn++;
				}

				String[] txt = line.split(",");
				SinhVien sv = new SinhVien();

				popErr.append("Line " + linessn + ":  Co loi sai dinh dang ");
				int length = popErr.length();

				try {
					sv.setStdNo(CheckInput.checkStdNo(txt[0]));
				} catch (CheckStdNoException e) {
					popErr.append(e.getMessage());
					sv.setStdNo("Null");
				}

				try {
					sv.setStdName(CheckInput.checkStdName(txt[1]));
				} catch (CheckStdNameException e) {
					if (popErr.length() > length) {
						popErr.append(",  " + e.getMessage());
					} else {
						popErr.append(e.getMessage());
					}
					sv.setStdName("__");
				}

				try {
					sv.setStdPhone(CheckInput.checkStdPhone(txt[2]));
				} catch (CheckStdPhoneException e) {
					if (popErr.length() > length) {
						popErr.append(",  " + e.getMessage());
					} else {
						popErr.append(e.getMessage());
					}
					sv.setStdPhone("0");
				}

				try {
					sv.setStdEmail(CheckInput.checkStdEmail(txt[3]));
				} catch (CheckStdEmailException e) {
					if (popErr.length() > length) {
						popErr.append(",  " + e.getMessage());
					} else {
						popErr.append(e.getMessage());
					}
					sv.setStdEmail("err");
				}

				try {
					sv.setGradePoint(Float.parseFloat((txt[4])));
				} catch (Exception e) {
					if (popErr.length() > length) {
						popErr.append(",  GradePoint");
					} else {
						popErr.append("GradePoint");
					}
					sv.setGradePoint(0);
				}

				if (popErr.length() > length) {
					listErr.add(popErr.toString());
				}

				dssv.addSV(sv);
			}
			br.close();
			fr.close();
			System.out.println("suscess!");

			ExportToFile.exportFileErr(listErr);

		} catch (Exception e) {
			e.getStackTrace();
		}

		for (SinhVien sv : dssv.getListSV()) {
			System.out.print(sv.getStdNo() + " \t");
			System.out.print(sv.getStdName() + " \t");
			System.out.print(sv.getStdPhone() + " \t");
			System.out.print(sv.getStdEmail() + " \t");
			System.out.println(sv.getGradePoint());
		}

	}
}
