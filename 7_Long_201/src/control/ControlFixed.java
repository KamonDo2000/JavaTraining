package control;

import java.util.ArrayList;
import java.util.List;

import model.AirportsModel;
import model.FixedwingsModel;
import view.InputAirport;
import view.InputFixed;

public class ControlFixed {

	public static void addFixWingToAir(String id, List<FixedwingsModel> arrFixed, List<AirportsModel> arrAirP) {
		FixedwingsModel fixWingObj = null;
		for (FixedwingsModel obj : arrFixed) {
			if (id.equalsIgnoreCase(obj.getId())) {
				fixWingObj = obj;
				break;
			}
		}
		boolean check = true;
		List<AirportsModel> arrAirFit = new ArrayList<>();
		System.out.println("\nList Air Ports Fit size: ");
		for (AirportsModel obj : arrAirP) {
			if (fixWingObj.getMinRunwaySize() < obj.getRunwaySize()
					&& obj.getMaxFixedParking() > obj.getListFixedID().size()) {
				System.out.print(obj.getId());
				System.out.print(obj.getName());
				System.out.print(obj.getRunwaySize());
				arrAirFit.add(obj);
				check = false;
			}
		}

		if (check) {
			System.out.println("Not Air Ports Fit size");
			return;
		}

		AirportsModel airPorts = null;
		do {
			String idAir = InputAirport.inIDAirport();

			for (AirportsModel obj : arrAirFit) {
				if (obj.getId().equalsIgnoreCase(idAir)) {
					airPorts = obj;
					List<String> ex = new ArrayList<>(airPorts.getListFixedID());
					ex.add(fixWingObj.getId());
					airPorts.setListFixedID(ex);
					return;
				}
			}

			System.err.println("Not exits ID, retype!!");
		} while (true);

	}

	public static String chooseListFixWing(List<FixedwingsModel> arrFixed) {
		System.out.println("\nList fixed wing: ");
		for (FixedwingsModel obj : arrFixed) {
			System.out.print(obj.getId());
			System.out.print(obj.getType());
			System.out.print(obj.getMinRunwaySize());
			System.out.println();
		}

		do {
			String id = InputFixed.inputIDFixWing();

			for (FixedwingsModel obj : arrFixed) {
				if (obj.getId().equalsIgnoreCase(id)) {
					return id;
				}
			}

			System.err.println("Not exits ID, retype!!");
		} while (true);

	}

}
