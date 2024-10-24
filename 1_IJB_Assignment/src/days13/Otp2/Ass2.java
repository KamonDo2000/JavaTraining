package days13.Otp2;

public class Ass2 {
//	Tìm giá trị nguyên logarit cơ số 2 của n

//	x = log2N <=> 2^x = N => N/2 x lần
	public static void main(String[] args) {
		int n = 86;
		System.out.println(log2(n));
	}

	public static int log2(int num) {

		if (num == 1) {
			return 0;
		}

		return 1 + log2(num / 2);
	}

}
