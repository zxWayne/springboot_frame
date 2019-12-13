package cn.zx.editor.editor.web;

import cn.zx.editor.editor.domain.Editor;
import cn.zx.editor.editor.domain.Result;
import cn.zx.editor.editor.service.EditorService;
import cn.zx.editor.editor.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/editorWeb")
@Slf4j
public class EditorController {

    @Autowired
    private EditorService editorService;

    @PostMapping
    @ResponseBody
    public Result saveEditor(Editor editor) {
        log.info(editor.toString());
        editorService.save(editor);
        return ResultUtil.success();
    }

    /**
     * 预览
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/preview/{id}")
    public ModelAndView preview(@PathVariable(value = "id") int id, Map map) {

        Editor editor = editorService.findOne(id);

        map.put("editor", editor);
        return new ModelAndView("preview", map);
    }

    /**
     * 编辑
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") int id, Map map) {

        Editor editor = editorService.findOne(id);

        map.put("editor", editor);
        return new ModelAndView("index", map);
    }


    @GetMapping("/list/{page}")
    public ModelAndView list(@PathVariable(value = "page") int page, Map map) {

        Page<Editor> pageContent = editorService.findList(page);

        map.put("pageContent", pageContent);
        return new ModelAndView("mdList", map);
    }

}
