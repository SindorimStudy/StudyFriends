package com.study.friends.controller.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.friends.domain.Study;
import com.study.friends.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class StudyController {
	
	private final StudyService studyService;
	
	@GetMapping("/{std_seq}")
	public ResponseEntity<Study> searchStudy(@RequestParam(required = false) Long std_seq) {
		Study study = studyService.searchStudy(std_seq);
		
		if(study!=null) {
			return ResponseEntity.ok(studyService.searchStudy(std_seq));
		}
		
		else 
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Study> createStudy(@RequestBody Study study){
		return ResponseEntity.ok(studyService.createStudy(study));
	}
}
