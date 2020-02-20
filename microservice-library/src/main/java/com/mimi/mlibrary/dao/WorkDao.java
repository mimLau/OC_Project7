package com.mimi.mlibrary.dao;

import com.mimi.mlibrary.model.works.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDao extends JpaRepository<Work, Integer> {


}
