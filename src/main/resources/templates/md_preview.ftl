<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>${editor.title!'markdown'}</title>
    <link rel="stylesheet" href="/editor/css/editormd.preview.min.css" />
    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <link rel="icon" type="image/x-icon" href="/images/favicon.icon" />
</head>
<body>
<div id="layout"  class="editor">
    <div id="content" >
        <textarea>${editor.content!''}</textarea>
    </div>
</div>
<!-- 因为我们使用了dark主题，所以在容器div上加上dark的主题类，实现我们自定义的代码样式 -->
<script src="/jquery.min.js"></script>
<script src="/editor/lib/marked.min.js"></script>
<script src="/editor/lib/prettify.min.js"></script>
<script src="/editor/editormd.min.js"></script>
<script type="text/javascript">
    editormd.markdownToHTML("content");
</script>
</body>
</html>