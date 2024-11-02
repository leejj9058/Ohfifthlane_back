package com.team03.Ohfifthlane_back.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ResidentReportController {

	@PostMapping("/report")
	public RequestEntity<?> createReport(@RequestBody ReportVO rvo) {
		
		return (RequestEntity<?>) ResponseEntity.ok();
	}
	
}
