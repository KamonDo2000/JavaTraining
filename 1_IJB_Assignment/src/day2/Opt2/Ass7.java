package day2.Opt2;

public class Ass7 {
//	Tính giá trị của a:
//		int i = 1; j = 1;
//		a =++i + ++j + i++ + j++;

	public static void main(String[] args) {
		int a;
		int i=1, j=1;
		a = ++i + ++j + i++ + j++;
		System.out.println("a = ++i + ++j + i++ + j++ = 2+2+2+2 = "+a);

	}

}
