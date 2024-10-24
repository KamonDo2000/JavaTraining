package day3;

import java.util.Scanner;

public class Ass4 {

//	Viết chương trình Java để tính toán doanh thu từ việc bán hàng dựa trên đơn giá và số lượng sản phẩm mà người dùng nhập vào.
//	Tỷ lệ chiết khấu là 10% cho số lượng mua từ 100 đến 120 chiếc và 15% cho số lượng mua lớn hơn 120 chiếc. Nếu số lượng mua dưới 100 chiếc, mức chiết khấu là 0%
//	Xem  ví dụ như hình dưới đây:
//	Nhập đơn giá: 25
//	Nhập số lượng: 110
//	Doanh thu từ việc bán hàng: 2475,0 $
//	Sau khi chiết khấu: 275.0 $ (10.0%)

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float cast, result;
		float items;
		float prime;
		float stage;
		System.out.print("Nhap don gia: ");
		prime = input.nextFloat();

		System.out.print("Nhap so luong items: ");
		items = input.nextFloat();

		cast = prime * items;

		if (items > 120) {
			stage = cast * 0.15f; // nếu không có f sẽ hiểu 0.15 là double và
//			ép ngầm định từ double về float sẽ sai
		} else if (items >= 100) {
			stage = cast * 0.1f;
		} else {
			stage = 0;
		}
		result = cast - stage;

		System.out.println("\nDoanh thu tu viec ban hang: " + cast);
		System.out.println("Doanh thu sau chiec khau la: " + result);
	}

}
