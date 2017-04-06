package com.nagarro;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.nagarro.hibernate.HibernateConfig;
import com.nagarro.io.CSVFileReader;
import com.nagarro.io.UserInput;
import com.nagarro.io.UserOutput;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;
import com.nagarro.util.Constant;

public class FlightLauncher {

	
	/*
	*
	* Version info 			:	v2.0
	*
	* Author info			: 	Khushbu Patel
	*	
	* Creation date			:	23/02/2017
	*
	* Last updated By		:	Khushbu Patel
	*
	* Last updated Date		:	29/03/2017
	*
	* Description			: 	Assignment-3
	*/
	
	public static final Logger logger = Logger.getLogger(FlightLauncher.class.getName());
	

	public static void main(String[] args)  
	{
		
		Set<Flight> flightDataSet = new HashSet<>();
		CSVFileReader reader = new CSVFileReader();
		
		//get csv file folder and save all files in file-array
		File folder = new File(Constant.CSV_FILES_FOLDER_PATH);
		File[] listOfFiles = folder.listFiles();

		//read all files 
		for(int i=0;i<listOfFiles.length;i++)
		{
			flightDataSet.addAll(reader.readFiles(listOfFiles[i]));
		}
		
		//all data from set inserted into MySQL
		FlightService.setFlightData(flightDataSet);
		
		//returns expected flight list
		List<Flight> result = FlightService.getSearchList(new UserInput().acceptUserInput());
		
		//displays flight search result
		new UserOutput().displayFlightSearchResult(result);
		
		//close sessionfactory
		HibernateConfig.getSessionFactory().close();
	}
	
	
}
