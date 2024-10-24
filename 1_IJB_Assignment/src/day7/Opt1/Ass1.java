package day7.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ass1 {

//	Viết đoạn chương trình tạo mới một danh sách chứa các giá trị kiểu chuỗi
//	vào Danh sách và hiển thị tất cả các giá trị trong danh sách;
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		ArrayList<String> listString = new ArrayList<String>();
		
		String s;
		do {
			if(listString.size()==0) {
				System.out.println("Enter 2 lan de ngung nhap!!!\n");
			}
			System.out.printf("\nNhap gia tri ");
			s = in.nextLine();
			if(!s.isEmpty()) {
				listString.add(s);
			}
		}while(!s.isEmpty());
		
		ArrayList<String> newStringList = new ArrayList<String>(listString);
		
		System.out.println(newStringList);
	}
	
	

}
