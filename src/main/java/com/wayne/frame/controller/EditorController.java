package com.wayne.frame.controller;

import com.wayne.frame.entity.MDEditorEntity;
import com.wayne.frame.service.MDEditorService;
import com.wayne.frame.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/md")
@Slf4j
public class EditorController {

    @Autowired
    private MDEditorService editorService;

    /**
     * 预览
     *
     * @param id 文章ID
     */
    @GetMapping("/preview/{id}")
    public ModelAndView preview(@PathVariable(value = "id") int id) {

        MDEditorEntity editor = editorService.findOne(id);

        Map<String,Object> map = new HashMap<>(1);
        map.put("editor", editor);
        return new ModelAndView("md_preview", map);
    }

    /**
     * 编辑
     *
     * @param id 文章ID
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") int id) {

        MDEditorEntity editor = editorService.findOne(id);
        Map<String,Object> map = new HashMap<>(1);
        map.put("editor", editor);
        return new ModelAndView("md_edit", map);
    }

    @GetMapping("/add")
    public ModelAndView add() {


        Map<String,Object> map = new HashMap<>(1);
        MDEditorEntity editor=new MDEditorEntity();
        editor.setContent("");
        map.put("editor", editor);
        return new ModelAndView("md_edit", map);
    }

    /**
     * 保存md
     * @param id 文章ID
     * @param title 文章标题
     * @param content 文章内容
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestParam("id")Integer id,
                       @RequestParam("title")String title,
                       @RequestParam("content")String content){
        editorService.save(id,title,content);
        return Result.ok();
    }


    @GetMapping("/list")
    public ModelAndView list(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<MDEditorEntity> pageContent = editorService.findList(page, size);
        Map<String, Object> map = new HashMap<>(1);
        map.put("pageContent", pageContent);
        return new ModelAndView("md_list", map);
    }

}
