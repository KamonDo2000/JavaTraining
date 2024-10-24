package day9.Otp2;

public class Ass6 {

	public static void main(String[] args) {
//		Chỉ ra các dòng nào bên dưới sinh ra Exception và vì sao
		Integer.parseInt("1");
		Integer.parseInt("-1");
		Integer.parseInt("+1");
		Integer.parseInt(" 1"); // Không thể parse một khoảng trắng sang kiểu int
		Integer.parseInt("2147483648"); // không thể parse giá trị vượt quá độ lớn kiểu int sang int
		Integer.parseInt("1.1"); // Không thể parse số có chấm động sang kiểu int
		Integer.parseInt(""); // Không thể parse một khoảng trắng sang kiểu int
	}
}
