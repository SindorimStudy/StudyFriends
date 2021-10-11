package com.study.friends.controller.study;

import com.study.friends.domain.Study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyCreateRequestDto {
	
	private Long std_seq;
	private String std_title;
	private String std_content;
	
	public Study toEntity(){
        return Study.builder()
                .std_seq(std_seq)
                .std_title(std_title)
                .std_content(std_content)
                .build();
    }
}
