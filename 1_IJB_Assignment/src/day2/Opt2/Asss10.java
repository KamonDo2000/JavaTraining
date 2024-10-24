package day2.Opt2;

public class Asss10 {

//	Cho các ví dụ về ép kiểu mà độ chính xác không bị thay đổi, như thứ tự bên dưới:
//		byte->short->int->long->float->double"	
	public static void main(String[] args) {
		byte a = 127; //scope is -128 -> 127
		short b = a;
		System.out.println("Giá trị biến short sau khi ép từ byte: "+b);
		int c = b;
		System.out.println("Giá trị biến int sau khi ép từ short: "+c);
		long d = c;
		System.out.println("Giá trị biến long sau khi ép từ int: "+d);
		float e = d;
		System.out.println("Giá trị biến float sau khi ép từ long: "+e);
		double f = e;
		System.out.println("Giá trị biến double sau khi ép từ float: "+f);

	}

}
