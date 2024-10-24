package index;

import java.util.ArrayList;
import java.util.List;

import buffer.Readfile;
import model.Apartment;
import model.House;
import model.LowCostHouse;
import model.LuxuryHouse;
import service.InsertData;
import service.ShowAllData;
import view.MenuView;

public class Main {

	public static void main(String[] args) {

		List<House> listHouse = new ArrayList<>();

		System.out.println("=========== Student Management ===========");

		do {
			int choise = MenuView.menu();

			switch (choise) {
			case 1:
				System.out.println("----Insert Data to file------");
				listHouse = Readfile.input();
				InsertData.insertData(listHouse);
				System.out.println("\n");
				continue;
			case 2:
				System.out.println("----show------");
				ShowInformation(listHouse);
				System.out.println("\n");
				continue;
			case 3:
				System.out.println("----S------");
				List<House> listHouseNew = ShowAllData.getData();
				listHouseNew.sort((obj1, obj2) -> Float.compare(obj2.getActualPrice(), obj1.getActualPrice()));
				ShowInformation(listHouseNew);
				System.out.println("\n");
				continue;
			case 4:
				System.out.println("----R------");
				
				System.out.println("\n");
				continue;
			case 5:
				System.out.println("----I------");

				System.out.println("\n");
				continue;
			case 0:
				System.err.println("\n========================== Exits Program ==========================");
				return;
			default:
				continue;
			}
		} while (true);

	}

	public static void ShowInformation(List<House> listHouse) {
		for (House house : listHouse) {
			if (house instanceof Apartment) {
				((Apartment) house).showInfo();
			}
			if (house instanceof LowCostHouse) {
				((LowCostHouse) house).showInfo();
			}
			if (house instanceof LuxuryHouse) {
				((LuxuryHouse) house).showInfo();
			}
		}
	}
}
