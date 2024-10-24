package ass_series301;

public class SumAverageRunningInt {
	public static void show(double num1, double num2) {
		double sum;
		if ((num1 + num2) % 2 == 0) {
			sum = (num2 / 2) * (num1 + num2);
		} else {
			double lastnum = num2 - 1;
			sum = (lastnum / 2) * (num1 + lastnum) + num2;
		}

		System.out.println("Average of all 100 first numbers " + (sum / num2));
	}
}
