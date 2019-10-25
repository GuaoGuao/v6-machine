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
            url: 'testmachine.cmd?method=getTestMachineData',
            dataType: 'json',
            data: {
                packBarSearch: $('#packBarSearch').val(),
                distModeSearch: $('#distModeSearch').val(),
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
                        },
                        {
                          "id": "CALC_MODE",
                          "name": "CALC_MODE",
                          "field": "CALC_MODE",
                          "width": 100
                        },
                        {
                          "id": "COM_ID",
                          "name": "COM_ID",
                          "field": "COM_ID",
                          "width": 100
                        },
                        {
                          "id": "DIST_MODE",
                          "name": "DIST_MODE",
                          "field": "DIST_MODE",
                          "width": 100
                        },
                        {
                          "id": "ICOM_ID",
                          "name": "ICOM_ID",
                          "field": "ICOM_ID",
                          "width": 100
                        },
                        {
                          "id": "IS_CONTROL",
                          "name": "IS_CONTROL",
                          "field": "IS_CONTROL",
                          "width": 100
                        },
                        {
                          "id": "IS_INVTY",
                          "name": "IS_INVTY",
                          "field": "IS_INVTY",
                          "width": 100
                        },
                        {
                          "id": "IS_NETDIST",
                          "name": "IS_NETDIST",
                          "field": "IS_NETDIST",
                          "width": 100
                        },
                        {
                          "id": "IS_WARNING",
                          "name": "IS_WARNING",
                          "field": "IS_WARNING",
                          "width": 100
                        },
                        {
                          "id": "MON_AVE_SALES_DAYS",
                          "name": "MON_AVE_SALES_DAYS",
                          "field": "MON_AVE_SALES_DAYS",
                          "width": 100
                        },
                        {
                          "id": "PACK_BAR",
                          "name": "PACK_BAR",
                          "field": "PACK_BAR",
                          "width": 100
                        },
                        {
                          "id": "RATE_LOWER_LIMIT",
                          "name": "RATE_LOWER_LIMIT",
                          "field": "RATE_LOWER_LIMIT",
                          "width": 100
                        },
                        {
                          "id": "RATE_UPPER_LIMIT",
                          "name": "RATE_UPPER_LIMIT",
                          "field": "RATE_UPPER_LIMIT",
                          "width": 100
                        },
                        {
                          "id": "SAFETY_STORE_DAYS",
                          "name": "SAFETY_STORE_DAYS",
                          "field": "SAFETY_STORE_DAYS",
                          "width": 100
                        },
                        {
                          "id": "SEASON_PARM",
                          "name": "SEASON_PARM",
                          "field": "SEASON_PARM",
                          "width": 100
                        },
                        {
                          "id": "STORE_CONTROL_RATE",
                          "name": "STORE_CONTROL_RATE",
                          "field": "STORE_CONTROL_RATE",
                          "width": 100
                        },
                        {
                          "id": "STORE_LOWER_LIMIT",
                          "name": "STORE_LOWER_LIMIT",
                          "field": "STORE_LOWER_LIMIT",
                          "width": 100
                        },
                        {
                          "id": "STORE_UPPER_LIMIT",
                          "name": "STORE_UPPER_LIMIT",
                          "field": "STORE_UPPER_LIMIT",
                          "width": 100
                        },
                        {
                          "id": "TRANSIT_DAYS",
                          "name": "TRANSIT_DAYS",
                          "field": "TRANSIT_DAYS",
                          "width": 100
                        },
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
                    "rightAlignColumns": ["CALC_MODE", "COM_ID", "DIST_MODE", "ICOM_ID", "IS_CONTROL", "IS_INVTY", "IS_NETDIST", "IS_WARNING", "MON_AVE_SALES_DAYS", "PACK_BAR", "RATE_LOWER_LIMIT", "RATE_UPPER_LIMIT", "SAFETY_STORE_DAYS", "SEASON_PARM", "STORE_CONTROL_RATE", "STORE_LOWER_LIMIT", "STORE_UPPER_LIMIT", "TRANSIT_DAYS", ],
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
    <label class="pageLable" >我是功能描述表查询</label>
  </div>

  <div class="queryTableContainer">
    <div class="queryTableleft"  >
      <table class="queryTable">
        <tr>
          <td class="queryLabelTd"><label>PACK_BAR： </label></td>
          <td><input type="text" id="packBarSearch"  value="${packBarSearch}" /></td>
          <td class="queryLabelTd"><label>DIST_MODE： </label></td>
          <td><input type="text" id="distModeSearch"  value="${distModeSearch}" /></td>
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