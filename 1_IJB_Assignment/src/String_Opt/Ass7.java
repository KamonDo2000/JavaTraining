package String_Opt;

//Cho chuỗi “Hello World” và Đảo chuỗi thành dlroW olleH
public class Ass7 {
	public static void main(String[] args) {
		String str = "Hello World";
		char[] arr = str.toCharArray();

		for (int i = arr.length - 1; i >= 0; --i) {
			System.out.print(arr[i]);
		}
	}

}
