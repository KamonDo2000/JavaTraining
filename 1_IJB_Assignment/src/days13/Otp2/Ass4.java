package days13.Otp2;

public class Ass4 {
//Tìm chử số đầu tiên của số nguyên duong n
	public static void main(String[] args) {
		int n = 23049;
		System.out.println(findFirt(n));
	}

	public static int findFirt(int n) {
		if (n / 10 == 0) {
			return n;
		}
		return findFirt(n / 10);
	}
}
