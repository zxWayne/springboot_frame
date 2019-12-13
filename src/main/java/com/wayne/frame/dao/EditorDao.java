package cn.zx.editor.editor.repository;

import cn.zx.editor.editor.domain.Editor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EditorRepository extends JpaRepository<Editor, Integer> {

    Editor findTopByOrderByIdDesc();
}
