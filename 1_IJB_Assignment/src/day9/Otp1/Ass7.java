package day9.Otp1;

import java.util.ArrayList;

public class Ass7 {

	public static void main(String[] args) {
//		Để đoạn code sau không throw NullPointerException
//		thì phải sửa lại code như thế nào để không bị ảnh hưởng đến dữ liệu?
				ArrayList<Sinhvien> a = new ArrayList<Sinhvien>();
				Sinhvien sv = new Sinhvien();
				a.add(sv);
				Sinhvien svout = a.get(0);
				System.out.println(svout.getHoTen());
	}
}

//	Để đoạn code không throw Null point exception thì obj sv không được null
//thì mới có thể truy cập getHoTen. ta khởi tạo obj sv với key new