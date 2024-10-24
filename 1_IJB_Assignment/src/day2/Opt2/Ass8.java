package day2.Opt2;

public class Ass8 {
//		Tính giá trị của a:
//		int i = 1;
//		a = i++ + ++i – i-- - --i;

	public static void main(String[] args) {
		int a;
		int i=1, j=1;
		a = i++ + ++i - i-- - --i;
		System.out.println("a = i++ + ++i – i-- - --i = 1+3-3-1 = "+a);

	}

}
