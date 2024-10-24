package day2.Opt2;

public class Asss13 {

	// Phân biệt ép kiểu tường minh và ép ngầm đinh
	public static void main(String[] args) {
		long a = 9999L;
		short b = (short)a; //ép tường minh: Buộc phải theo kiểu dữ liệu, ép nhỏ lên lớn không sao nhưng lớn xuống nhỏ dễ mất data
		long c = 99L; //ép ngầm định chỉ cho phép ép từ nhỏ lên lớn
		int d = 0;
		c=d;
	}

}
