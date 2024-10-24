package String_Opt;
//Cho chuỗi “ Hello World ” và Xóa hết space đầu tiên và cuối cùng (không được xóa space giữa chừng)
public class Ass6 {
	public static void main(String[] args) {
		String str = " Hello World ";
		str= str.trim();
		System.out.println(str);
		
//   (?i) không phân biệt hoa thường
		String original = "apple apple apple";
		String modified = original.replace("(?i)apple", "orange");
		System.out.println(modified);  // Output: orange orange orange

	}
}
