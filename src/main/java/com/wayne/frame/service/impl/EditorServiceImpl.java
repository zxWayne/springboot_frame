package com.wayne.frame.service.impl;

import com.wayne.frame.dao.MDEditorDao;
import com.wayne.frame.entity.MDEditorEntity;
import com.wayne.frame.service.MDEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class EditorServiceImpl implements MDEditorService {

    @Autowired
    private MDEditorDao mdEditorDao;


    @Override
    public MDEditorEntity save(Integer id,String title,String content) {
        MDEditorEntity entity;
        //获取原有的数据
        if(id!=null){
            Optional<MDEditorEntity> existOptional= mdEditorDao.findById(id);
            if(existOptional.isPresent()){
                entity=existOptional.get();
            }else{
                entity = new MDEditorEntity();
                entity.setId(id);
            }
        }else{
            entity = new MDEditorEntity();
        }
        entity.setTitle(title);
        entity.setContent(content);
        entity.setLastModifyTime(new Date());
        return mdEditorDao.save(entity);
    }

    @Override
    public MDEditorEntity findOne(int id) {
        Optional<MDEditorEntity> mdEditorOptional = mdEditorDao.findById(id);
        return mdEditorOptional.orElse(null);
    }

    @Override
    public MDEditorEntity findLatest() {
        return mdEditorDao.findTopByOrderByIdDesc();
    }

    @Override
    public Page<MDEditorEntity> findList(Integer page,Integer size) {
        Pageable pageAble = PageRequest.of(page-1,size);
        return mdEditorDao.findAll(pageAble);
    }
}
