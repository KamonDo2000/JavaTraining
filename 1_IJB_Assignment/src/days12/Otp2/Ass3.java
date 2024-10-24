package days12.Otp2;

public class Ass3 {
//	Xây dựng một cấu trúc Stack để quản lý các phần tử
//	struct Stack{
//	int *arr;
//	int top; // lưu lại vị trí của phần tử đưa vào cuối cùng. Khởi tạo là -1
//	int size; // kich thước tối đa của Stack
//	}

	public static void main(String[] args) {
		int capacity = 4;
		int[] stack = new int[capacity];

		for (int i = 0; i < stack.length; i++) {
			stack[i] = i;

		}

		System.err.println(top(stack));
		System.err.println(size(stack));

	}

	static int top(int[] stack) {
		if (stack[stack.length - 1] == 0) {
			return -1;
		}
		return stack[stack.length - 1];
	}

	static int size(int[] stack) {
		return stack.length;
	}

}
