package days13.Otp2;

public class Ass6 {
//	S = 1+1/3!+1/5!+…..+1/(2n-1)!
	public static void main(String[] args) {
		int n = 3;

		System.out.println(findS(2 * n - 1));

	}

	public static int GT(int gt) {
		if (gt == 1) {
			return 1;
		}
		return gt * GT(gt - 1);
	}

	public static int findS(int num) {
		if (num == 0) {
			return 1;
		}
		return 1 / GT(num) + findS(num - 2);
	}

}
