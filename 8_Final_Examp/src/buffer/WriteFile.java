package buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
	public static void exportFileErr(List<String> listErr) {

		try {
			File file = new File("error.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (String str : listErr) {
				bw.write(str);
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
