package control;

import model.AirportsModel;
import model.FixedwingsModel;
import model.HelicoptersModel;
import view.InputAirport;
import view.InputFixed;
import view.InputHelicopter;
import view.InputPlan;

public class CreateObject {

	public static AirportsModel createAirport() {
		AirportsModel air = new AirportsModel();

		air.setId(InputAirport.inIDAirport());
		air.setName(InputAirport.inName());
		air.setRunwaySize(InputAirport.inRunwaySize());
		air.setMaxFixedParking(InputAirport.inMaxFixedParking());
		air.setMaxRotatedParking(InputAirport.inmaxRotatedParking());

		return air;
	}

	public static FixedwingsModel createFixedWing() {
		FixedwingsModel fix = new FixedwingsModel();

		fix.setId(InputFixed.inputIDFixWing());
		fix.setType(InputFixed.inputtype());
		fix.setMinRunwaySize(InputFixed.inputRunwaySize());

		fix.setModel(InputPlan.inputModel());
		fix.setSpeed(InputPlan.inputSpeed());
		float emp = InputPlan.inputEmptyWeight();
		fix.setEmptyWeight(emp);
		fix.setMaxWeight(InputPlan.inputMaxWeight(emp));

		return fix;
	}

	public static HelicoptersModel createHelicopters() {
		HelicoptersModel heli = new HelicoptersModel();

		heli.setId(InputHelicopter.inputIDHeli());
		heli.setRange(InputHelicopter.inRange());

		heli.setModel(InputPlan.inputModel());
		heli.setSpeed(InputPlan.inputSpeed());
		float emp = InputPlan.inputEmptyWeight();
		heli.setEmptyWeight(emp);
		heli.setMaxWeight(InputPlan.inputMaxWeight(emp));

		return heli;
	}

}
