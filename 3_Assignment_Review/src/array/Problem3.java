package array;

public class Problem3 {
	public static void main(String[] args) {

		int goal = 11;
//		int[] arr = { -5, 1, -40, 20, 6, 8, 7 };
		int[] arr = { 5, 1, 4, 2, 6, 8, 7 };
		int check = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == goal) {
					if (check == 1) {
						System.out.print(" or ");
					}
					System.out.print("true ");
					System.out.print("( " + arr[i] + ", " + arr[j] + " )");
					check = 1;
				}
			}
		}
		if (check == 0) {
			System.out.println("false");
		}

	}
}
