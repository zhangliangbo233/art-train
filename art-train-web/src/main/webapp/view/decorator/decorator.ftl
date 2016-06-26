<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title><sitemesh:write property='title'/></title>
        <style type="text/css" title="currentStyle">
            @import "${basePath}/js/jquery-easyui-1.4/themes/gray/easyui.css";
            @import "${basePath}/js/jquery-easyui-1.4/themes/icon.css";
            @import "${basePath}/css/default.css"
        </style>
        <script type="text/javascript" src="${basePath}/js/jquery-easyui-1.4/jquery.min.js"></script>
        <script type="text/javascript" src="${basePath}/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${basePath}/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="${basePath}/js/shopmsg.js"></script>
        <sitemesh:write property='head'/>
    </head>
    <body>
        <sitemesh:write property='body'/>
        <div region="south" split="true"
             style="height: 30px;">
            <div class="footer">Copyright © 2014 zhanglb</div>
        </div>
    </body>
</html>
