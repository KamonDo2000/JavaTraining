package day2.Opt2;

import java.util.Scanner;

public class Ass4 {
//	Giải phương trình bậc 2	
	public static void main(String[] args) {
		System.out.println("giải phương trình AX^2 + BX + C = 0");
		Scanner Input = new Scanner(System.in);
		
		System.out.print("Nhap vao gia tri cua A: ");
		float a = Input.nextFloat();
		System.out.print("Nhap vao gia tri cua B: ");
		float b = Input.nextFloat();
		System.out.print("Nhap vao gia tri cua C: ");
		float c = Input.nextFloat();
		
		float delta = (b*b)-4*a*c;
		
		if(a==0) {
			PTBN(b, c);
			return;
		}
		if(delta < 0){
			System.out.println("Phuong Trinh vo nghiem");
		}
		if(delta == 0) {
			System.out.println("Phuong trinh co nghiem kep X1 = X2 = "+ (-b/(2*a)));
		}
		if(delta >0) {
			System.out.println("Nghiem X1 = "+ ( (-b+Math.sqrt(delta))/(2*a) ));
			System.out.println("Nghiem X2 = "+ ( (b+Math.sqrt(delta))/(2*a) ));
		}
		
	}
	
	public static void PTBN(float b,float c) {
		if(b == 0) {
			if(c != 0) {
				System.out.println("phương trình này vô nghiệm");
			}
			else {
				System.out.println("Biến x có vô số nghiệm");
			}
		}
		else {
			System.out.println("Biến x có giá trị là: " + (-c/b));		
		}
	}
}