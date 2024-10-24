package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import model.Customer;

public class OutputToFile {
	public static void outputToFile(String fileName, List<Customer> listCus) {

		try {
			File file = new File(fileName + ".dat");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (String cus : Main.findAll(listCus)) {
				bw.write(cus);
				bw.newLine();
			}

			bw.close();
			fw.close();

			System.out.println("Success!");
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
