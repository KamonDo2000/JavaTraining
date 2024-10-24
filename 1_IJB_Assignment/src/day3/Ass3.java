package day3;

import java.util.Scanner;

public class Ass3 {
//	Viết một chương trình Java để xác định điểm của học sinh.
//	Chương trình sẽ đọc ba loại điểm (bài kiểm tra, điểm giữa kỳ và cuối kỳ) và xác định điểm dựa trên các quy tắc sau:
//	-nếu điểm trung bình> = 90% => điểm = A
//	-nếu điểm trung bình> = 70% và <90% => điểm = B
//	-nếu điểm trung bình> = 50% và <70% => điểm = C
//	-nếu điểm trung bình <50% => lớp = F


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float test, half, full;
		
		do {
			System.out.print("Nhập điểm kiểm tra: ");
			test = in.nextFloat();
			System.out.print("\nNhập điểm giữa kỳ: ");
			half = in.nextFloat();
			System.out.print("\nNhập điểm cuối kỳ: ");
			full = in.nextFloat();
			if(test<0|| half<0|| full<0 || test>10|| half>10|| full>10) {
				System.out.println("\nĐiểm số chỉ từ 0 -> 10");
				System.out.println("Mời nhập lại!!!\n\n");
			}
		}while(test<0|| half<0|| full<0 || test>10|| half>10|| full>10);
		
		float avg = (test+half+full)/3;
		System.out.print("\nĐiểm trung bình: "+avg);
		if(avg>=9){
			System.out.println("\nBạn có điểm A ");
		}else if(avg >=7) {
			System.out.println("\nBạn có điểm B ");
		}else if(avg >=5) {
			System.out.println("\nBạn có điểm C ");
		}else {
			System.out.println("\nBạn có điểm F");
		}
	}

}
