/**
 * Created by chenlunwei on 2018/2/10.
 */
var addPowerInfo = {
    Constant: {
        DATACENTER: 1,
        TELECOME: 2,
        POWERUTILITY: 3,
        POWER_NUM: 1,
        POWER_TEMPLATE: ''
    },

    URL: {
        Datacenter_Power: function () {
            return "/resources/json/power_ups.json";
        },
        Telecom_Power: function () {
            return "/resources/json/power_telecom.json";
        },
        PowerUtility_Power: function () {
            return "/resources/json/power_powerutility.json";
        }
    },

    init: function (data) {
        addPowerInfo.addSection(data);
        addPowerInfo.delete_Group();
        addPowerInfo.add_Group();
        powerFormValidate.initValidator();
    },

    addSection: function (data) {
        var powerTitle = "";
        if (data.application == addPowerInfo.Constant.DATACENTER) {
            powerTitle = "UPS信息";
            $.ajaxSettings.async = false;
            $.getJSON(addPowerInfo.URL.Datacenter_Power(), function (data) {
                addPowerInfo.writeUPS_PageBody(data);
                $("#powerInfo").val(1);
            });
            $.ajaxSettings.async = true;
        } else if (data.application == addPowerInfo.Constant.TELECOME) {
            powerTitle = "开关电源信息";
            $.ajaxSettings.async = false;
            $.getJSON(addPowerInfo.URL.Telecom_Power(), function (data) {
                addPowerInfo.writeTelecom_PageBody(data);
                $("#powerInfo").val(1);
            });
            $.ajaxSettings.async = true;
        } else if (data.application == addPowerInfo.Constant.POWERUTILITY) {
            powerTitle = "直流屏信息";
            $.ajaxSettings.async = false;
            $.getJSON(addPowerInfo.URL.PowerUtility_Power(), function (data) {
                addPowerInfo.writePowerutility_PageBody(data);
                $("#powerInfo").val(1);
            });
            $.ajaxSettings.async = true;
        }
        powerFormValidate.initValidator();
        $('#powerTitle').html([
            '<h1 name="itemTitle" id="itemTitle">',
            powerTitle,
            '<small>',
            '<span class="iconfont icon-shuangjiantouyou"></span>',
            '电源信息设置',
            '</small>',
            '<div class="btn-group">',
            '<a class="btn btn-success" id="add-group"><span class="iconfont icon-jia icon-fw"></span>新增设备</a>',
            // '<a class="btn btn-success" id="changeEditStatus"><span class="fa fa-edit fa-fw"></span>修改</a>',
            '</div>',
            '</h1>'].join(''));

    },


    writeTelecom_PageBody: function (JsonParamData) {
        addPowerInfo.Constant.POWER_NUM = 1;
        var power_num = addPowerInfo.Constant.POWER_NUM;
        var arr = new Array();
        arr.push('<div class="row">');
        arr.push(['<div class="col-sm-6">' +
        '<div class="panel panel-info">' +
        '<div class="panel-heading">' +
        '<h3 class="panel-title">' + JsonParamData.group + power_num +
        '<div style="display: inline;float: right;">' +
        '<a href="javascript:void(0)" id="delete_Group" title="删除组"><span class="iconfont icon-shanchu icon-fw"></span></a>' +
        '</div>' +
        '</h3>' +
        '</div>' +
        '<div class="panel-body">' +
        '<form id="powerForm" class="form-horizontal" role="form">'].join(''));
        var paramList = JsonParamData.params;
        for (var i = 0; i < paramList.length; i++) {
            if (!(paramList[i].name == "needSingleMonitor" || paramList[i].name == "needEnergySaving"
                || paramList[i].name == "needSmartMeter" || paramList[i].name == "needLeakageSensor")) {
                arr.push([
                    '<div class="form-group">' +
                    '<label for="' + paramList[i].name + '" class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<input name="' + paramList[i].name + '" class="form-control" type="text" id="' + paramList[i].name + '"+/>' +
                    '</div></div>'].join(''));
            } else {
                arr.push([
                    '<div class="form-group">' +
                    '<label class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="true"> 是' +
                    '</label>' +
                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="false"> 否' +
                    '</label>' +
                    '</div>' +
                    '</div>'].join(''));
            }
        }
        arr.push(['</form></div></div></div></div>'].join(''));
        $('#powerParam').html(arr.join(''));
        // $('.selectpicker').selectpicker('refresh');
        var powerTemplate = $('#powerParam').find('div.col-sm-6').html();
        addPowerInfo.Constant.POWER_TEMPLATE = powerTemplate;
    },

    writePowerutility_PageBody: function (JsonParamData) {
        addPowerInfo.Constant.POWER_NUM = 1;
        var power_num = addPowerInfo.Constant.POWER_NUM;
        var arr = new Array();
        arr.push('<div class="row">');
        arr.push(['<div class="col-sm-6">' +
        '<div class="panel panel-info">' +
        '<div class="panel-heading">' +
        '<h3 class="panel-title">' + JsonParamData.group + power_num +
        '<div style="display: inline;float: right;">' +
        '<a href="javascript:void(0)" id="delete_Group" title="删除组"><span class="iconfont icon-shanchu icon-fw"></span></a>' +
        '</div>' +
        '</h3>' +
        '</div>' +
        '<div class="panel-body">' +
        '<form id="powerForm" class="form-horizontal" role="form">'].join(''));
        var paramList = JsonParamData.params;
        for (var i = 0; i < paramList.length; i++) {
            if (!(paramList[i].name == "needLeakageSensor")) {
                arr.push([
                    '<div class="form-group">' +
                    '<label for="' + paramList[i].name + '" class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<input name="' + paramList[i].name + '" class="form-control" type="text" id="' + paramList[i].name + '"+/>' +
                    '</div></div>'].join(''));
            } else {
                arr.push([
                    '<div class="form-group">' +
                    '<label class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="true"> 是' +
                    '</label>' +
                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="false"> 否' +
                    '</label>' +
                    '</div>' +
                    '</div>'].join(''));
            }
        }
        arr.push(['</form></div></div></div></div>'].join(''));
        $('#powerParam').html(arr.join(''));
        // $('.selectpicker').selectpicker('refresh');
        var powerTemplate = $('#powerParam').find('div.col-sm-6').html();
        addPowerInfo.Constant.POWER_TEMPLATE = powerTemplate;
    },

    writeUPS_PageBody: function (JsonParamData) {
        addPowerInfo.Constant.POWER_NUM = 1;
        var power_num = addPowerInfo.Constant.POWER_NUM;
        var arr = new Array();
        arr.push('<div class="row">');
        arr.push(['<div class="col-sm-6">' +
        '<div class="panel panel-info">' +
        '<div class="panel-heading">' +
        '<h3 class="panel-title">' + JsonParamData.group + power_num +
        '<div style="display: inline;float: right;">' +
        '<a href="javascript:void(0)" id="delete_Group" title="删除组"><span class="iconfont icon-shanchu icon-fw"></span></a>' +
        '</div>' +
        '</h3>' +
        '</div>' +
        '<div class="panel-body">' +
        '<form id="powerForm" class="form-horizontal" role="form">'].join(''));
        var paramList = JsonParamData.params;
        for (var i = 0; i < paramList.length; i++) {
            if (!(paramList[i].name == "isThreeWire" || paramList[i].name == "needConvergence"
                || paramList[i].name == "supportDryNode")) {
                arr.push([
                    '<div class="form-group">' +
                    '<label for="' + paramList[i].name + '" class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +
                    '<input name="' + paramList[i].name + '" class="form-control" type="text" id="' + paramList[i].name + '"+/>' +
                    '</div></div>'].join(''));
            } else {
                if (paramList[i].name == "isThreeWire") {
                    var picHref = "/resources/images/ThreeWire.png";
                } else if (paramList[i].name == "needConvergence") {
                    var picHref = "/resources/images/Convergence.png";
                } else if (paramList[i].name == "supportDryNode") {
                    var picHref = "/resources/images/DryNode.png";
                }
                arr.push([
                    '<div class="form-group">' +
                    '<label class="col-sm-5 control-label">' + paramList[i].value + '<span class="text-danger">*</span>:</label>' +
                    '<div class="col-sm-5">' +

                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="true"> 是' +
                    '</label>' +
                    '<label class="radio-inline">' +
                    '<input type="radio" name="' + paramList[i].name + '" id="' + paramList[i].name + '" value="false"> 否' +
                    '</label>' +
                    '<a class="tips cboxElement" href="' + picHref + '"><i class="glyphicon glyphicon-picture" style="padding-left: 10px;padding-top: 8px"></i></a>' +

                    '</div>' +
                    '</div>'].join(''));
            }
        }
        arr.push(['</form></div></div></div></div>'].join(''));
        $('#powerParam').html(arr.join(''));
        // $('.selectpicsker').selectpicker('refresh');
        var powerTemplate = $('#powerParam').find('div.col-sm-6').html();
        addPowerInfo.Constant.POWER_TEMPLATE = powerTemplate;
        $('a.tips').colorbox({rel: 'gal', width: "50%", height: "50%"});
    },

    //新增UPS组功能
    add_Group: function () {
        $('#add-group').on('click', function () {
            var parent = $(this).parent().parent().parent().parent().parent();
            var paramGroup = $(parent).find('div#powerParam');
            var Rows = $(paramGroup).find('div.row');
            var lastRow = $(Rows).last();
            var Lines = $(lastRow).find("div.col-sm-6");
            var newHTML = '<div class="col-sm-6">' + addPowerInfo.Constant.POWER_TEMPLATE + '</div>';
            addPowerInfo.Constant.POWER_NUM = addPowerInfo.Constant.POWER_NUM + 1;
            if ($("#application").val() == addPowerInfo.Constant.DATACENTER) {
                newHTML = newHTML.replace("ups1", "ups" + addPowerInfo.Constant.POWER_NUM);
            } else if ($("#application").val() == addPowerInfo.Constant.TELECOME) {
                newHTML = newHTML.replace("开关电源1", "开关电源" + addPowerInfo.Constant.POWER_NUM);
            } else if ($("#application").val() == addPowerInfo.Constant.POWERUTILITY) {
                newHTML = newHTML.replace("直流屏1", "直流屏" + addPowerInfo.Constant.POWER_NUM);
            }
            if (Lines.length === 2) {
                newHTML = '<div class="row">' + newHTML + '</div>';
                $(paramGroup).append(newHTML);
            } else {
                $(lastRow).append(newHTML);
            }

            //如果电池信息表里已有与电源相应的信息，增加电源信息时增加对应的电池信息
            if ($("#battInfo").val() == 1) {
                var batteryParam = $(parent).find('div#batteryParam');
                var lastBattRows = $(batteryParam).find('div.row').last();
                addBattInfo.addBatt_Group(addPowerInfo.Constant.POWER_NUM, batteryParam, lastBattRows);
            }


            $('a#delete_Group').unbind();
            $('a.tips').colorbox({rel: 'gal', width: "50%", height: "50%"});
            powerFormValidate.initValidator();
            addPowerInfo.delete_Group();
        })

    },

    //删除UPS组功能，删除UPS的同时，删除对应的电池信息
    delete_Group: function () {
        $(document).ready(function () {
            $('a#delete_Group').on('click', function () {
                var GroupParent = $(this).parent().parent().parent().parent().parent();
                //如果电池信息表里已有与电源相应的信息，删除电源信息时删除对应的电池信息
                if ($("#battInfo").val() == 1) {
                    var UPSName = $(GroupParent).find("h3").text();
                    var battParam = $($(GroupParent).parent().parent().parent().parent().find("div#batteryParam")).find("div.col-sm-6");
                    $(battParam).each(function () {
                        // console.log($(this).find("label#powerName").text() == UPSName);
                        if ($(this).find("label#powerName").text() == UPSName) {
                            $(this).remove();
                        }
                    });
                }
                $(GroupParent).remove();

            });
        })
    },


}