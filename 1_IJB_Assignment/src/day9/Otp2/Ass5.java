package day9.Otp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ass5 {

	public static void main(String[] args) {
//		Thay đổi phương thức Cat dưới đây cho hoàn thiện
//		cat("E://file.txt");
	}

	public static void cat(File file) {
		RandomAccessFile input = null;
		String line = null;

		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		}
//		input = new RandomAccessFile(file, "r");
		catch (FileNotFoundException e) {
			System.out.println(e);
		}

//		input.readLine()
		catch (IOException e) {
			System.out.println(e);
		}

		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
}
