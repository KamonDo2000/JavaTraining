package day2.Opt1;

public class Ass4 {
//	Tính giá trị của biến:
//        boolean a = true&&false;
//        boolean b = (3 > 100) || (25%5 == 0)
//        boolean c = a && b;
//        boolean d = !a || b;	

	public static void main(String[] args) {
		boolean a = true && false;
		boolean b = (3>100) || (25%5==0);
		boolean c = a && b;
		boolean d = !a || b;
		
		System.out.println("a: "+ a);
		System.out.println("b: "+ b);
		System.out.println("c: "+ c);
		System.out.print("d: "+ d);

	}

}
