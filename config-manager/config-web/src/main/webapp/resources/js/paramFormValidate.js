var paramFormValidate = {


    initValidator: function () {
        $($.find("form#paramForm")).each(function () {
            $(this).bootstrapValidator({
                // container: 'tooltip',
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    model: {
                        message: '型号验证失败',
                        validators: {
                            notEmpty: {
                                message: '电压不能为空'
                            }
                        }
                    },
                    length: {
                        message: '长度验证失败',
                        validators: {
                            numeric: {
                                message: '长度只能为数字',
                            },
                            notEmpty: {
                                message: '容量不能为空'
                            }
                        }
                    },
                    width: {
                        message: '宽度验证失败',
                        validators: {
                            numeric: {
                                message: '宽度只能为数字',
                            },
                            notEmpty: {
                                message: '宽度不能为空'
                            }
                        }
                    },
                    height: {
                        message: '高度验证失败',
                        validators: {
                            numeric: {
                                message: '高度只能为数字',
                            },
                            notEmpty: {
                                message: '高度不能为空'
                            }
                        }
                    },
                    language: {
                        message: '语言验证失败',
                        validators: {
                            notEmpty: {
                                message: '语言不能为空'
                            }
                        }
                    },
                    fileInput: {
                        message: '文件验证失败',
                        validators: {
                            notEmpty: {
                                message: '文件不能为空'
                            }
                        }
                    },

                }
            });
        })

    },


}