package com.study.friends.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.friends.controller.study.StudyCreateRequestDto;
import com.study.friends.domain.Study;
import com.study.friends.repository.StudyRepository;

@Service
@Transactional(readOnly = true)
public class StudyService {
	
	private final StudyRepository studyRepository;
	
	public StudyService(StudyRepository studyRepository) {
		this.studyRepository = studyRepository;
	}
	
	public Study searchStudy(Long std_seq) {
		Study study = studyRepository.findById(std_seq).orElse(null);
		return study;
	}
	
	@Transactional
	public Study createStudy(Study study) {
		return studyRepository.save(study);
	}
	
	public Study updateStudy(Study study) {
		return studyRepository.save(study);
	}
	
}	
