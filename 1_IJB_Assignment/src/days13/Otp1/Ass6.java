package days13.Otp1;

public class Ass6 {
//	Đếm số lượng chữ số nguyên dương
	public static void main(String[] args) {
		String num = "10000";
		
		try {
			Integer n = Integer.parseInt(String.valueOf(num));
			System.out.println(countNum(n));
		} catch (Exception e) {
			System.out.println("Khong phai chu so");
		}
		
	}

	public static int countNum(int num) {
		if (num == 0) {
			return 0;
		}

		return 1 + countNum(num / 10);
	}
}
