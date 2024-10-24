package day9.Otp2;

import java.io.FileOutputStream;

public class Ass1 {
//	Code lại đoạn code có thêm exception và cho biết nó báo exception loại nào:
//	String s = null;
//	System.out.println(s.length());
//
//	FileOutputStream outputStream;
//	outputStream = new FileOutputStream("E://file.txt");
//	outputStream.write(65);
//	outputStream.close();

	public static void main(String[] args) {
//		Null point Exception
		String s = null;
		try {
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println(e);
		}
//		File Not Found Exception 
//		vì nếu đường dẫn chỉ là file thì nó sẽ tự tạo, 
//		nhưng nó sẽ không tìm ra được một folder cha
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("E:/test/file.txt");
			outputStream.write(65);
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
	}

}
