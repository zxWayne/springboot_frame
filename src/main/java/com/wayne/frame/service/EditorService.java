package cn.zx.editor.editor.service;

import cn.zx.editor.editor.domain.Editor;
import org.springframework.data.domain.Page;


public interface EditorService {

    void save(Editor editor);

    Editor findOne(int id);

    Editor findLatest();

    Page<Editor> findList(int page);
}
