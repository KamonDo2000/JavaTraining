package String_Opt;

public class Ass4 {
//	Cho chuỗi “Hello World” và Cho biết vị trí xuất hiện đầu tiên và cuối cùng của chữ l
	public static void main(String[] args) {
		String str = "Hello World";
		System.out.println("firt index of \'l\' is "+(str.indexOf('l')+1));
		System.out.println("last index of \'l\' is "+(str.lastIndexOf('l')+1));
	}

}
