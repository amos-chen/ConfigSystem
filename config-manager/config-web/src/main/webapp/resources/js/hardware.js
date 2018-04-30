var hardware = {
    TEMP: {
        JSTREE: ''
    },

    URL: {},
    initTree: function () {

        //这个是关键，如果不清空实例，jstree不会重新生成
        $('#jstree').data('jstree', false).empty();

        /*异步加载树
         $("#jstree").jstree({
         // 'plugins': ["checkbox"], //出现选择框
         // 'checkbox': {cascade: "", three_state: false}, //不级联
         'core': {
         'data': {
         'url': ,
         'data': function (node) {
         return {'id': node.id};
         }
         },
         'check_callback':true,
         },
         'types':{
         'root':{'icon':'fa fa-folder fw'},
         'file':{'icon':'fa fa-file fw'}
         }
         });*/
        $('#jstree').on("loaded.jstree", function (e, data) {
            $('#jstree').jstree('open_all');
            var inst = data.instance;
            var obj = inst.get_node(e.target.firstChild.firstChild.lastChild.firstChild);
            inst.select_node(obj);
        });
        $("#jstree").jstree({
            // 'plugins': ["checkbox"], //出现选择框
            // 'checkbox': {cascade: "", three_state: false}, //不级联
            'core': {
                'data': hardware.getJsonTree(),
                'check_callback': true
            },
            'types': {
                'root': {'icon': 'fa fa-folder fw'},
                'file': {'icon': 'fa fa-file fw'}
            },
            'conditionalselect': function (node, event) {
                //event代表的是node绑定的所有事件
                // console.log(event);
                if (node.parent !== '#') {
                    //node属性及json数据属性
                    return true;
                }
            },
            'plugins': ['conditionalselect',"search"],
            'search':{
                'show_only_matches':true
            }
        });
        var to = false;
        $('#tree-search').keyup(function () {
            if(to) {
                clearTimeout(to);
            }

            to = setTimeout(function () {
                $('#jstree').jstree().search($('#tree-search').val());
                downloadTable.reloadTableWhenClick();
            }, 250);
        });

    },

    getJsonTree: function () {
        var data = null;
        $.ajax({
            method: 'get',
            url: "/config/hardware/category",
            async: false,
            success: function (result) {
                data = result;
                hardware.TEMP.JSTREE = data;
            }
        });
        return data;
    }
}