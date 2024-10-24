package view;

import java.util.Scanner;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * hiển thị menu và cho nhập lựa chọn
	 * 
	 * @return lựa chọn của menu (int)
	 */
	public static int menu() {
		do {
			try {
				System.out.println("\n===========Menu==========");
				System.out.println("0. Để thoát.");
				System.out.println("1. Thêm chi tiết đặt phòng.");
				System.out.println("2. Xóa chi tiết đặt phòng.");
				System.out.println("3. Chỉnh sửa chi tiết đặt phòng.");
				System.out.println("4. Hiển thị thông tin Khách hàng có Tên là X đã từng đặt KS.");
				System.out.println("5. Xếp phòng cho Khách hàng X.");
				System.out.println("6. Chuyển phòng của khách hàng có MaKH là X sang phòng Y.");
				System.out.println("7. Gộp phòng của khách hàng X .");
				System.out.println("8. Tính tổng số tiền mà Khách đặt phòng phải thanh toán.");
				System.out.println(
						"9. Thống kê số ngày lưu trú của phòng và lợi nhuận (theo tháng với cùng kỳ năm trước.)");

				System.out.print("Nhập lựa chọn: ");
				return Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}

}
