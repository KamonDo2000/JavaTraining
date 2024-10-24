import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		docFile();
		ghiFile();
	}

	private static void docFile() {
		try {
			FileReader fr = new FileReader("data.csv");
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}

			br.close();
			fr.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private static void ghiFile() {
		String txt = "Nguyen van A";
		String[] arrTxt = { "Nguyen van A", "Nguyen van B", "Nguyen van C" };

		try {
			FileWriter fw = new FileWriter("data.csv");
			BufferedWriter bw = new BufferedWriter(fw);
//Ghi 1 String
			bw.write(txt);

//Ghi 1 mảng String
			for (String s : arrTxt) {
				bw.write(s);
				bw.newLine();
			}

			bw.close();
			fw.close();

			System.out.println("Success!!");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
