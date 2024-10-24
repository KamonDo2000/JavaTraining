package day6.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass4_ArrayList {
//	Viết hàm Thay N giá trị (N < 5 và được nhập vào từ bàn phím) 
//	vào các vị trí được xác định trong mảng K (Khai báo trước hoặc nhập vào các vị trí cần chèn) 
//	vào mảng số nguyên A cho trước hoặc nhập vào (mảng A có kích thước M); 
//	Gợi ý: Nên sử dụng hàm ở bài 7 để giải quyết bài toán;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap Kich thuoc Array A:  ");
		int M = in.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		for(int i=0; i<M;i++) {
			System.out.print("Nhap gia tri mang A: ");
			A.add(in.nextInt());
		}
		for (Integer i : A) {
			System.out.print("{"+i+"}  ");
		}
//======================================================================================================	

		int N;
		ArrayList<Integer> arrN = new ArrayList<Integer>();
		do {
			System.out.print("\n\nNhap so gia tri muon thay (N<5):  ");
			N = in.nextInt();
		}while(N>=5);
//======================================================================================================	
		
		int[] K= new int[N];
		for(int i=0;i < N;i++) {
			do {
				System.out.print("Nhap vi tri muon thay thu "+(i+1)+" : ");
				K[i]=in.nextInt();
				if(K[i]>A.size() || K[i]< 1) {
					System.out.println("\nVuot qua kich thuoc vi tri mang!!!");
				}
			}while(K[i]>A.size() || K[i]< 1);
		}		
//======================================================================================================	
		
		for(int i=0; i<N;i++) {
			System.out.print("\n\nNhap gia tri muon thay cho vi tri "+K[i]+" : ");
			arrN.add(in.nextInt());
		}	
//======================================================================================================	
		for(int i=0; i<N; i++) {
			A.remove(K[i]-1);
			A.add(K[i]-1, arrN.get(i));
		}
		 for (int i : A) {
			System.out.println(i);
		}
		
	}
}
