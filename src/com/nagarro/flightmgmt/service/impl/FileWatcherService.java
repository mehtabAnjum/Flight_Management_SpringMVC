package com.nagarro.flightmgmt.service.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.nagarro.flightmgmt.constants.Constant;
import com.nagarro.flightmgmt.importer.Importer;
import com.nagarro.flightmgmt.service.FlightService;

@Controller
public class FileWatcherService {

	private static final Logger LOGGER = Logger.getLogger(FileWatcherService.class);
	
	public FileWatcherService() {
	}

	static boolean seedvalue = true;

	@Autowired
	FlightService flightService;

	@Autowired
	Importer importer;

	@SuppressWarnings("rawtypes")
	@Scheduled(fixedRate = 5000)
	public void schedule() {

		if (FileWatcherService.seedvalue) {
			flightService.deleteAll();
			importer.readCSV();

			FileWatcherService.seedvalue = false;
		}

		Path myDir = Paths.get(Constant.DIRECTORY);
		try {
			WatchService watcher = myDir.getFileSystem().newWatchService();
			myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);

			WatchKey watckKey = watcher.take();

			List<WatchEvent<?>> events = watckKey.pollEvents();
			for (WatchEvent event : events) {
				if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
					flightService.deleteAll();
					importer.readCSV();
				}
				if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
					flightService.deleteAll();
					importer.readCSV();
				}
				if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
					flightService.deleteAll();
					importer.readCSV();
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error: " + e.toString());
		}

	}

}
