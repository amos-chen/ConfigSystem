var powerFormValidate = {


    initValidator: function () {
        $($.find("form#powerForm")).each(function () {
            $(this).bootstrapValidator({
                // container: 'tooltip',
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    brand: {
                        message: '品牌验证失败',
                        validators: {
                            notEmpty: {
                                message: '品牌不能为空'
                            }
                        }
                    },
                    model: {
                        message: '型号验证失败',
                        validators: {
                            notEmpty: {
                                message: '型号不能为空'
                            }
                        }
                    },
                    power: {
                        message: '功率验证失败',
                        validators: {
                            numeric: {
                                message: '功率只能为数字'
                            },
                            notEmpty: {
                                message: '功率不能为空'
                            }
                        }
                    },
                    number: {
                        message: '数量验证失败',
                        validators: {
                            numeric: {
                                message: '数量只能为数字'
                            },
                            integer: {
                                message: '数量只能为整数'
                            },
                            notEmpty: {
                                message: '数量不能为空'
                            }
                        }
                    },
                    isThreeWire: {
                        message: '三线制信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '三线制信息不能为空'
                            }
                        }
                    },
                    needConvergence: {
                        message: '汇流柜信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '汇流柜信息不能为空'
                            }
                        }
                    },
                    supportDryNode: {
                        message: '干节点信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '干节点信息不能为空'
                            }
                        }
                    },
                    needSingleMonitor: {
                        message: '单体采集信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '单体采集信息不能为空'
                            }
                        }
                    },
                    needEnergySaving: {
                        message: '空调节能信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '空调节能信息不能为空'
                            }
                        }
                    },
                    needSmartMeter: {
                        message: '智能电表信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '智能电表信息不能为空'
                            }
                        }
                    },
                    needLeakageSensor: {
                        message: '漏液监测信息验证失败',
                        validators: {
                            notEmpty: {
                                message: '漏液监测信息不能为空'
                            }
                        }
                    },
                    maxChargeCurrent:{
                        message: '充电电流验证失败',
                        validators: {
                            numeric: {
                                message: '充电电流只能为数字'
                            },
                            notEmpty: {
                                message: '充电电流不能为空'
                            }
                        }
                    },
                    maxDischargeCurrent:{
                        message: '放电电流验证失败',
                        validators: {
                            numeric: {
                                message: '放电电流只能为数字'
                            },
                            notEmpty: {
                                message: '放电电流不能为空'
                            }
                        }
                    }
                }
            });
        })

    },


}