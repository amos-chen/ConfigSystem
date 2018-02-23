var environmentFormValidate = {


    initValidator: function () {
        $($.find("form#environmentForm")).each(function () {
            $(this).bootstrapValidator({
                // container: 'tooltip',
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    needServer: {
                        message: '服务器信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '服务器信息不能为空'
                            }
                        }
                    },
                    needGsmModem: {
                        message: '短信告警信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '短信告警信息不能为空'
                            }
                        }
                    },
                    needBackup: {
                        message: '备品信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '备品信息不能为空'
                            }
                        }
                    },
                    batteryRoomNumber: {
                        message: '电池房数量验证失败',
                        validators: {
                            numeric: {
                                message: '电池房数量只能为数字'
                            },
                            integer:{
                                message: '电池房数量只能为整数',
                            },
                            notEmpty: {
                                message: '电池房数量不能为空'
                            }
                        }
                    }
                }
            });
        })

    },


}