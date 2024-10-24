package days13.Otp1;

//Tính tổng n số sử dụng đệ quy
public class Ass4 {

	public static void main(String[] args) {
		int n = 9;
		
		System.out.println(sumN(n));
	}

	public static int sumN(int n) {
		if (n == 1) {
			return 1;
		}
		return n+sumN(n-1);
	}
}
