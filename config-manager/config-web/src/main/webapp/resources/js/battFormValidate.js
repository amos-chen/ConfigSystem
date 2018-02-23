var battFormValidate = {


    initValidator: function () {
        $($.find("form#battForm")).each(function () {
            $(this).bootstrapValidator({
                // container: 'tooltip',
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    batteryVoltage: {
                        message: '电压验证失败',
                        validators: {
                            numeric: {
                                message: '电压只能为数字',
                            },
                            notEmpty: {
                                message: '电压不能为空'
                            }
                        }
                    },
                    batteryCapacity: {
                        message: '容量验证失败',
                        validators: {
                            numeric: {
                                message: '容量只能为数字',
                            },
                            notEmpty: {
                                message: '容量不能为空'
                            }
                        }
                    },
                    banks: {
                        message: '电池组数验证失败',
                        validators: {
                            numeric: {
                                message: '电池组数只能为数字',
                            },
                            integer:{
                                message: '电池组数只能为整数',
                            },
                            notEmpty: {
                                message: '电池组数不能为空'
                            }
                        }
                    },
                    eachBankNumber: {
                        message: '每组电池数量验证失败',
                        validators: {
                            numeric: {
                                message: '每组电池数量只能为数字',
                            },
                            integer:{
                                message: '每组电池数量只能为整数',
                            },
                            notEmpty: {
                                message: '每组电池数量不能为空'
                            }
                        }
                    },
                    width: {
                        message: '尺寸验证失败',
                        validators: {
                            numeric: {
                                message: '电池宽只能为数字',
                            },
                            notEmpty: {
                                message: '尺寸不能为空'
                            }
                        }
                    },
                    busDiameter: {
                        message: '母线直径验证失败',
                        validators: {
                            numeric: {
                                message: '母线直径只能为数字',
                            },
                            notEmpty: {
                                message: '母线直径不能为空'
                            }
                        }
                    }

                }
            });
        })

    },


}