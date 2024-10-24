package utils;

public class CheckValidDate {

	public boolean checkValidDate(String date) throws DateException {
		String[] dateArr = date.split("/");
		checkNumberDate(dateArr[0]);
		if (Integer.parseInt(dateArr[0]) > 31 || Integer.parseInt(dateArr[0]) < 1) {
			throw new DateException("Date " + dateArr[0] + " is invalid, date can only be between 1 and 31 !!!");
		}
		if (Integer.parseInt(dateArr[1]) > 12 || Integer.parseInt(dateArr[1]) < 1) {
			throw new DateException("Month " + Integer.parseInt(dateArr[1]) + " is invalid, month can only be between 1 and 12 !!!");
		}
		if (Integer.parseInt(dateArr[2]) < 1900 || Integer.parseInt(dateArr[2]) > 9999) {
			throw new DateException("Year " + Integer.parseInt(dateArr[2]) + " is invalid, year can only be between 1900 and 9999 !!!");
		}
		switch (Integer.parseInt(dateArr[1])) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (Integer.parseInt(dateArr[0]) > 30) {
				throw new DateException("Date " + dateArr[0]
						+ " is invalid, date can only be between 1 and 30 with the month of " + Integer.parseInt(dateArr[1]) + " !!!");
			}
			break;
		case 2:
			if (Integer.parseInt(dateArr[2]) % 4 == 0 && Integer.parseInt(dateArr[0]) > 29) {
				throw new DateException("Date " + dateArr[0]
						+ " is invalid, date can only be between 1 and 30 with leap year " + Integer.parseInt(dateArr[1]) + " !!!");
			}
			if (Integer.parseInt(dateArr[2]) % 4 != 0 && Integer.parseInt(dateArr[0]) > 28) {
				throw new DateException("Date " + dateArr[0]
						+ " is invalid, date can only be between 1 and 30 with non-leap year " + Integer.parseInt(dateArr[1]) + " !!!");
			}
		default:
			break;
		}
		return true;
	}

	public boolean checkNumberDate(String inputNumber) throws DateException {
		if (!inputNumber.matches("-?\\d+")) {
			throw new DateException("Invalid date !!!");
		}
		return true;
	}
}
