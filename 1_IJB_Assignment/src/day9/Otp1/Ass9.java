package day9.Otp1;

import java.util.ArrayList;

public class Ass9 {

	public static void main(String[] args) {
//		Đoạn code sau có thể xảy ra hay chắc chắn 
//		xảy ra NullPointerException? Xảy ra ở vị trí nào?
		ArrayList<GiaoVien> a = new ArrayList<GiaoVien>();
		GiaoVien gv = new GiaoVien();
		a.add(gv);
		System.out.println(a.get(0).getHoTen().toString());
	}
}

//có thể xảy ra Null Point Exception, và xảy ra khi String HoTen trong object gv Null
// mà HoTen là obj String khi null thì không thể truy cập method toString được.


class GiaoVien {
	String HoTen="hello";

	public String getHoTen() {
		this.HoTen = HoTen;
		return HoTen;
	}
}