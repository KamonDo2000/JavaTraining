package day6.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ass2_ArrayList {
//	Viết hàm Thay đổi 01 phần tử có giá trị X vào vị trí Y 
//	trong mảng số nguyên bất kỳ (Mảng số nguyên đã nhập trước đó);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap độ lớn của mảng N:  ");
		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// Không có tác dụng nếu lấy size, thằng arr khởi tạo với (8) có nghĩa nó danh
		// riêng ra 8 vùng nhớ để khi add vào 8 thằng đầu sẽ add nhanh hơn, nhưng size
		// lúc ban đầu vẫn sẽ bằng 0

		for (int i = 0; i < n; i++) {
			System.out.printf("Nhap Gia tri thu %d:  ", i + 1);
			arr.add(in.nextInt());
		}
		System.out.println();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("Vi tri thu:  " + (i + 1) + " : \t" + arr.get(i));
		}

		System.out.println();
		System.out.print("Vi tri muon thay the: ");
		int y = in.nextInt();
		System.out.print("Nhap gia Tri X:  ");
		int x = in.nextInt();

		arr.remove(y - 1);
		arr.add(y - 1, x);
		System.out.println(arr);

	}
}
