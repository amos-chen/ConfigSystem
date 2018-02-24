/**
 * Created by chenlunwei on 2018/2/10.
 */
var addBattInfo = {
    Constant: {
        BATT_TEMPLATE: ''
    },

    URL: {
        Battery: function () {
            return "/resources/json/battery.json";
        }
    },

    init: function (data) {
        addBattInfo.addSection(data.upsNames);
        battFormValidate.initValidator();
    },

    addSection: function (upsNames) {
        $('#batteryTitle').html([
            '<h1 name="itemTitle" id="itemTitle">',
            '电池信息',
            '<small>',
            '<span class="iconfont icon-shuangjiantouyou"></span>',
            '电池信息设置',
            '</small>',
            '<div class="btn-group">',
            '</div>',
            '</h1>'].join(''));
        $.getJSON(addBattInfo.URL.Battery(), function (data) {
            addBattInfo.writePageBody(data, upsNames);
        });
    },

    writePageBody: function (JsonParamData, upsNames) {
        var batt_num = upsNames.length;
        var arr = new Array();
        for (var i = 0; i < batt_num; i++) {
            if (i % 2 == 0) {
                arr.push('<div class="row">');
            }
            arr.push(['<div class="col-sm-6">' +
            '<div class="panel panel-info">' +
            '<div class="panel-heading">' +
            '<h3 class="panel-title">' + JsonParamData.group +
            (upsNames[i].substring(upsNames[i].length - 1)) +
            '</h3>' +
            '</div>' +
            '<div class="panel-body">' +

            '<label class="col-sm-5 control-label" style="text-align: right;color:#D53F40">对应电源:</label>' +
            '<div class="col-sm-5">' +
            '<label id="powerName" style="color:#D53F40;padding-left:0" class="control-label">' + upsNames[i] + '</label>' +
            '</div>' +

            '<form id="battForm" class="form-horizontal" role="form">'].join(''));
            var paramList = JsonParamData.params;
            for (var j = 0; j < paramList.length; j++) {
                if (paramList[j].name == 'batteryVoltage') {
                    arr.push([
                        '<div class="form-group">' +
                        '<label class="col-sm-5 control-label">' + paramList[j].value + ':</label>' +
                        '<div class="col-sm-5">' +
                        '<label class="radio-inline">' +
                        '<input type="radio" name="' + paramList[j].name + '" id="' + paramList[j].name + '" value="2">2V' +
                        '</label>' +
                        '<label class="radio-inline">' +
                        '<input type="radio" name="' + paramList[j].name + '" id="' + paramList[j].name + '" value="12">12V' +
                        '</label>' +
                        '</div></div>'].join(''));
                }
                else {
                    if (!(paramList[j].name == 'eachBankNumber' && $("#application").val() == addPowerInfo.Constant.TELECOME)) {
                        arr.push([
                            '<div class="form-group">' +
                            '<label for="' + paramList[j].name + '" class="col-sm-5 control-label">' + paramList[j].value + '<span class="text-danger">*</span>:</label>' +
                            '<div class="col-sm-5">' +
                            '<input name="' + paramList[j].name + '" class="form-control" type="text" id="' + paramList[j].name + '"+/>' +
                            '</div></div>'].join(''));
                    }
                }
            }
            arr.push(['</form></div></div></div>'].join(''));
            if ((i + 1) % 2 == 0) {
                arr.push('</div>');
            }
        }
        if (batt_num % 2 != 0) {
            arr.push('</div>');
        }
        $('#batteryParam').html(arr.join(''));
        $('#batteryParam').find('.selectpicker').selectpicker('refresh');

        var newHTML = '<div class="col-sm-6">' + $($('#batteryParam').find('div.col-sm-6')[0]).html() + '</div>';
        addBattInfo.Constant.BATT_TEMPLATE = newHTML;
        $("#batteryParam").find(".panel-title").each(function () {
            var title = $(this).text();
            $(this).text(title.replace("(对应一台设备)", "") + "(对应一台设备)");
        })
        // var battTitle = $($('#batteryParam').find("div.col-sm-6")[0]).find("h3.panel-title").text();
        // newHTML = newHTML.replace(battTitle)
        // console.log(newHTML);

        //当电池信息页初始化好之后，修改battInfo的值为1
        $('#battInfo').val(1);
    },

    addBatt_Group: function (POWER_NUM, batteryParam, lastBattRows) {
        var battTitle = $(addBattInfo.Constant.BATT_TEMPLATE).find('h3.panel-title').text();
        var powerName = $(addBattInfo.Constant.BATT_TEMPLATE).find('#powerName').text();
        var html = addBattInfo.Constant.BATT_TEMPLATE
            .replace(battTitle, battTitle.substring(0, battTitle.length - 1) + POWER_NUM)
            .replace(powerName, powerName.substring(0, powerName.length - 1) + POWER_NUM);
        if ($(lastBattRows).find('div.col-sm-6').length === 2) {
            newHTML = '<div class="row">' + html + '</div>';
            $(batteryParam).append(newHTML);
        } else {
            $(lastBattRows).append(html);
        }
        $("#batteryParam").find(".panel-title").each(function () {
            var title = $(this).text();
            $(this).text(title.replace("(对应一台设备)", "") + "(对应一台设备)");
        })
        battFormValidate.initValidator();
    }


}