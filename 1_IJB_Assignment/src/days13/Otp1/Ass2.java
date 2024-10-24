package days13.Otp1;

//Tính giai thừa sử dụng đệ quy
public class Ass2 {

	public static void main(String[] args) {
		int gt = 10;
		int result = giaiThua(gt);
		System.out.println(result);
	}

	public static int giaiThua(int gt) {
		if (gt == 1) {
			return 1;
		}
		return gt * giaiThua(gt - 1);
	}

}
