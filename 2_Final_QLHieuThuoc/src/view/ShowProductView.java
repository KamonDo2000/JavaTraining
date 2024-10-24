package view;

import java.util.List;

import model.SanPham;

public class ShowProductView {

	public static void show(List<SanPham> listSanPham) {
		for (SanPham sanPham : listSanPham) {
			System.out
					.println(sanPham.getId() + " || Name: " + sanPham.getName() + " || HSD: " + sanPham.getHanSuDung());
			System.out.println("\n=============================");
		}
	}

	public static void showAll(List<SanPham> listSanPham) {
		for (SanPham sanPham : listSanPham) {
			System.out.println(sanPham.getId() + " || Name: " + sanPham.getName() + " || HSD: " + sanPham.getHanSuDung()
					+ " || So Luong: " + sanPham.getSoLuongNhapVao() + " || So Luong Ban Ra: "
					+ sanPham.getSoLuongDaBan());
			System.out.println("\n=============================");
		}
	}

}
