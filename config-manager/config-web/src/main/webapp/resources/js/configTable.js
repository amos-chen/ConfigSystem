var table = {
    URL: {
        configInfo: function (configId) {
            return "/config/" + configId + "/Info";
        },
        configResult: function (configId) {
            return "/config/" + configId + "/Result";
        },
        configDownload:function () {
            return "/config/download/configuration";
        }
    },

    showTabale: function () {
        //参数设置，若用默认值可以省略以下面代
        /*toastr.options = {
         "closeButton": false, //是否显示关闭按钮
         "debug": false, //是否使用debug模式
         "positionClass": "toast-top-full-width",//弹出窗的位置
         "showDuration": "300",//显示的动画时间
         "hideDuration": "1000",//消失的动画时间
         "timeOut": "5000", //展现时间
         "extendedTimeOut": "1000",//加长展示时间
         "showEasing": "swing",//显示时的动画缓冲方式
         "hideEasing": "linear",//消失时的动画缓冲方式
         "showMethod": "fadeIn",//显示时的动画方式
         "hideMethod": "fadeOut" //消失时的动画方式
         };*/

        $("#config-table").bootstrapTable({
            //1.表格样式，默认'table table-hover'且表格带有边框
            classes: 'table table-hover',
            //2.按照类名所处的列进行排序，无默认值
            sortClass: 'itemId',
            //3.height定义表格的高度
            height: 600,
            //4.当数据为 undefined 时显示的字符
            //undefinedText:String
            //5.设置为 true 会有隔行变色效果,默认为false
            striped: true,
            //6.按照"name"属性所处的列进行排序，无默认值
            //sortName:String
            //7.排序方式，升序或者降序，默认asc
            sortOrder: 'asc',
            //8.设置为 true 将获得稳定的排序，我们会添加_position属性到 row 数据中。
            //sortStable:false
            //9.定义字体库 ('Glyphicon' or 'fa' for FontAwesome),使用"fa"时需引用 FontAwesome,默认为'glyphicon'
            iconsPrefix: 'glyphicon',
            //10.icons定义了表格控制按键需要用到的图标
            //icons:{paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down'...}
            //11.columns，列配置项
            columns: [
                /*{
                 checkbox: false,
                 },*/
                {
                    //field属性相当于td里的name属性，title为表的表头
                    field: 'configId',
                    title: '项目ID',
                    class: 'configId',
                    //align属性是设置数据如何对齐
                    align: 'center',
                    //halign属性是设置表头如何对齐
                    // halign: 'center'
                    sortable:true,
                    order:'asc'
                }, {
                    field: 'projectTitle',
                    title: '项目标题',
                    align: 'center',
                }, {
                    field: 'application',
                    title: '应用场景',
                    formatter: table.applicationFomatter,
                    align: 'center',
                }, {
                    field: 'managementFunction',
                    title: '管理功能',
                    formatter: table.managementFunctionFomatter,
                    align: 'center',
                }, {
                    field: 'language',
                    title: '配置语言',
                    align: 'center',
                }, {
                    field: 'createTime',
                    title: '配置时间',
                    formatter: table.createTimeFormatter,
                    align: 'center',
                }, {
                    field: 'operation',
                    title: '操作',
                    align: 'center',
                    valign: 'middle',
                    width: 60,
                    formatter: table.operationFormatter,
                    events: 'operationEvents',

                }],
            //12.表单数据，json数据
            //data:Array
            //13.自定义ajax方法
            //ajax:Function
            //14.ajax请求的方式,默认为'get'
            method: 'get',
            //15.服务器数据的加载地址
            url: '/config/configuration/list',
            //16.设置为 false 禁用 AJAX 数据缓存,默认为true
            cache: true,
            //17.发送到服务器的数据编码类型,默认为json
            contentType: 'application/json',
            //18.服务器返回的数据类型，默认为json
            dataType: 'json',
            //19.提交ajax请求时的附加参数
            // ajaxOptions:object{}
            /*20.请求服务器数据时，可以通过重写参数的方式添加一些额外的参数
             例如 toolbar (分页)中的参数 如果 queryParamsType = 'limit' ,
             返回参数必须包含limit, offset, search, sort, order 否则,
             需要包含:pageSize, pageNumber, searchText, sortName, sortOrder.返回false将会终止请求*/
            queryParams: table.queryParams,
            //21.设置为 'limit' 则会发送符合RESTFul格式的参数.默认为'limit'
            queryParamsType: 'limit',
            //21.加载服务器数据之前的处理程序，可以用来格式化数据。function(res) {return res;}
            //加载服务器数据之前的处理程序，可以用来格式化数据。参数：res为从服务器请求到的数据。
            // responseHandler:table.dataHandler,
            //22.设置为 true 会在表格底部显示分页条,默认为false
            pagination: true,
            //23.设置为 true 启用分页条无限循环的功能。默认为true
            paginationLoop: true,
            //24.设置为 true 只显示总数据数，而不显示分页按钮。需要 pagination='True',默认为false
            onlyInfoPagination: false,
            //25.设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
            sidePagination: 'server',
            //26.如果设置了分页，首页页码,默认为1
            pageNumber: 1,
            //27.如果设置了分页，页面数据条数,默认为10
            pageSize: 10,
            //28.如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            pageList: [10, 25, 50, 100],
            //29.radio or checkbox 的字段名,默认为'btSelectItem'
            //selectItemName:'btSelectItem'
            //30.智能显示分页标签和信息，默认为true
            smartDisplay: true,
            //31.转义HTML字符串，替换 &, <, >, ", `, 和 ' 字符.
            escape: false,
            //32.是否启用搜索框，默认为'false',此处为客户端搜索
            search: true,
            //33.设置为 true时，按回车触发搜索方法，否则自动触发搜索方法，默认为false
            searchOnEnterKey: false,
            //34.设置为true启用 全匹配搜索，否则为模糊搜索,默认为false
            strictSearch: false,
            //35.初始化搜索内容，默认为空
            // searchText:'三',
            //36.设置搜索超时时间，默认为500
            searchTimeOut: 500,
            //37.允许空字符搜索，默认为true
            trimOnSearch: true,
            //38.是否显示列头,默认为true
            showHeader: true,
            //39.是否显示列脚，默认为false
            showFooter: false,
            //40.是否显示内容下拉框，默认为false
            showColumns: true,
            //41.是否显示 刷新按钮,默认为false
            showRefresh: true,
            //42.是否显示 切换试图（table/card）按钮,默认为false
            showToggle: false,
            //43.是否显示 数据条数选择框,显示或隐藏分页信息
            showPaginationSwitch: false,
            //44.当列数小于此值时，将隐藏内容列下拉框。
            minimumCountColumns: 1,
            //45.指定主键列,无默认值
            // idField:String
            //46.指示每行的唯一标识符。无默认值
            uniqueId: String,
            //47.设置为 true将显示card视图，适用于移动设备。否则为table试图，适用于pc,默认为false
            cardView: false,
            //48.设置为true可以显示详细页面模式。
            detailView: false,
            //49.格式化详细页面模式的视图。
            // detailFormatter:function
            //50.指定 搜索框 水平方向的位置。'left' or 'right',默认为'right'
            searchAlign: 'left',
            //51.指定 按钮 水平方向的位置。'left' or 'right',默认为'right'
            buttonsAlign: 'left',
            //52.指定 toolbar 水平方向的位置。'left' or 'right',默认为'left'
            toolbarAlign: 'left',
            //53.指定 分页条 在垂直方向的位置。'top' or 'bottom' or 'bonth',默认为'bottom'
            paginationVAlign: 'bottom',
            //54.指定 分页条 在水平方向的位置。'left' or 'right',默认'right'
            paginationHAlign: 'right',
            //55.指定 分页详细信息 在水平方向的位置。'left' or 'right',默认为'left'
            paginationDetailHAlign: 'left',
            //56.指定分页条中上一页按钮的图标或文字
            paginationPreText: '上一页',
            //57.指定分页条中下一页按钮的图标或文字
            paginationNextText: '下一页',
            //58.设置true 将在点击行时，自动选择rediobox 和 checkbox,默认为false
            clickToSelect: false,
            //59.设置True 将禁止多选
            singleSelect: false,
            //60.个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
            toolbar: '.toolbar',
            //61.设置false 将在列头隐藏check-all checkbox,默认为true
            checkboxHeader: true,
            //62.设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
            maintainSelected: false,
            //63.设置为false 将禁止所有列的排序
            sortable: true,
            //64.设置为 false 将在点击分页按钮时，自动记住排序项。仅在 sidePagination设置为 server时生效.
            silentSort: true,
            //65.自定义行样式 参数为：function(row,index){}row: 行数据,index: 行下标,返回值可以为class或者css
            // rowStyle:function
            //66.同上
            // rowAttributes:function
            //67.执行定制搜索功能，
            //customSearch:$.noop
            //68.执行自定义排序功能
            //customSort:$.noop
            //69.是否显示数据导出图标
            showExport: true,
            //70.basic', 'all', 'selected'.
            //all不生效的原因:表格是后台分页，如果要获取所有的商品信息会向后台发出一个ajax请求，获取所有的商品信息
            exportDataType: 'basic'
        });

        window.operationEvents = {
            'click .configInfo': function (e, value, row, index) {
                $('#modal-configInfo').modal({
                    show: true,
                });
                $.ajax({
                    url: table.URL.configInfo(row.configId),
                    method: 'GET',
                    success: function (result) {
                        var configInfo = result.data;
                        var content = $('#modal-configInfo').find("div.col-sm-12");
                        var array = new Array();
                        for (var attr in configInfo) {
                            array.push('<table class="table">');
                            var tableData = configInfo[attr];
                            var tableRows = table.getJsonLength(tableData);
                            for(var attr2 in tableData){
                                if(attr2=="项目标题"||attr2=="UPS品牌"||attr2=="直流屏品牌"||attr2=="运营商"){
                                    array.push('<tr>');
                                    array.push('<td style="width: 100px;" rowspan="'+tableRows+'">'+attr+'</td>');
                                    array.push('<td style="width: 200px;">'+attr2.substring(attr2.indexOf('、')+1)+'</td>');
                                    array.push('<td style="width: 200px;">'+tableData[attr2]+'</td>');
                                    array.push('</tr>');
                                }else {
                                    array.push('<tr>');
                                    array.push('<td style="width: 200px;">'+attr2.substring(attr2.indexOf('、')+1)+'</td>');
                                    array.push('<td style="width: 200px;">'+tableData[attr2]+'</td>');
                                    array.push('</tr>');
                                }
                            }
                            array.push('</table>');
                        }
                        content.html(array.join(''));
                    }
                })
            },
            'click .configResult': function (e, value, row, index) {
                $('#modal-configResult').modal('show');
                $.ajax({
                    url: table.URL.configResult(row.configId),
                    method: 'GET',
                    success: function (result) {
                        var configResult = $.parseJSON(result.data.configData);
                        var content = $('#modal-configResult').find("div.col-sm-12");
                        var array = new Array();
                        array.push('<table class="table text-nowrap">' +
                            '<thead><tr><th>设备名称</th><th>型号</th><th>单位</th><th>数量</th></tr></thead>');
                        for (var attr in configResult) {
                            array.push('<tbody><tr><td colspan="5" style="text-align: left!important;background-color:#f9f9f9;">' + attr + '</td></tr>');
                            for (var attr2 in configResult[attr]) {
                                array.push('<tr>');
                                for (var attr3 in configResult[attr][attr2]) {
                                    if (attr3 != 'remark') {
                                        array.push('<td>' + configResult[attr][attr2][attr3] + '</td>')
                                    }
                                }
                                array.push('</tr>');
                            }
                            array.push('</tbody>');
                        }
                        array.push('</table>');
                        content.html(array.join(''));
                    }
                })

            },
            'click .configDownload': function (e, value, row, index) {
                table.download(table.URL.configDownload(),row);
            }
        };
    },

    queryParams: function (params) {
        var temp = {
            limit: params.limit,
            //offset为页面从第几条开始查询
            offset: params.offset,
            sort: params.sort,
            order: params.order,
            search: params.search
        };
        return temp;
    },
    operationFormatter: function (value, row, index) {
        if (index < 7) {
            return '<li class="dropdown dropdown-edit">' +
                '<a style="color: black" class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="iconfont icon-bj"></span></a>' +
                '<ul class="dropdown-menu dropdown-menu-caret" role="menu">' +
                '<li><a class="configInfo" href="javascript:void(0)"><span class="iconfont icon-xinxiqueren icon-fw"></span>项目信息</a></li>' +
                '<li><a class="configResult" href="javascript:void(0)"><span class="iconfont icon-yemianpeizhi icon-fw"></span>配置信息</a></li>' +
                '<li><a class="configDownload" href="javascript:void(0)"><span class="iconfont icon-msnui-download icon-fw"></span>配置下载</a></li>' +
                '</ul></li>';
        } else {
            return '<li class="dropdown dropdown-edit dropup">' +
                '<a style="color: black" class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="iconfont icon-bj"></span></a>' +
                '<ul class="dropdown-menu dropup-menu-caret" role="menu">' +
                '<li><a class="configInfo" href="javascript:void(0)"><span class="iconfont icon-xinxiqueren icon-fw"></span>项目信息</a></li>' +
                '<li><a class="configResult" href="javascript:void(0)"><span class="iconfont icon-yemianpeizhi icon-fw"></span>配置信息</a></li>' +
                '<li><a class="configDownload" href="javascript:void(0)"><span class="iconfont icon-msnui-download icon-fw"></span>配置下载</a></li>' +
                '</ul></li>';
        }
    },

    managementFunctionFomatter: function (value, row, index) {
        if (value) {
            return "是"
        } else {
            return "否"
        }
    },
    createTimeFormatter: function (value, row, index) {
        var date = new Date(value);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        return Y+M+D;
    },

    applicationFomatter: function (value, row, index) {
        if (value == 1) {
            return "数据中心"
        } else if (value == 2) {
            return "电信"
        } else if (value == 3) {
            return "电力"
        }
    },

    getJsonLength: function (jsonData) {
        var count = 0;
        for (var attr in jsonData) {
            count++;
        }
        return count;
    },

    download: function (url,row) {
        var data = new FormData();
        data.append("configId",row.configId);
        data.append("application",row.application);
        data.append("projectName",row.projectTitle);
        data.append("language",row.language);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);    // 也可以使用POST方式，根据接口
        xhr.responseType = "blob";  // 返回类型blob
        /*xhr.setRequestHeader("Content-Type"
            , "application/x-www-form-urlencoded;charset=utf-8");*/
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
                    var nowDate = new Date(row.createTime);
                    var year = nowDate.getFullYear();
                    var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
                        : nowDate.getMonth() + 1;
                    var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
                        .getDate();
                    var dateStr = year + "-" + month + "-" + day;
                    var excelName = row.projectTitle.replace("项目", "") + "项目配置" + dateStr;
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
    }
}