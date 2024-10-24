package view;

import java.util.Scanner;

import controler.InputSVControl;
import model.DanhSachSV;
import model.InputFile;
import model.OutputFile;
import model.SinhVien;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DanhSachSV dssv = new DanhSachSV();
		while (true) {
			System.out.println("Menu:");
			System.out.println("=====Chuong trinh QL sinh vien=====");
			System.out.println("1.Them 1 sinh vien.");
			System.out.println("2.Hien Thi Danh Sach SV da them.");
			System.out.println("3.Xoa het Danh Sach");
			System.out.println("4.Ghi Danh sach xuong file");
			System.out.println("5.Doc Danh sach tu file");
			System.out.println("0.Ket thuc chuong trinh.");

			System.out.print("nhap lua chon cua ban: ");
			int pick;
			try {
				pick = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("khong co lua chon");
				continue;
			}

			switch (pick) {
			case 0:
				System.out.println("Ket thuc chuong trinh!!!");
				return;
			case 1:
				dssv.themDanhSachSV(InputSVControl.inputSV());
				break;
			case 2:
				for (SinhVien sv : dssv.getDanhSachSV()) {
					System.out.print(sv.getMaSinhVien() + " || ");
					System.out.print(sv.getHoTen() + " || ");
					System.out.print(sv.getNamSinh() + " || ");
					System.out.println(sv.getDiemTrungBinh() + "\n");
				}
				break;
			case 3:
				dssv.xoaDanhSachSV();
				break;
			case 4:
				System.out.print("Nhap Ten file: ");
				String fileName = sc.nextLine();
				OutputFile.outputToFile(fileName, dssv);
				break;
			case 5:
				System.out.print("Nhap Ten file: ");
				fileName = sc.nextLine();
				InputFile.inputToFile(fileName, dssv);
				break;
			default:
				System.err.println("khong co lua chon");
				break;
			}

		}
	}

}
