layui.use(['element', 'table', 'form', 'jquery', 'laydate'], function () {
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;

    laydate.render({
        elem: '#startTime',
        type: "datetime"
    });

    laydate.render({
        elem: '#endTime',
        type: "datetime"
    });

    table.render({
        elem: '#tableId',
        url: '/admin/user/list',
        method: 'post',
        limit: 10,
        page: true,
        size: 'sm',
        cols: [[
            {type: 'checkbox'},
            {field:'id', title:'ID', width:80, sort: true},
            {field:'username', title:'用户名', width:100},
            {field:'phone', title:'手机号码', width:120},
            {field:'email', title:'邮箱', width:150},
            {field:'nickname', title:'昵称', width:100},
            {field:'avatar', title: '头像', width:100},
            {title:'操作', width:200, templet: '#operationTpl',  align:'center'}
        ]],
        done: function(res, curr, count){
            $("#countNum").text(count);
        }
    });

    form.on('submit(search)', function () {
        layer.msg('正在查询，请稍后...');
        return false;
    });

    table.on('tool(tableFilter)', function(obj){
        var data = obj.data;
        var layEvent = obj.event;
        if(layEvent === 'edit'){
            layer.open({
                title: '编辑用户',
                type: 2,
                shade: false,
                maxmin: true,
                shade: 0.5,
                area: ['90%', '90%'],
                content: 'user-edit.html',
                zIndex: layer.zIndex,
                end: function () {
                    // $(".layui-laypage-btn")[0].click();
                }
            });
        }else if(layEvent === 'del'){
            layer.confirm("确定要删除吗？", {skin: 'layui-layer-lan', icon: 2, title:'提示', anim: 6}, function () {
                layer.msg("操作成功！", {icon: 1, time: 1000});
            });
        }
    });

    $("#batchEnabled").click(function(){
        layer.confirm("确定要批量启用吗？", {skin: 'layui-layer-lan', icon: 3, title:'提示', anim: 1}, function () {
            layer.msg("操作成功！", {icon: 1, time: 1000});
        });
    })

    $("#batchDisabled").click(function(){
        layer.confirm("确定要批量停用吗？", {skin: 'layui-layer-lan', icon: 3, title:'提示', anim: 2}, function () {
            layer.msg("操作成功！", {icon: 1, time: 1000});
        });
    })

    $("#batchDel").click(function(){
        layer.confirm("确定要批量删除吗？", {skin: 'layui-layer-lan', icon: 2, title:'提示', anim: 6}, function () {
            layer.msg("操作成功！", {icon: 1, time: 1000});
        });
    })

    $("#addUser").click(function(){
        layer.open({
            title: '添加用户',
            type: 2,
            shade: false,
            maxmin: true,
            shade: 0.5,
            anim: 4,
            area: ['90%', '90%'],
            content: 'user-edit.html',
            zIndex: layer.zIndex,
            end: function () {
                // $(".layui-laypage-btn")[0].click();
            }
        });
    })
})