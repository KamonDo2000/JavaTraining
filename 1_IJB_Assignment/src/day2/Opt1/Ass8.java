package day2.Opt1;

public class Ass8 {
	
//	Tính giá trị của a:
//		int i = 1; j = 1;
//		a = ++i + j++;
	public static void main(String[] args) {
		int i = 1, j = 1;
		int a = ++i + j++;
		System.out.println("gia tri cua a: "+ a);
		System.out.printf("gia tri cua %d + %d = %d", i, j, a);
	}
}
