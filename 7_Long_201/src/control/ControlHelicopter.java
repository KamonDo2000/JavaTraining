package control;

import java.util.ArrayList;
import java.util.List;

import model.AirportsModel;
import model.HelicoptersModel;
import view.InputAirport;
import view.InputHelicopter;

public class ControlHelicopter {

	public static void addHeliToAir(String id, List<HelicoptersModel> arrHeli, List<AirportsModel> arrAirP) {
		HelicoptersModel heliObj = null;
		for (HelicoptersModel obj : arrHeli) {
			if (id.equalsIgnoreCase(obj.getId())) {
				heliObj = obj;
				break;
			}
		}
		boolean check = true;
		List<AirportsModel> arrAirFit = new ArrayList<>();
		System.out.println("\nList Air Ports Fit size: ");
		for (AirportsModel obj : arrAirP) {
			if (obj.getMaxRotatedParking() > obj.getListHelicopterID().size()) {
				System.out.print(obj.getId());
				System.out.print(obj.getName());
				arrAirFit.add(obj);
				check = false;
			}
		}

		if (check) {
			System.out.println("Not Air Ports exits");
			return;
		}

		AirportsModel airPorts = null;
		do {
			String idAir = InputAirport.inIDAirport();

			for (AirportsModel obj : arrAirFit) {
				if (obj.getId().equalsIgnoreCase(idAir)) {
					airPorts = obj;
					List<String> ex = new ArrayList<>(airPorts.getListHelicopterID());
					ex.add(heliObj.getId());
					airPorts.setListHelicopterID(ex);
					return;
				}
			}

			System.err.println("Not exits ID, retype!!");
		} while (true);

	}

	
	public static String chooseListHeli(List<HelicoptersModel> arrHeli) {
		System.out.println("\nList fixed wing: ");
		for (HelicoptersModel obj : arrHeli) {
			System.out.print(obj.getId());
			System.out.println();
		}

		do {
			String id = InputHelicopter.inputIDHeli();

			for (HelicoptersModel obj : arrHeli) {
				if (obj.getId().equalsIgnoreCase(id)) {
					return id;
				}
			}

			System.err.println("Not exits ID, retype!!");
		} while (true);

	}
}
