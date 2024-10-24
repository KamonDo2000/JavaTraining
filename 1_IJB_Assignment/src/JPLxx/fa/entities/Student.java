package JPLxx.fa.entities;

import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	private String maSinhVien;
	private float diemTB;
	private int tuoi;
	private String lop;

	public Student() {
	}

	public Student(String maSinhVien, float diemTB, int tuoi, String lop) {
		super();
		this.maSinhVien = maSinhVien;
		this.diemTB = diemTB;
		this.tuoi = tuoi;
		this.lop = lop;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public void inputInfo() {
		do {
			System.out.print(" Nhập mã sinh viên:  ");
			this.maSinhVien = sc.nextLine();
			if (this.maSinhVien.length() != 8) {
				System.out.println("\nMã SV chứa 8 ký tự");
			}
		} while (this.maSinhVien.length() != 8);

		do {
			System.out.print(" Nhập điểm trung bình: ");
			this.diemTB = Float.parseFloat(sc.nextLine());
			if (this.diemTB > 10 || diemTB < 0) {
				System.out.println("\nĐiểm trung bình phải 0 < TB < 10");
			}
		} while (this.diemTB > 10 || diemTB < 0);

		do {
			System.out.print(" Nhập tuổi sinh viên: ");
			this.tuoi = Integer.parseInt(sc.nextLine());
			if (this.tuoi < 18) {
				System.out.println("\nPhải lớn hơn hoặc bằng 18");
			}
		} while (this.tuoi < 18);

		do {
			System.out.print(" Nhập lớp sinh viên: ");
			this.lop = sc.nextLine();
			String c = (this.lop.substring(0, 1));
			if (!c.equals("C") && !c.equals("A")) {
				System.out.println("\nPhải bắt đầu bởi kí tự ‘A’ hoặc kí tự ‘C’ ");
			}
		} while (!this.lop.substring(0, 1).equals("C") && !this.lop.substring(0, 1).equals("A"));
		System.out.println("================================================================");

	}

	public void showInfo() {
		System.out.printf("Mã sinh viên: %s || Điểm TB: %4.2f || Tuổi: %d || Lớp: %s ", this.maSinhVien, this.diemTB,
				this.tuoi, this.lop);
	}

	public boolean checkHocBong(float diemTB) {
		boolean c = false;
		if (diemTB > 8) {
			 c = true;
		}
		return c;
	}
}
