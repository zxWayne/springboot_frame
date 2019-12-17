package com.wayne.frame.dao;

import com.wayne.frame.entity.MDEditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MDEditorDao extends JpaRepository<MDEditorEntity, Integer> {

    MDEditorEntity findTopByOrderByIdDesc();
}
