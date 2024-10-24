package day2.Opt1;

public class Asss13 {
	
//	Phân biệt ép kiểu tường minh và ép kiểu ngầm định
	public static void main(String[] args) {
		//Ép kiểu tường minh:
		long a = 999999999L;
		short b = (short)a;
//		từ kiểu dữ liệu nhỏ sang kiểu dữ liệu lớn thì ok
//		từ kiểu dữ liệu lớn về kiểu dữ liệu nhỏ, mất mát dữ liệu
//		nó sẽ từ phải qua trái đủ số bit rồi thì cắt bớt phần còn lại,
//		nếu thằng bit đầu tiên là 0 thì nó quy định dấu + dương
//		nếu thằng bit đầu tiên là 1 thì nó quy định dấu - âm
		
		System.out.println("ép từ long a sang short b "+b);
		//Ép kiểu ngầm định:
		long c = 99L;
		int d = 0;
		c=d;
//		chỉ ép kiểu được những thằng nhỏ lên thằng lớn hơn
	}
}
