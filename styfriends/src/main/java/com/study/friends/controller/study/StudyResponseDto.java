package com.study.friends.controller.study;

import org.springframework.beans.BeanUtils;

import com.study.friends.domain.Study;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudyResponseDto {
	private long std_seq;
	private String std_title;
	private String std_content;
	
	public StudyResponseDto(Study study) {
		BeanUtils.copyProperties(study, this);
	}
}
