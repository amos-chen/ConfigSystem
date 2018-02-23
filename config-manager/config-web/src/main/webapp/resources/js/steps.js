var Steps = {

    URL: {
        addDataCenterConfig: function () {
            return "/config/ups/configuration";
        },
        addTelecomConfig: function () {
            return "/config/telecom/configuration";
        },
        addPowerutilityConfig: function () {
            return "/config/powerutility/configuration";
        },
    },

    init: function () {
        $("#wizard").steps({
            headerTag: "h3",
            bodyTag: "section",
            transitionEffect: "slideLeft",
            stepsOrientation: "vertical",
            labels: {
                cancel: "取消",
                next: "下一步",
                previous: "上一步",
                loading: "加载中 ...",
                finish: "提交"
            },
            //步骤改变中
            onStepChanging: function (event, currentIndex, newIndex) {
                if (Math.abs(currentIndex - newIndex) > 1) {
                    return false;
                }
                //当前步骤是第一步，即将进入第二步
                if (currentIndex == 0) {
                    //验证第一步输入的内容是否通过验证
                    if ($('#applicationForm').data('bootstrapValidator').isValid()) {
                        //如果通过验证，并且powerInfo的flag值为0（说明第一次进入电源信息页）
                        if ($('#powerInfo').val() == 0) {
                            //初始化电源信息页
                            addPowerInfo.init({
                                application: $("#application").val()
                            });
                            return true;
                        } else {
                            //如果powerInfo的flag值为1，说明不是第一次进入电源信息页，则不需要进行初始化
                            return true;
                        }
                    } else {
                        //如果应用场景信息填写不完整，弹出提示信息
                        toastr.warning("请将必填内容填写完整");
                        return false;
                    }
                    //如果当前步骤为第二步，即将进入第三步
                } else if (currentIndex == 1) {
                    //判断多个表单中是否存在未填写完的表单
                    var power_is_validation = true;
                    //验证每个电源信息表单是否填写完整
                    $($.find('form#powerForm')).each(function () {
                        if (!$(this).data('bootstrapValidator').isValid()) {
                            power_is_validation = false;
                        }
                    });
                    //如果表单内容不为空，且填写完整，则进入下一步，否则弹出提示信息
                    if (power_is_validation) {
                        if ($("form#powerForm").html() !== undefined) {
                            var array = new Array();
                            var upsInfoNum = $("#powerParam").find("h3").length;
                            for (var i = 0; i < upsInfoNum; i++) {
                                array.push($($("#powerParam").find("h3")[i]).text());
                            }
                            //如果battInfo的值为0，说明电池信息表未初始化过，需要进行初始化，否则则不需要
                            if ($("#battInfo").val() == 0) {
                                addBattInfo.init({
                                    upsNames: array
                                });
                            }
                            return true;
                        } else {
                            toastr.warning("请填写电源信息！");
                            return false;
                        }
                    } else {
                        toastr.warning("请将必填内容填写完整！");
                        return false;
                    }
                    //如果当前步骤为第三步，即将进入第四步
                } else if (currentIndex == 2) {
                    var batt_is_validation = true;
                    //验证每个电源信息表单是否填写完整
                    $($.find('form#battForm')).each(function () {
                        if (!$(this).data('bootstrapValidator').isValid()) {
                            batt_is_validation = false;
                        }
                    });
                    if (batt_is_validation) {
                        if ($('#environInfo').val() == 0) {
                            addEnvironmentInfo.init();
                        }
                        return true;
                    } else {
                        toastr.warning("请将必填内容填写完整！");
                    }
                    //如果当前步骤为第四步，即将提交表单
                } else if (currentIndex == 3) {
                    return true;
                }
            },
            //步骤完成时
            onStepChanged: function (event, currentIndex, priorIndex) {
                if (currentIndex == 1) {
                    //当电源信息初始页面加载完成时，初始化电源信息过滤器
                    powerFormValidate.initValidator();
                } else if (currentIndex == 2) {
                    battFormValidate.initValidator();
                } else if (currentIndex == 3) {
                    environmentFormValidate.initValidator();
                }

            },
            onFinishing: function (event, currentIndex) {
                if ($('#environmentForm').data('bootstrapValidator').isValid()) {
                    //点击提交后弹出提示框
                    $('#modal-download').modal('show');
                    //所有信息验证通过后，把数据传到服务器
                    var applicationJson = $('form#applicationForm').serializeJSON();
                    var environmentJson = $('form#environmentForm').serializeJSON();
                    var powerInfos = $('#powerParam').find('form');
                    var powerArray = new Array();
                    var configuration = {};
                    configuration.applicationInfo = applicationJson;
                    configuration.environmentInfo = environmentJson;
                    for (var i = 0; i < powerInfos.length; i++) {
                        var powerInfoJson = $(powerInfos[i]).serializeJSON();
                        var batteryInfoJson = $($('#batteryParam').find('form')[i]).serializeJSON();
                        if ($("#application").val() == addPowerInfo.Constant.DATACENTER) {
                            powerInfoJson.batteryInfo = batteryInfoJson;
                        } else if ($("#application").val() == addPowerInfo.Constant.TELECOME) {
                            powerInfoJson.telBatteryInfo = batteryInfoJson;
                        } else if ($("#application").val() == addPowerInfo.Constant.POWERUTILITY) {
                            powerInfoJson.powBatteryInfo = batteryInfoJson;
                        }
                        powerArray.push(powerInfoJson);
                    }
                    if ($("#application").val() == addPowerInfo.Constant.DATACENTER) {
                        configuration.upsInfos = powerArray;
                        Steps.download(JSON.stringify(configuration), Steps.URL.addDataCenterConfig());
                    } else if ($("#application").val() == addPowerInfo.Constant.TELECOME) {
                        configuration.smpsInfos = powerArray;
                        Steps.download(JSON.stringify(configuration), Steps.URL.addTelecomConfig());
                    } else if ($("#application").val() == addPowerInfo.Constant.POWERUTILITY) {
                        configuration.directCurrentPanelInfos = powerArray;
                        Steps.download(JSON.stringify(configuration), Steps.URL.addPowerutilityConfig());
                    }
                    // console.log(JSON.stringify(configuration));
                    return true;
                }
            },
            onFinished: function (event, currentIndex) {
            },
        });

    },
    download: function (data, url) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);    // 也可以使用POST方式，根据接口
        xhr.responseType = "blob";  // 返回类型blob
        xhr.setRequestHeader("Content-Type"
            , "application/json;charset=utf-8");
        // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
        xhr.onload = function () {
            // 请求完成
            if (this.status === 200) {
                // 返回200
                var blob = this.response;
                var reader = new FileReader();
                reader.readAsDataURL(blob);  // 转换为base64，可以直接放入a表情href
                reader.onload = function (e) {
                    // 转换完成，创建一个a标签用于下载
                    var a = document.createElement('a');
                    var nowDate = new Date();
                    var year = nowDate.getFullYear();
                    var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
                        : nowDate.getMonth() + 1;
                    var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
                        .getDate();
                    var dateStr = year + "-" + month + "-" + day;
                    var excelName = $('#projectTitle').val().replace("项目", "") + "项目配置" + dateStr;
                    //文件下载前关闭提示框
                    $('#modal-download').modal('hide');
                    a.download = excelName + '.xlsx';
                    a.href = e.target.result;
                    $("body").append(a);  // 修复firefox中无法触发click
                    a.click();
                    $(a).remove();
                }
            }
        };
        // 发送ajax请求
        xhr.send(data)
    },

}