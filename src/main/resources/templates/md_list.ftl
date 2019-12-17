<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>文档列表</title>
    <link rel="stylesheet" href="/editor/css/style.css"/>
    <link rel="stylesheet" href="/editor/css/editormd.css"/>
    <link rel="stylesheet" type="text/css" href="/bootstrap/bootstrap.min.css"/>
    <link rel="icon" type="image/x-icon" href="/images/favicon.icon" />
</head>
<body>

<div id="layout">
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>标题</th>
            <th>上次修改时间</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <#if pageContent??>
            <#list pageContent.content as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.lastModifyTime?string("yyyy-MM-dd HH:mm:ss")!""}</td>
                    <td>${item.createTime?string("yyyy-MM-dd HH:mm:ss")!""}</td>
                    <td><a href="/md/edit/${item.id}"><button class="btn btn-primary" >编辑</button></a> <a href="/md/delete/${item.id}"><button class="btn btn-primary" >删除</button></a></td>
                </tr>
            </#list>

        </#if>
    </table>


<script src="/jquery.min.js"></script>
<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>
<script src="/editor/editormd.min.js"></script>
<script type="text/javascript">

</script>

</body>
</html>