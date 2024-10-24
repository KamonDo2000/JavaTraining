package days10.Otp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*Viết Hàm in ra tất cả các cặp duy nhất trong mảng số nguyên A chưa được sắp xếp có tổng bằng nhau.
Ví dụ 1:
Input: A[] = { 4, 23, 65, 67, 24, 12, 86}
Output: Cac cap: (4, 86) (23, 67) co tong bang: 90
Ví dụ 2: 
Input: A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11}
sum
Output:
Cac cap: ( 4, 12) ( 6, 10)  co tong bang: 16
Cac cap: ( 10, 22) ( 21, 11)  co tong bang: 32
Cac cap: ( 12, 21) ( 22, 11)  co tong bang: 33
Cac cap: ( 22, 21) ( 32, 11)  co tong bang: 43
Cac cap: ( 32, 21) ( 42, 11)  co tong bang: 53
Cac cap: ( 12, 42) ( 22, 32)  co tong bang: 54
Cac cap: ( 10, 54) ( 22, 42)  co tong bang: 64
*/

public class Ass4 {

	public static void main(String[] args) {
		int[] arr = { 6, 6, 6, 6, 6, 4, 12, 10, 22, 54, 32, 42, 21, 11 };

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
		
		System.out.println(list);
		
		int sumC1, sumC2;

		for (int i_1 = 0; i_1 < list.size(); i_1++) {
			for (int i_2 = i_1 + 1; i_2 < list.size(); i_2++) {
				sumC1 = list.get(i_1) + list.get(i_2);
				for (int i_3 = i_1 + 1; i_3 < list.size(); i_3++) {
					for (int i_4 = i_3 + 1; i_4 < list.size(); i_4++) {
						sumC2 = list.get(i_3) + list.get(i_4);
						if (sumC1 == sumC2)
							System.out.printf("( %d, %d) ( %d, %d)\n", list.get(i_1), list.get(i_2), list.get(i_3), list.get(i_4));
					}
				}
			}
		}
	}

}
