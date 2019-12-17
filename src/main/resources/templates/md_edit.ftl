<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>${editor.title!'编辑'}</title>
    <link rel="stylesheet" href="/editor/css/style.css"/>
    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <link rel="stylesheet" type="text/css" href="/bootstrap/bootstrap.min.css"/>
    <link rel="icon" type="image/x-icon" href="/images/favicon.icon" />
</head>
<body>
<div class="panel panel-default">
    <div class="input-group">
        <span class="input-group-addon">标题：</span>
        <input type="text" id="title" value="${editor.title!''}" class="form-control" placeholder="请输入文章标题">
    </div>
</div>
<div id="layout">
    <input hidden="hidden" id="id" value="${editor.id!''}" />
    <div id="markdown-edit">


                <textarea style="display:none;" id="content" name="content">
                    <#if editor.content=="">
[TOC]

#### Disabled options

- TeX (Based on KaTeX);
- Emoji;
- Task lists;
- HTML tags decode;
- Flowchart and Sequence Diagram;

#### Editor.md directory

    editor.md/
            lib/
            css/
            scss/
            tests/
            fonts/
            images/
            plugins/
            examples/
            languages/
            editormd.js
            ...

```html
&lt;!-- English --&gt;
&lt;script src="../dist/js/languages/en.js"&gt;&lt;/script&gt;

&lt;!-- 繁體中文 --&gt;
&lt;script src="../dist/js/languages/zh-tw.js"&gt;&lt;/script&gt;
```
<#else>${editor.content!''}</#if></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea id="text" class="editormd-html-textarea" name="text"></textarea>
    </div>
</div>
<div>
    <button class="btn btn-primary" onclick="saveMarkdown()">保存</button>
</div>
<script src="/jquery.min.js"></script>
<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>
<script src="/editor/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd("markdown-edit", {
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "${re.contextPath}/editor/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/file",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true
            // previewTheme : "dark"
        });
    });

    function saveMarkdown() {
        // console.log($("#text").text());
        console.log($("#title").text());
        $.ajax({
            url: "/md/save",
            type: "post",
            async: true,
            data: {
                "id": $("#id").val(),
                "title": $("#title").val(),
                "content": $("#content").text()
                //"textContent": $("#textContent").text()
            },
            dataType: "json",
            success: function (data) {
                alert("保存成功");
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("保存失败");
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus); // paser error;
            }
        });
    }
</script>
</body>
</html>