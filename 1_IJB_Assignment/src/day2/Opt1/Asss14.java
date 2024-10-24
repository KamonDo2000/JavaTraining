package day2.Opt1;

public class Asss14 {
//	Khi nào cần dùng các ký tự L, F, D… sau các số nguyên, số thực trong Java? 
//	Khi nào thì không cần dùng đến các ký tự này mà Java vẫn tự hiểu được các số thuộc kiểu dữ liệu gì?	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Khi chúng ta khai báo các biến Long thêm L phía sau để nó hiểu là Long, Float thêm F phía sau, Double thêm D phía sau
		float a = 12.9F;
		double b = 23.84F;
		long c = 3929333L;
//		một kiểu của ép kiểu tường minh, để f sau tương tự (float)số
//		Nếu không có ký hiệu phía sau thì chương trình sẽ hiểu số không có chấm động là Int nếu vượt quá 2 tỉ 1 thì phải thêm L phía sau
//		số có chấm động thì sẽ lỗi.
		long d = 392039;
		float s = 293.394F;
//		ta có thể b = (float)9 / 29;
//		thì ép thằng 9 qua float mới chia, hoặc b = 9 / 29f;
	}
}
