/**
 * Created by chenlunwei on 2018/2/10.
 */
var addEnvironmentInfo = {

    URL: {
        Environment: function () {
            return "/resources/json/environment.json";
        }
    },

    init: function () {
        addEnvironmentInfo.addSection();
        environmentFormValidate.initValidator();
    },

    addSection: function () {
        $('#environmentTitle').html([
            '<h1 name="itemTitle" id="itemTitle">',
            '环境信息',
            '<small>',
            '<span class="iconfont icon-shuangjiantouyou"></span>',
            '环境信息设置',
            '</small>',
            '<div class="btn-group">',
            '</div>',
            '</h1>'].join(''));
        $.ajaxSettings.async = false;
        $.getJSON(addEnvironmentInfo.URL.Environment(), function (data) {
            addEnvironmentInfo.writePageBody(data);
        });
        $.ajaxSettings.async = true;
    },

    writePageBody: function (JsonParamData) {
        var arr = new Array();
        arr.push('<div class="row">');
        arr.push(['<div class="col-sm-6">' +
        '<div class="panel panel-info">' +
        '<div class="panel-heading"><h3 class="panel-title">环境信息</h3></div>' +
        '<div class="panel-body">' +
        '<form id="environmentForm" class="form-horizontal" role="form">'].join(''));
        var paramList = JsonParamData.params;
        for (var j = 0; j < paramList.length; j++) {
            if (paramList[j].name == 'batteryRoomNumber') {
                if ($('#application').val() == 1 || $('#application').val() == 3) {
                    arr.push([
                        '<div class="form-group">' +
                        '<label for="' + paramList[j].name + '" class="col-sm-5 control-label">' + paramList[j].value + '<span class="text-danger">*</span>:</label>' +
                        '<div class="col-sm-5">' +
                        '<input name="' + paramList[j].name + '" class="form-control" type="text" id="' + paramList[j].name + '"+/>' +
                        '</div></div>'].join(''));
                }
            } else {
                arr.push([
                    '<div class="form-group">' +
                    '<label for="' + paramList[j].name + '" class="col-sm-5 control-label">' + paramList[j].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<select id="' + paramList[j].name + '" name="' + paramList[j].name + '" class="selectpicker form-control" title="请选择">' +
                    '<option data-icon="iconfont icon-yes icon-fw" value="true">是</option>' +
                    '<option data-icon="iconfont icon-no icon-fw" value="false">否</option>' +
                    '</select>' +
                    '</div></div>'].join(''));
            }
        }
        arr.push(['</form></div></div></div></div>'].join(''));
        $('#environmentParam').html(arr.join(''));
        $($.find("#environmentParam")).find("select").selectpicker('refresh');
        //当电池信息页初始化好之后，修改battInfo的值为1
        $('#environInfo').val(1);
    },

}