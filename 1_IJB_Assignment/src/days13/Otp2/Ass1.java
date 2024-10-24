package days13.Otp2;

//Tìm chữ số có giá trị lớn nhất của số nguyên dương n
public class Ass1 {
	public static void main(String[] args) {
		int num = 132283623;
		System.out.println(findMax(num));
	}

	public static int findMax(int num) {
		if (num < 10) {
			return num;
		}
		int max = num % 10;
		num = num / 10;
		if (num % 10 > max) {
			max = num % 10;
		}

		return findMax((num / 10) * 10 + max);
	}
}
