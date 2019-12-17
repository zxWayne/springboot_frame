package com.wayne.frame.service;

import com.wayne.frame.entity.MDEditorEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface MDEditorService {

    MDEditorEntity save(Integer id,String title,String content);

    MDEditorEntity findOne(int id);

    MDEditorEntity findLatest();

    Page<MDEditorEntity> findList(Integer page,Integer size);
}
