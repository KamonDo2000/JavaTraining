package array;

public class Problem1 {

	public static void main(String[] args) {
		int[] a = { 4, 8, 0, 0, 2, 0, 1, 0 };
		ex1(a);
		System.out.println();
		ex2(a);
	}

	public static void ex1(int[] a) {
		int[] b = new int[a.length];
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				b[index] = a[i];
				index++;
			}
		}
		for (int i : b) {
			System.out.print(i + " ");
		}
	}

	public static void ex2(int[] a) {
		for (int i = 0; i < a.length;) {
			if (checkArrFullZero(a, i)) {
				break;
			}
			if (a[i] == 0) {
				hellArr(a, i);
			}
			if (a[i] != 0) {
				i++;
			}

		}

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static int[] hellArr(int[] a, int i) {
		for (int j = i; j < a.length - 1; j++) {
			a[j] = a[j + 1];
		}
		return a;
	}

	private static boolean checkArrFullZero(int[] a, int i) {
		for (int j = i; j < a.length; j++) {
			if (a[j] != 0) {
				return false;
			}
		}
		return true;
	}

}
