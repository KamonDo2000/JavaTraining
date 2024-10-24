package ass_series301;

public class ArrayReverse {

	public static void show() {
		int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
		
		System.out.print("Original Array: ");
		for (int i : myIntArray) {
			System.out.print(i+ " ");
		}
		
		System.out.print("\nReversed Array: ");
		for (int i = myIntArray.length-1; i >= 0; i--) {
			System.out.print(myIntArray[i]+ " ");
		}
	}

}
