package com.nagarro.flightmgmt.importer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.dao.FlightDao;
import com.nagarro.flightmgmt.model.Flight;
import com.nagarro.flightmgmt.model.FlightDetails;

@Service
public class Importer {

	@Autowired
	private FlightDao flightDao;

	public static List<String> filenames = new LinkedList<String>();

	@Transactional
	public void readCSV() {

		flightDao.truncate();

		String directory = Constant.DIRECTORY;

		File folder = new File(directory);

		listFilesForFolder(folder);

		String dataPath = Constant.DATA_PATH;
		for (int i = 0; i < filenames.size(); i++) {

			csvObject(dataPath + filenames.get(i), filenames.get(i).split("\\.")[0]);

		}

	}

	@Transactional
	public static void listFilesForFolder(File folder) {
		filenames.clear();
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {// ---if file found in the given path is a directory then
				listFilesForFolder(fileEntry);// ---go inside that directory to search for the files
			} else {
				if (fileEntry.getName().contains(".csv"))// ---if file name contains .csv
					filenames.add(fileEntry.getName());// ---then add it to the arraylist (filenames)
			}
		}
	}

	@Transactional
	public void csvObject(String csvFile, String flightName) {

		String line = "";

		Flight flightObj = new Flight();
		flightObj.setFlightName(flightName);

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			line = br.readLine();

			while ((line = br.readLine()) != null) {

				// use '|' as separator
				String[] flightDetails = line.split("\\|");

				FlightDetails flightDetailsObj = new FlightDetails();

				flightDetailsObj.setFlightNumber(flightDetails[0]);
				flightDetailsObj.setDepartureLocation(flightDetails[1]);
				flightDetailsObj.setArrivalLocation(flightDetails[2]);
				flightDetailsObj.setValidTill(flightDetails[3]);
				flightDetailsObj.setFlightTime(flightDetails[4]);
				flightDetailsObj.setFlightDuration(Double.valueOf(flightDetails[5]));
				flightDetailsObj.setFare(Double.valueOf(flightDetails[6]));
				flightDetailsObj.setSeatAvailable(flightDetails[7]);
				flightDetailsObj.setFlightClass(flightDetails[8]);
				flightDetailsObj.setFlight(flightObj);

				flightDao.addFlightDetails(flightDetailsObj);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
