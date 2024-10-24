package view;

import java.util.Scanner;

public class InputPlan {
	private static Scanner sc = new Scanner(System.in);

	private static final String RG_ID = "^\\d{5}$";
	private static final String RG_MODEL = "^[\\w ]{1,40}";

	protected static String inputID(String typeID) {
		do {
			System.out.print("Input ID: ");
			String id = sc.nextLine();
			if (id.matches(RG_ID) && typeID.equalsIgnoreCase("fixed")) {
				return "FW" + id;
			} else if (id.matches(RG_ID) && typeID.equalsIgnoreCase("helicopter")) {
				return "RW" + id;
			} else if (id.matches(RG_ID) && typeID.equalsIgnoreCase("airport")) {
				return "AP" + id;
			} else {
				System.err.println("sorry input 5 digits!!");
				continue;
			}
		} while (true);
	}

	public static String inputModel() {
		do {
			System.out.print("Input Model: ");
			String model = sc.nextLine();

			if (model.matches(RG_MODEL)) {
				return model;
			} else {
				System.err.println("sorry input max 40 characters!!");
				continue;
			}
		} while (true);
	}

	public static float inputSpeed() {
		do {
			try {
				System.out.print("Input speed: ");
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.println("input float value!!!");
				continue;
			}
		} while (true);
	}

	public static float inputEmptyWeight() {
		do {
			try {
				System.out.print("Input empty Weight: ");
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.println("input float value!!!");
				continue;
			}
		} while (true);
	}

	public static float inputMaxWeight(float emptyWeight) {
		do {
			try {
				System.out.print("Input max takeoff weight: ");
				float maxWeight = Float.parseFloat(sc.nextLine());

				if (maxWeight > (emptyWeight * 1.5)) {
					throw new NumberFormatException();
				}

				return maxWeight;
			} catch (NumberFormatException e) {
				System.err
						.println("The max takeoff weight of helicopter does not excess 1.5 times of its empty weight.");
				continue;
			} catch (Exception e) {
				System.err.println("input float value!!!");
				continue;
			}
		} while (true);
	}

}
