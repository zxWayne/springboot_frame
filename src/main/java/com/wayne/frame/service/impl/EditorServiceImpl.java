package cn.zx.editor.editor.service.impl;

import cn.zx.editor.editor.domain.Editor;
import cn.zx.editor.editor.repository.EditorRepository;
import cn.zx.editor.editor.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Map;


@Service
public class EditorServiceImpl implements EditorService {

    @Autowired
    private EditorRepository repository;


    @Override
    public void save(Editor editor) {
        repository.save(editor);
    }

    @Override
    public Editor findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    public Editor findLatest() {
        return repository.findTopByOrderByIdDesc();
    }

    @Override
    public Page<Editor> findList(int page) {
        Pageable pageAble = new PageRequest(page-1,10);
        return repository.findAll(pageAble);
    }
}
