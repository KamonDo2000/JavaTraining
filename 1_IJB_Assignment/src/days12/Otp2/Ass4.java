package days12.Otp2;

import java.util.Scanner;


public class Ass4 {
//	Viết các hàm sau:
//		- Khởi tạo stack với số phần tử n
//		- Kiểm tra Stack có rỗng hay không
//		- Kiểm tra Stack có đầy hay không
//		- Lấy một phần tử ra khỏi Stack
//		- Đưa một phần tử vào Stack
//		- Lấy giá trị của phần tử đầu tiên trong Stack
//		- Hàm main. Nhập 10 phần tử ngẩu nhiên vào Stack và xuất ra màn hình.

	public static void main(String[] args) {
		int[] stack;
		stack = create();

		addNum(stack, 3);
		addNum(stack, 7);
		addNum(stack, 3);
		addNum(stack, 4);
		addNum(stack, 5);
		addNum(stack, 6);
		addNum(stack, 8);
		addNum(stack, 9);
		addNum(stack, 2);
		addNum(stack, 5);
		addNum(stack, 4);
		

		for (int i : stack) {
			System.out.print(i);
		}

	}

	static int[] create() {
		Scanner sc = new Scanner(System.in);
		int capacity;
		do {
			System.out.print("Nhap do lon stack: ");
			capacity = Integer.parseInt(sc.nextLine());
			if (capacity <= 0) {
				System.out.println("Do lon > 0");
			}
		} while (capacity <= 0);

		int[] stack = new int[capacity];
		return stack;
	}

	static boolean checkNull(int[] stack) {
		boolean c = true;

		for (int i : stack) {
			if (i != 0) {
				c = false;
			}
		}
		if (!c) {
			System.out.println("is not null");
		}

		return c;
	}

	static boolean checkFull(int[] stack) {
		boolean c = false;
		if (stack[stack.length - 1] != 0) {
			c = true;
			System.out.println("is full");
		}
		return c;
	}

	static int getNum(int[] stack) {
		for (int i = stack.length - 1; i >= 0; --i) {
			if (stack[i] != 0) {
				return stack[i];
			}
		}
		return -1;
	}

	static void addNum(int[] stack, int num) {
		if (num == 0) {
			System.err.println("num is not zero!!");
			return;
		}
		if (stack[stack.length - 1] != 0) {
			System.err.println("is full");
			return;
		}
		for (int i = stack.length - 1; i >= 0; --i) {
			if (stack[i] != 0) {
				stack[i + 1] = num;
				return;
			}
			if (i == 0) {
				stack[0] = num;
				return;
			}
		}
	}

	static int getFirtNum(int[] stack) {
		if (stack[0] != 0) {
			return stack[0];
		}
		return -1;
	}

}
