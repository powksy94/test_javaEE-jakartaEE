<#macro page title>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>${title}</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 40px auto; }
        h1   { color: #333; }
        .done { text-decoration: line-through; color: #999; }
        .task-item { display: flex; justify-content: space-between; align-items: center; padding: 6px 0; border-bottom: 1px solid #eee; }
        form input[type=text] { padding: 6px; width: 70%; }
        button { padding: 6px 12px; background: #4CAF50; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <h1>${title}</h1>
    <#nested>
</body>
</html>
</#macro>