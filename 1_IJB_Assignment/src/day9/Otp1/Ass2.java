package day9.Otp1;

public class Ass2 {

	public static void main(String[] args) {
//		Đoạn code sau có throw NullPointerException hay không? Giải thích vì sao?
		try {
			String a = null;
			a = a.substring(0, 5);
		} catch (NullPointerException e) {
			System.out.println(e);
		}		
	}
}


//Đoạn code sẽ bị lỗi NullPoint Exception. vì String a là một object String null, 
//và ta đang cố truy cập phương thức của một object null
