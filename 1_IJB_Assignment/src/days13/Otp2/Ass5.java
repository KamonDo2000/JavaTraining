package days13.Otp2;

public class Ass5 {
//	Tính S(n) = 1+3+5+..+(2.n+1) với n > 0
	public static void main(String[] args) {

		int n = 3;
		int result = finS(2 * n + 1);
		System.out.println(result);

	}

	public static int finS(int num) {
		if (num == 1) {
			return 1;
		}
		return num + finS(num - 2);
	}

}
