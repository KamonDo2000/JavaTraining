package controller;

import java.util.List;
import java.util.Scanner;

import model.Person;
import model.Student;
import view.InputData;

public class UpdateSV {
	static Scanner sc = new Scanner(System.in);

	public static void updateSV(List<Person> arrPer) {

		System.out.print("Nhap ma SV can Update: ");
		String msv = InputData.inputID();

		for (Person per : arrPer) {
			if (per instanceof Student && ((Student) per).getStudentId().equalsIgnoreCase(msv)) {
				update((Student) per);
				System.err.println("cap nhat thanh cong");
				return;
			}
		}
		System.err.println("Khong co cap nhat");
	}

	private static void update(Student sv) {
		sv.setFullName(InputData.inputName());
		sv.setGender(InputData.inGender());
		sv.setEmail(InputData.inEmail());
		sv.setPhone(InputData.inPhone());
		sv.setPractice(InputData.inputPractice());
		sv.setTheory(InputData.inputTheory());
	}

}
