package days12.Otp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

//Viết chương trình mô phỏng quy trình xếp hàng đặt vé xem phim như sau:
//Danh sách liên kết A chứa số ghế của các ghế trống trong rạp (ban dầu khởi tạo các số ghế từ 1 đến n).
//Danh sách hàng đợi B chứa số thự tự xếp hàng của khách.
//Danh sách liên kết C chứa thông tin khách đã mua vé (số ghế, tên).
//Chức năng lấy số xếp hàng: Thêm nút vào B, nếu B rỗng thì nút thêm sẽ có số thứ tự xếp hàng là 1, ngược lại thì số thứ tự xếp hàng là k+1 với k là số thứ tự của nút cuối của B.
//Chức năng mua vé: Nếu còn ghế trống và có khách đang chờ mua vé thì xóa nút khỏi B, lấy tên khách và số ghế khách chọn để thêm nút vào C đồng thời loại số ghế đó khỏi A.
//Chức năng hủy vé: Xóa nút khỏi C đồng thời thêm số ghế mới hủy vào A.

//Chức năng hiển thị: Hiển thị thông tin những vé đã bán (DSLK C).

public class Ass1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList<Integer> A = new LinkedList<>(); // số ghế
		ArrayDeque<Integer> B = new ArrayDeque<>(); // thứ tự xếp hàng

		ArrayList<Custommer> C = new ArrayList<>(); // Thông tin khách đã mua
		System.out.print("Nhap so ghe trong rap (n): ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			A.add(i);
		}

		do {
			int pick = menu();
			switch (pick) {
			case 0:
				return;
			case 1:
				addQueueNumber(B);
				continue;
			case 2:
				buyTiket(A, B, C);
				;
				continue;
			case 3:
				cancelTiket(C, A);
				continue;
			case 4:
				show(C);
				continue;
			}
		} while (true);

	}

	public static void show(ArrayList<Custommer> C) {
		for (Custommer custommer : C) {
			System.out.print(custommer.seatNumber);
			System.out.print("\t---\t");
			System.out.print(custommer.customerName);
			System.out.println("\n======================================");
		}
	}

	public static void cancelTiket(ArrayList<Custommer> C, LinkedList<Integer> A) {
		System.out.print("Nhap so ghe muon cancel: ");
		int seat = Integer.parseInt(sc.nextLine());
		for (Custommer c : C) {
			if (c.seatNumber == seat) {
				C.remove(c);
				System.out.println("huy ve thanh cong");
				A.add(c.seatNumber);
				return;
			}
		}
		System.out.println("Khong co nguoi dat ghe nay");
	}

	public static void buyTiket(LinkedList<Integer> A, ArrayDeque<Integer> B, ArrayList<Custommer> C) {
		if (!A.isEmpty() && !B.isEmpty()) {
			B.poll();

			int seat = A.poll();
			System.out.print("Nhap Ten khach hang: ");
			String name = sc.nextLine();

			Custommer custommer = new Custommer(seat, name);
			C.add(custommer);
		} else {
			System.out.println("Het ghe trong roi!!!");
		}
	}

	public static void addQueueNumber(ArrayDeque<Integer> B) {
		if (B.isEmpty()) {
			B.add(1);
		} else {
			B.add(B.peekLast() + 1);
		}
	}

	private static int menu() {

		do {
			try {
				System.out.println("\n===========Menu==========");
				System.out.println("0. Để thoát.");
				System.out.println("1. lấy số xếp hàng.");
				System.out.println("2. mua vé.");
				System.out.println("3. hủy vé.");
				System.out.println("4. Hiển thị.");

				System.out.print("Nhập lựa chọn: ");
				int pick = Integer.parseInt(sc.nextLine());

				if (pick == 0 || pick == 1 || pick == 2 || pick == 3 || pick == 4) {
					return pick;
				}
				System.out.println("chỉ có các lựa chọn 0, 1, 2, 3, 4!!!");
			} catch (Exception e) {
				System.out.println("chỉ có các lựa chọn 0, 1, 2, 3, 4!!!");
			}
		} while (true);
	}

}

class Custommer {
	int seatNumber;
	String customerName;

	public Custommer(int seatNumber, String customerName) {
		this.seatNumber = seatNumber;
		this.customerName = customerName;
	}
}
