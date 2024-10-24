package day4;

public class Ass1 {

//	Viết chương trình Java bằng cách sử dụng  vòng lặp for để in mẫu sau
//	"*
//	**
//	***
//	****
//	*****

	public static void main(String[] args) {

		int i, j;

		for (i = 0; i <= 4; i++) {
			for (j = 0; j <= i; j++) {
				if (i == 0) {
					System.out.print("\"");
				}
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

}
