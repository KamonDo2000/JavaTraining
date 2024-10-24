package day2.Opt2;

public class Asss14 {
//	Khi nào cần dùng các ký tự L, F, D… sau các số nguyên, số thực trong Java? 
//			Khi nào thì không cần dùng đến các ký tự này mà Java vẫn tự hiểu được các số thuộc kiểu dữ liệu gì?	

	public static void main(String[] args) {
		float a = 12.9F;
		double b = 23.84F;
		long c = 3929333L;
		long d = 392039;
		float s = 293.394F;
//		nếu không có ký tự sau thì đối với số nguyên sẽ không lỗi, 
//		nhưng long a = 1920 sẽ hiểu 1920 là int
//		buộc phải có ký tự f hoặc d sau số thực không sẽ lỗi, vì int không chứa số thực
//		Vậy L sau số nguyên là khi khai báo kiểu Long, F khai báo kiểu float, D khai báo kiểu double
//		khi khai báo từ Int trở xuống thì không cần dùng đến ký tự.
	}

}
