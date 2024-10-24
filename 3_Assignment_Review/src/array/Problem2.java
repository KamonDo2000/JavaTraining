package array;

public class Problem2 {

	public static void main(String[] args) {
		int[] a = { 0, 2, 1, 0, 1, 2, 1, 0 };

		a = ex1(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] ex1(int[] a) {
		int[] newA = new int[a.length];
		int index = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				index++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				newA[index] = a[i];
				index++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 2) {
				newA[index] = a[i];
				index++;
			}
		}
		return newA;
	}

}
