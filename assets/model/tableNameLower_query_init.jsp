<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/tags/v6fn" prefix="v6fn"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="/isrs/dist/common/ind_m_slickgrid/main.js"></script>
<link href="/isrs/dist/common/ind_m_slickgrid/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

    $(document).ready(function(){

        initSelector()

        getData();

        $("#queryButton").on("click", getData);

    });

    function initSelector() {

    }

    function getData() {
        var idx = layer.load();
        $.ajax({
            type: 'GET',
            url: 'tableNameLower.cmd?method=gettableNameCamelBigData',
            dataType: 'json',
            data: {funJspModel1
            }
        }).done(function (data) {
            if ( data.ok ) {
                var showData = data.data.resList;
                if (!showData || showData.length===0) {
                    $(".gridTable").html("<div id=\"myGrid\">查无数据</div>");
                    return
                }
                var bodyWidth = $('.divBody').width();
                var colDefs =
                    [
                        {
                            "id": "SEQ",
                            "name": "序号",
                            "field": "SEQ",
                            "width": 70,
                            formatter: row=>row+1
                        },funJspModel3
                    ];
                var options = {
                    "selectActiveRow": true,
                    "leftColumns": 0,
                    "rightColumns": 0,
                    "rowHeight":30,
                    "showSumRow": false,
                    "secondThDouble":true,
                    "fristThDouble":true,
                    "sumRowColumns": [],
                    "centerAlignColumns": ["SEQ"],
                    "rightAlignColumns": [funJspModel4],
                    "thRowSpan": [], 		// 合并列
                    "fixedHeight":window.outerHeight-window.innerHeight+119+'px'
                };

                $("#myGrid").html("");
                $("#myGrid").villaMSlickGrid(showData,colDefs, options);
            } else {
                jAlert(data.msg);
            }
        }).fail(function() {
            jAlert('查询失败！');
        }).always(function() {
            layer.close(idx);
        });
    }

</script>

<div class="divBody">
  <div class="buttonRightContainer">
    <label class="pageLable" >funDesc表查询</label>
  </div>

  <div class="queryTableContainer">
    <div class="queryTableleft"  >
      <table class="queryTable">
        <tr>funJspModel2
        </tr>
      </table>
    </div>
    <div class="queryTableright">
      <button id="queryButton" type="button" class="btn btn-warning btn-xs btn-border btn-search">
        <span class='v6icon search orange'></span> 查询
      </button>
    </div>
  </div>

  <div class="gridTable" style="margin-top: 15px;">
    <div id="myGrid"></div>
  </div>
</div>