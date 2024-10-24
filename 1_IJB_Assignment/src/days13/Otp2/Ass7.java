package days13.Otp2;

public class Ass7 {
//		Tính S(n)=1^2+2^2+3^2+....+n^2 với n>0	

	public static void main(String[] args) {
		int n = 4;

		System.out.println(findS(n));
	}

	public static int findS(int num) {
		if (num == 1) {
			return 1;
		}

		return num * num + findS(num - 1);
	}
}
