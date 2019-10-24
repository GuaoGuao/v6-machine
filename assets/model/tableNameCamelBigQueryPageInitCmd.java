package com.v6.moduleName.funPathDot.tableNameLower;

import com.v6.base.cmd.QueryCommandImpl;
import com.v6.base.tool.DateTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.loushang.waf.mvc.QueryHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @title: funDesc 查询实现类
 * @description:
 * @author: funAuther
 * @date: funDate
 * @修改:
 */
public class tableNameCamelBigQueryPageInitCmd  extends QueryCommandImpl {

    private static Log log = LogFactory.getLog(tableNameCamelBigQueryPageInitCmd.class);
    private ItableNameCamelBigService tableNameCamelService = null;

    public ItableNameCamelBigService gettableNameCamelBigService() {
        if(tableNameCamelService==null){
            log.error("tableNameLowerquerypageinitcmd.gettableNameCamelBigService is null!");
        }
        return tableNameCamelService;
    }

    /**
     * 初始化页面
     * @param req
     * @param rep
     * @param helper
     * @param map
     * @return
     */
    public String query(HttpServletRequest req,HttpServletResponse rep,
              QueryHelper helper,Map map) throws Exception {
        if (log.isInfoEnabled()) {
            log.info("tableNameCamelBigQueryPageInitCmd.query--begin");
        }
        req.setAttribute("date", DateTool.getToday());
        req.setAttribute("month", DateTool.getCurMonth());
        req.setAttribute("year", DateTool.getToday().substring(0, 4));
        if (log.isInfoEnabled()) {
            log.info("tableNameCamelBigQueryPageInitCmd.query--end");
        }
        return null;
    }

    public void settableNameCamelBigService(ItableNameCamelBigService tableNameCamelService) {
        this.tableNameCamelService = tableNameCamelService;
    }
}
