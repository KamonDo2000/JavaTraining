package day9.Otp1;

import java.util.ArrayList;

public class Ass1 {
//	Trả lời câu hỏi: “Khi nào thì xảy ra NullPointerException?”
	public static void main(String[] args) {
//		Tạo một instance mothod của một null object.
		try {
			VD vd = null;
			vd.hashCode();
		} catch (Exception e) {
			System.out.println(e + "\t Exception 1");
		}
		// tất cả các Object được khởi tạo ra đều là con của thằng Object Class
		// vd được khởi tạo ra là obj rỗng không chứa attribute hay method nào
		// Nhưng nó kế thừa từ Object Class nên có tất cả các phương thức trong Obj
		Object obj = null;
		obj.getClass();
//------------------------------------------------------------------------------------------		
//		Truy cập hoặc chỉnh sửa một trường giá trị của một Null object.

		try {
			VD vd2 = null;
			vd2.seta(3);
		} catch (Exception e) {
			System.out.println(e + "\t Exception 2");
		}
//------------------------------------------------------------------------------------------		
//		lấy length của một mảng có giá trị là Null.
		try {
			int[] arr = null;
			System.out.println(arr.length);
		} catch (Exception e) {
			System.out.println(e + "\t Exception 3");
		}
//------------------------------------------------------------------------------------------		
//		Truy cập hoặc chỉnh sửa giá trị Null như kiểu một mảng.
		try {
			int[] arr = null;
			arr[1] = 8;
			System.out.println(arr[1]);
		} catch (Exception e) {
			System.out.println(e + "\t Exception 4");
		}
//------------------------------------------------------------------------------------------		
//		Cố truy cập vào một object null
		try {
			ArrayList<Integer> arr = null;
			
			System.out.println(arr.get(0));
		} catch (Exception e) {
			System.out.println(e + "\t Exception 5");
		}
	}
}

class VD {
	public int a;

	public void seta(int A) {
		this.a = A;
	}
}