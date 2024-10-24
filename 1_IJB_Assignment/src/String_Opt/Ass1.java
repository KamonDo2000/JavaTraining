package String_Opt;

public class Ass1 {
//	Cho chuỗi “Hello World” và Lấy ra chữ World
	public static void main(String[] args) {
		String str = "Hello World";
		
		if (str.indexOf("World")==-1) {
			System.out.println("Khong co world trong String");
		}else {
			System.out.println(str.substring(str.indexOf("World")));
		}
		
	}

}
