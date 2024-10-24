package day9.Otp1;

public class Ass6 {

	public static void main(String[] args) {
//		Để đoạn code sau không throw NullPointerException 
//		thì phải sửa lại code như thế nào để không bị ảnh hưởng đến dữ liệu?
				String a = "";
				int x = a.indexOf("H");
				System.out.print(x);
	}
}

// indexOf để trả về vị trí đầu tiên xuất hiện của ký tự nếu không có sẽ trả về -1.
// ta đang truy cập vào method indexOf của obj null 
// để chỉnh sửa thì String a phải là rỗng(Blank) chứ không thể là Null
