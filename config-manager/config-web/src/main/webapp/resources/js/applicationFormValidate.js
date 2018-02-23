var applicationFormValidate = {


    initValidator: function () {

        $('#applicationForm').bootstrapValidator({
            // container: 'tooltip',
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                projectTitle: {
                    message: '项目标题验证失败',
                    validators: {
                        notEmpty: {
                            message: '项目标题不能为空'
                        }
                    }
                },
                application: {
                    message: '应用场景验证失败',
                    validators: {
                        notEmpty: {
                            message: '应用场景不能为空'
                        }
                    }
                },
                managementFunction: {
                    message: '管理功能验证失败',
                    validators: {
                        notEmpty: {
                            message: '管理功能不能为空'
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
                }

            }
        });

    },


}