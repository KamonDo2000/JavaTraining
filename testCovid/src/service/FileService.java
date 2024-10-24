package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Adult;
import model.Children;
import model.Person;
import model.Pregnant;

public class FileService {

	public static List<Person> readFile() {
		List<Person> persons = new ArrayList<>();
		BufferedWriter bw = null;

		List<String> listData = readAllLine();

		try {
//===================== wrirte error =============================
			int linessn = 0;

			File fileErr = new File("error.txt");
			if (!fileErr.exists()) {
				fileErr.createNewFile();
			}
			FileWriter fw = new FileWriter(fileErr);
			bw = new BufferedWriter(fw);

//======================================================
			for (String line : listData) {
				String[] txt = line.split(",");

				// validate

				if (txt[0].equals("1")) {
					Adult adult = new Adult();
					adult.setType(Integer.parseInt(txt[0]));
					adult.setPassengerID(txt[1]);
					adult.setName(txt[2]);
					adult.setBirthDate(txt[3]);
					adult.setAddress(txt[4]);
					adult.setPhone(txt[5]);
					adult.setTestDate(txt[6]);
					adult.setFlightDate(txt[7]);
					adult.setJob(txt[8]);
					persons.add(adult);
				}
				if (txt[0].equals("2")) {
					Children child = new Children();
					child.setType(Integer.parseInt(txt[0]));
					child.setPassengerID(txt[1]);
					child.setName(txt[2]);
					child.setBirthDate(txt[3]);
					child.setAddress(txt[4]);
					child.setPhone(txt[5]);
					child.setTestDate(txt[6]);
					child.setFlightDate(txt[7]);
					child.setSchool(txt[9]);
					child.setGrade(txt[10]);
					persons.add(child);
				}
				if (txt[0].equals("3")) {
					Pregnant preg = new Pregnant();
					preg.setType(Integer.parseInt(txt[0]));
					preg.setPassengerID(txt[1]);
					preg.setName(txt[2]);
					preg.setBirthDate(txt[3]);
					preg.setAddress(txt[4]);
					preg.setPhone(txt[5]);
					preg.setTestDate(txt[6]);
					preg.setFlightDate(txt[7]);
					preg.setGestationalAge(txt[11]);
					preg.setPretermBirth(txt[12]);
					persons.add(preg);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return persons;
	}

	private static List<String> readAllLine() {
//		Reading all file
		List<String> listLine = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Passenger.csv"));
			do {
				String line = "";
				line = br.readLine();
				listLine.add(line);
			} while (br.ready());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listLine;
	}

}
