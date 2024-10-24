package view;

import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.CheckBookModel;

public class UpdateBookView {
	public static final String REGEX_ID = "^\\d{4}$";
	public static final String REGEX_TITLE = "^.{6,}$";
	private static Scanner sc = new Scanner(System.in);

	public static int updateBookByID(Connection conn) {
		Pattern rgID = Pattern.compile(REGEX_ID);
		do {
			try {
				System.out.println("Nhập ID: ");
				String id = sc.nextLine();
				if (!rgID.matcher(id).find()) {
					System.out.println("ID là số có 4 ký tự!!");
				} else if (CheckBookModel.checkID(conn, Integer.parseInt(id))) {
					return Integer.parseInt(id);
				} else {
					System.out.println("Chưa có ID này hãy thêm ID trước");
					return 0;
				}
			} catch (Exception e) {
				System.out.println("Phải là một số!!");
			}
		} while (true);
	}

	public static String updateBookByTitle(Connection conn) {
		Pattern rgTitle = Pattern.compile(REGEX_TITLE);
		do {
			try {
				System.out.println("Input Title for Book: ");
				String title = sc.nextLine().trim();
				if (!rgTitle.matcher(title).find()) {
					System.out.println("Tên ít nhất 6 ký tự!!");
				} else if(CheckBookModel.checkTitle(conn, title)){
					return title;
				}else {
					System.out.println("Chưa có book này hãy thêm Book trước");
					return null;
				}
			} catch (Exception e) {
				System.out.println("Ít nhất 6 ký tự!!");
			}
		} while (true);
	}

}
