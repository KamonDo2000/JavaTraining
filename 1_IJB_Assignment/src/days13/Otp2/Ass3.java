package days13.Otp2;

import java.util.Iterator;

public class Ass3 {
//	Đổi sang hệ nhị phân của số nguyên dương n
	public static void main(String[] args) {
		int n = 123;
		int result = veerBit(binaryC(n, 0));
		System.out.println(result);
	}

	public static int binaryC(int num, int bits) {
		if (num == 0) {
			return bits;
		}
		int bit = num % 2;
		bits = (bits * 10) + bit;
		return binaryC(num / 2, bits);
	}

	public static int veerBit(int bit) {

		int num = 0;
		while (bit > 0) {
			num = num * 10 + (bit % 10);
			bit /= 10;
		}

		return num;
	}

}
