package buffer;

public class CheckReadfile {
	private static final String RX_TYPE = "^[123]$";
	private static final String RX_ID = "^SV[\\d]{3}$";
	private static final String RX_NAME = "^[a-zA-Z ]{3,100}$";
	private static final String RX_PHONE = "^[\\d]{10}$";
	private static final String RX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";

	public static String checktype(String txt) throws CheckStdNoException {
		if (txt.matches(RX_TYPE)) {
			return txt;
		}
		throw new CheckStdNoException("StdNo");
	}

	public static String checkStdName(String txt) throws CheckStdNameException {
		if (txt.matches(RX_NAME)) {
			return txt;
		}
		throw new CheckStdNameException("StdName");
	}

	public static String checkStdPhone(String txt) throws CheckStdPhoneException {
		if (txt.matches(RX_PHONE)) {
			return txt;
		}
		throw new CheckStdPhoneException("StdPhone");
	}

	public static String checkStdEmail(String txt) throws CheckStdEmailException {
		if (txt.matches(RX_EMAIL)) {
			return txt;
		}
		throw new CheckStdEmailException("StdEmail");
	}
}
