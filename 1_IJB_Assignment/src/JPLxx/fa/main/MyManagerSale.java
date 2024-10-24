package JPLxx.fa.main;

import java.util.ArrayList;

import JPLxx.fa.entities.Sale;

public class MyManagerSale {

	public static void main(String[] args) {
//		Sale saler1 = new Sale("hello", 21, "huus", 2900, 120, ++saler_count);
		ArrayList<Sale> sale = new ArrayList<Sale>();

		for (int i = 0; i < 3; i++) {
			Sale ss = new Sale();
			ss.inputInfo();
			ss.setID(i + 1);
			sale.add(ss);

//bản chất là mỗi khi khởi tạo là truyền vào đối tượng này một cái sale count 
//còn thằng class không chứa giá trị, nếu để nó chứa giá trị thì giá trị là của nó, 
//là static thì không thể thay đổi mà vẫn giữ data cũ được do tất cả các thằng dùng chung
		}

		for (int i = 0; i < 3; i++) {
			sale.get(i).printInfo();
			System.out.printf("Tiền Bonus:  %4.2f", sale.get(i).getBonus());
			System.out.println("\n\n===================================================");
		}
		
		System.out.println("Tổng số nhân viên: "+ Sale.Sale_Count);

	}

}
