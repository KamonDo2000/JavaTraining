package view;

public class MergeSort {
	public static void mergeSort(Integer[] list) {
		if (list.length <= 1) {
			return;
		}

		int mid = list.length / 2;
		Integer[] left = new Integer[mid];
		Integer[] right = new Integer[list.length - mid];

		System.arraycopy(list, 0, left, 0, mid);
		System.arraycopy(list, mid, right, 0, list.length - mid);

		mergeSort(left);
		mergeSort(right);

		merge(list, left, right);
	}

	public static void merge(Integer[] list, Integer[] left, Integer[] right) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				list[k++] = left[i++];
			} else {
				list[k++] = right[j++];
			}
		}

		while (i < left.length) {
			list[k++] = left[i++];
		}

		while (j < right.length) {
			list[k++] = right[j++];
		}
	}

	public static void main(String[] args) {
		Integer[] list = { 9, 5, 2, 7, 1, 8, 6, 3, 4 };

		System.out.println("Original List: \n");
		for (Integer i : list) {
			System.out.print(i+ " ");
		}

		mergeSort(list);

		System.out.println("\n\nSorted List: \n");
		for (Integer i : list) {
			System.out.print(i+ " ");
		}
	}
}
