package day9.Otp1;

public class Ass5 {

	public static void main(String[] args) {
//		Đoạn code sau có throw NullPointerException hay không? Vì sao?
				String a = null;
				a = a + "Hello";
				System.out.println(a);
	}
}


//nó sẽ không bị Null point exception dù ta đang cố chỉnh sửa một object null
//obj a của class String đang null và ta chỉnh sửa nó. 
//Nhưng trường hợp này ta thực hiện cộng chuỗi String.
//Chuỗi này lưu trên String Poll chứ không phải lưu trên Heap vì thế nên nó sẽ cộng chuỗi

//Chuỗi sẽ được lưu trên Heap nếu ta khởi tạo nó bằng từ khóa new