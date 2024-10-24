package index;

import java.util.ArrayList;
import java.util.List;

import control.ControlFixed;
import control.ControlHelicopter;
import control.CreateObject;
import model.AirportsModel;
import model.FixedwingsModel;
import model.HelicoptersModel;

public class AirplaneManagement {

	public static void main(String[] args) {
		List<AirportsModel> arrAirP = new ArrayList<>();
		List<FixedwingsModel> arrFixed = new ArrayList<>();
		List<HelicoptersModel> arrHeli = new ArrayList<>();

		System.out.println("----Manager Candidate Application------");

		do {
			int choose = Menu.menu();

			switch (choose) {
			case 1:
				arrAirP.add(CreateObject.createAirport());
				continue;
			case 2:
				arrFixed.add(CreateObject.createFixedWing());
				continue;
			case 3:
				arrHeli.add(CreateObject.createHelicopters());
				continue;
			case 4:
				ControlFixed.addFixWingToAir(ControlFixed.chooseListFixWing(arrFixed), arrFixed, arrAirP);
				continue;
			case 5:
				ControlHelicopter.addHeliToAir(ControlHelicopter.chooseListHeli(arrHeli), arrHeli, arrAirP);
				continue;

			case 0:
				System.err.println("\n========================== Exits Program ==========================");
				return;
			default:
				continue;
			}
		} while (true);

	}

}
