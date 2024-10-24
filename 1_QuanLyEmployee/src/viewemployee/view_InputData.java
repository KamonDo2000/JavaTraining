package viewemployee;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import modelemployee.model_CheckID;

public class view_InputData {
	static Scanner sc = new Scanner(System.in);

	public static final String REGEX_ID = "^[1-9][0-9]{3}$";
	public static final String REGEX_NAME = "^[a-zA-Z ]{6,}$";
	public static final String REGEX_ADDRESS = "^[a-zA-Z 0-9]{4,}$";
	public static final String REGEX_SALARY = "^[1-9][0-9]{3,}$"; 

	public static long inputID(Connection conn) {
		Pattern rg_id = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập ID của nhân viên: ");
				String id = sc.nextLine();
				if (!rg_id.matcher(id).find()) {
					System.out.println("1000 <= ID <= 9999!!");
				} else if (model_CheckID.checkID(conn, Long.parseLong(id))) {
					System.out.println("Đã có nhân viên ID này");
				} else {
					return Long.parseLong(id);
				}
			} catch (Exception e) {
				System.out.println("ID phải là một số!!");
			}
		} while (true);
	}

	public static String inputName() {
		Pattern rg_name = Pattern.compile(REGEX_NAME);
		do {
			try {
				System.out.println("Nhập tên của nhân viên: ");
				String name = sc.nextLine();
				if (rg_name.matcher(name).find()) {
					return name;
				} else {
					System.out.println("Tên nhập vào chỉ chữ và ít nhất 6 ký tự!!");
				}
			} catch (Exception e) {
				System.out.println("Tên nhập vào không hợp lệ!!");
			}
		} while (true);
	}

	public static int inputAge() {
		do {
			try {
				System.out.println("Nhập tuổi của nhân viên: ");
				int age = Integer.parseInt(sc.nextLine());
				if (age < 18 || age > 65) {
					System.out.println("18 <= age <= 65!!");
				} else {
					return age;
				}
			} catch (Exception e) {
				System.out.println("Tuổi phải là một số!!");
			}
		} while (true);
	}

	public static String inputAddress() {
		Pattern rg_address = Pattern.compile(REGEX_ADDRESS);
		do {
			try {
				System.out.println("Nhập địa chỉ của nhân viên: ");
				String address = sc.nextLine();
				if (rg_address.matcher(address).find()) {
					return address;
				} else {
					System.out.println("địa chỉ chỉ có số nhà và chữ!!");
				}

			} catch (Exception e) {
				System.out.println("địa chỉ không hợp lệ!!");
			}
		} while (true);
	}

	public static double inputSalary() {
		Pattern rg_address = Pattern.compile(REGEX_SALARY);
		do {
			try {
				System.out.println("Nhập Lương của nhân viên: ");
				String Salary = sc.nextLine();
				if (rg_address.matcher(Salary).find()) {
					return Double.parseDouble(Salary);
				} else {
					System.out.println("Lương lớn hơn 1000 USD!!");
				}

			} catch (Exception e) {
				System.out.println("Lương phải là một số!!");
			}
		} while (true);
	}

	public static int inputSumTimeWork() {
		do {
			try {
				System.out.println("Nhập số giờ làm của nhân viên: ");
				int sumTime = Integer.parseInt(sc.nextLine());
				if (sumTime < 1 || sumTime > 40) {
					System.out.println("1 <= số giờ <= 40!!");
				} else {
					return sumTime;
				}

			} catch (Exception e) {
				System.out.println("số giờ làm phải là một số!!");
			}
		} while (true);
	}

}
