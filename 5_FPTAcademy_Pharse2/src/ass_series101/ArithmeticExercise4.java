package ass_series101;

public class ArithmeticExercise4 {
	private static final double PI = 3.1415926535897932384626433;
	
	public static void show() {
		double radius = 7.5 ;
		double perimeter = 2*PI * radius;
		double area = PI* Math.pow(radius, 2);
		
		System.out.println("Perimeter is = "+ perimeter);
		System.out.println("Area is = "+ area);
	}

}
