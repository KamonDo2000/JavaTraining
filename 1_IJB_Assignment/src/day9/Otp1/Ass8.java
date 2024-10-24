package day9.Otp1;

public class Ass8 {

	public static void main(String[] args) {
//		Để đoạn code sau không throw NullPointerException 
//		thì phải sửa lại code như thế nào để không bị ảnh hưởng đến dữ liệu?
		String a = "";
		if (a.equals("Hello")) {
			System.out.println("a bang Hello");
		}
	}
}

// Nó Throw null point exception laf do obj a Null nên không truy cập method equals được
// để chỉnh lại thì gán a là rỗng(blank) chứ không thể null.
