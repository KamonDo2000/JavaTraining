package String_Opt;

//Cho chuỗi “ Hello World ” và Xóa hết space giữa chừng, đầu tiên và cuối cùng
public class Ass5 {
	public static void main(String[] args) {
		String str = " Hello World ";

		str = str.replace(" ", "");
		System.out.println(str);
	}
}
