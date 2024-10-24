package days13.Otp1;

//In đảo ngược số nguyên dương
public class Ass5 {

	public static void main(String[] args) {
		int num = 1234500;
		numSwap(num);
	}

	public static int numSwap(int num) {
		if (num != 0) {
			System.out.print(num % 10);
		}else{
			return 0;
		}
		return numSwap(num / 10);
	}

}
