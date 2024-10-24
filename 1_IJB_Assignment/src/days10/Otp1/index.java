package days10.Otp1;

import java.util.Scanner;

public class index {

	public static void main(String[] args) {
		int[] arr;
		arr = Ass1.inputArr();

		do {
			int pick = menu();
			switch (pick) {
			case 0:
				return;
			case 1:
				Ass1.showFindX(arr);
				continue;
			case 2:
				Ass2.findCountX(arr);
				continue;
			case 3:
				Ass3.findArrIndexX(arr);
				continue;
			case 4:
				Ass4.checkScope(arr);
				continue;
			case 5:
				days10.Otp3.Ass1.findDuplicate(arr);
				continue;
			}
		} while (true);

	}

	private static int menu() {
		Scanner sc = new Scanner(System.in);

		do {
			try {
				System.out.println("\n\n===========Menu==========");
				System.out.println("0. Để thoát.");
				System.out.println("1. Tìm giá trị X trong mảng số nguyên A.");
				System.out.println("2. Giá trị X xuất hiện mấy lần trong mảng số nguyên A.");
				System.out.println("3. Hiển thị các vị trí chứa giá trị số nguyên X trong mảng số nguyên A.");
				System.out.println("4. Hiển thị xem có bao nhiêu phần tử có giá trị nằm trong khoảng [X,Y].");
				System.out.println("5. Hiển thị các giá trị trùng nhau trong mảng.");

				System.out.print("Nhập lựa chọn: ");
				int pick = Integer.parseInt(sc.nextLine());

				if (pick == 0 || pick == 1 || pick == 2 || pick == 3 || pick == 4|| pick == 5) {
					return pick;
				}
				System.out.println("chỉ có các lựa chọn 0, 1, 2, 3, 4, 5!!!");
			} catch (Exception e) {
				System.out.println("chỉ có các lựa chọn 0, 1, 2, 3, 4, 5!!!");
			}
		} while (true);
	}

}
