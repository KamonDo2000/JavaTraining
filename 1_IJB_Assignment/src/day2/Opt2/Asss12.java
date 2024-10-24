package day2.Opt2;

public class Asss12 {

//	Cho các ví dụ về ép kiểu mà độ chính xác  bị thay đổi, như thứ tự bên dưới:
//	double -> float -> long -> int -> short -> byte	
	public static void main(String[] args) {
		double a = 1283217727*2727783*43878327874D;
		float b = (float)a;
		System.out.println("Giá trị biến float sau khi ép từ double: "+b);
		long c = (long)b;
		System.out.println("Giá trị biến long sau khi ép từ float: "+c);
		int d = (int)c;
		System.out.println("Giá trị biến int sau khi ép từ long: "+d);
		short e = (short)d;
		System.out.println("Giá trị biến short sau khi ép từ int: "+e);
		byte f = (byte)e;
		System.out.println("Giá trị biến byte sau khi ép từ short: "+f);
	}

}
