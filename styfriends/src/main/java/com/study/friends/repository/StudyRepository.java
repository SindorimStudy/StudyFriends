package com.study.friends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.friends.domain.Study;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long>{

}
