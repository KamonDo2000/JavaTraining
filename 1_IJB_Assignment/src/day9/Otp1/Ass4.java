package day9.Otp1;

import java.util.ArrayList;

public class Ass4 {
	public static void main(String[] args) {
//		Đoạn code sau có throw NullPointerException hay không?
//		Nếu có thì xảy ra tại dòng nào? Vì sao?
		ArrayList<Sinhvien> a = new ArrayList<Sinhvien>();
		Sinhvien sv = null;
		a.add(sv);
		Sinhvien svout = a.get(0);
		System.out.println(svout.getHoTen());
	}
}

// Đầu tiên sv đang là object null sau đó ta thêm đối tượng sv vào ArrayList a
// Lúc này phần tử đầu tiên a là một object Null 
// và ta get phần tử đầu tiên gán vào cho obj svout thì svout sẽ là obj null
// Null Point Exception chỉ xảy ra khi ta cố truy cập vào object null svout 
// Với method getHoTen();

class Sinhvien {
	String hoTen;
	public String getHoTen() {
		this.hoTen = hoTen;
		return this.hoTen;
	}
}