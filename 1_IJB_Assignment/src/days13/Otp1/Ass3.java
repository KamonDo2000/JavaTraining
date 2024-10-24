package days13.Otp1;

public class Ass3 {
//	Tìm USCLN và BSCNN của 2 số a và b sử dụng đệ quy
	public static void main(String[] args) {
		int a = 20;
		int b = 15;

		System.out.println(UCLN(a, b));
		int BCNN = (a + b) / UCLN(a, b);
		System.out.println(BCNN);
	}

	public static int UCLN(int Bnum, int Snum) {
//		giải thuật Euclid tìm UCLN dư khác 0 thì lấy số chia chia lại cho dư|| 81 / 57 dư 24 thì lấy 57 /24
		if (Snum > Bnum) {
			Bnum = Bnum + Snum;
			Snum = Bnum - Snum;
			Bnum = Bnum - Snum;
		}

		int modNum = Bnum % Snum;
		if (modNum == 0) {
			return Snum;
		}
		return UCLN(Snum, modNum);
	}

}
