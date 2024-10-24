package buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import model.Apartment;
import model.House;
import model.LowCostHouse;
import model.LuxuryHouse;

public class Readfile {

	public static List<House> input() {
		List<House> listHouse = new ArrayList<>();
//		List<String> listErr = new ArrayList<>();

		try {
			FileReader fr = new FileReader("file.csv");
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			int linessn = 0;

			while (true) {
				line = br.readLine();
				StringBuilder popErr = new StringBuilder();

				if (line == null) {
					break;
				} else {
					linessn++;
				}

				String[] txt = line.split(",");
				House house = null;
				if (txt[0].equals("1")) {
					house = insertLux(txt);
				}
				if (txt[0].equals("2")) {
					house = insertLow(txt);
				}
				if (txt[0].equals("3")) {
					house = insertApart(txt);
				}

				// Declare popErr String
				// Count lenght popErr String Begin
				popErr.append("Line " + linessn + ":  Co loi sai dinh dang ");

				// Check validation input ID, if err insert then insert Null
				listHouse.add(house);
			}
			br.close();
			fr.close();
			System.out.println("suscess!");
			return listHouse;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	private static void insertHouse(String[] txt, House house) {
		house.setType(txt[0]);
		house.setHouseID(txt[1]);
		house.setSquare(txt[2]);
		house.setDirection(txt[3]);

		house.setStartDate(txt[4]);

		house.setCompletionDate(txt[5]);

		house.setRightCertificate(txt[6]);
		house.setPrice(Float.parseFloat(txt[7]));
	}

	private static House insertApart(String[] txt) {
		House apart = new Apartment();
		insertHouse(txt, apart);
		((Apartment) apart).setFloor(txt[10]);
		((Apartment) apart).setView(txt[11]);
		return apart;
	}

	private static House insertLow(String[] txt) {
		House apart = new LowCostHouse();
		insertHouse(txt, apart);
		((LowCostHouse) apart).setTransferYear(txt[12]);
		return apart;
	}

	private static House insertLux(String[] txt) {
		House apart = new LuxuryHouse();
		insertHouse(txt, apart);
		((LuxuryHouse) apart).setProjectName(txt[8]);
		((LuxuryHouse) apart).setInvestor(txt[9]);
		((LuxuryHouse) apart).setView(txt[11]);
		return apart;
	}

}
