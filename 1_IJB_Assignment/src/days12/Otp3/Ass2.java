package days12.Otp3;

import java.util.LinkedList;
//Hiện tại đang có n người đứng trước quầy bán vé tại một rạp chiếu phim. 
//Mỗi người cầm một tờ tiền trị giá 25, 50 hoặc 100 đồng. 
//Mảng arr chứa mệnh giá tờ tiền mà mỗi người đứng trong hàng đang giữ theo thứ tự.
//Mỗi chiếc vé xem phim có giá là 25 đồng. Ban đầu người bán vé có 0 đồng, hãy xác định xem người bán vé có thể bán hết vé 
//và trả đúng tiền thừa cho n người đó hay không. Chú ý: Phải bán vé đúng theo thứ tự của những người đã sắp xếp trong mảng
//Ví dụ:
//Với arr = {25, 25, 50, 50} thì cinemaQueue(arr) = true

public class Ass2 {
	public static void main(String[] args) {
		int[] arr1 = { 25, 25, 50, 50 };
		int[] arr2 = { 25, 25, 50, 25, 50, 100 };
		int[] arr3 = { 25, 25, 50, 50, 50 };

		System.out.println(cinemaQueue(arr1));
		System.out.println(cinemaQueue(arr2));
		System.out.println(cinemaQueue(arr3));
	}

	public static boolean cinemaQueue(int[] arr) {
		LinkedList<Integer> momo = new LinkedList<>();
		int giaVe = 25;

		for (int cast : arr) {
			momo.add(cast); // nhận tiền khách

			while (!momo.isEmpty() && momo.peekLast() > giaVe) { //lặp lại kiểm tra trong túi khi còn tiền và tiền > giá vé ko
				int tienPhaiTraKhach = momo.remove() - giaVe; 
				// Kiểm tra xem có đủ tiền trả tiền thừa không
				if (momo.isEmpty() || tienPhaiTraKhach > momo.getLast()) {
					return false; //rỗng túi hoặc không còn khả năng chi trả :))
				}else {
					momo.removeLast(); // Trả tiền thừa
				}
			}
		}

		return true; // thu và trả tiền đều ok hết rồi thì true
	}
}
