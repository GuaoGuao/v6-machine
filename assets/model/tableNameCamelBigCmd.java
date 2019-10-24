package com.v6.moduleName.funPathDot.tableNameLower;

import com.v6.base.cmd.BaseCommandImpl;
import com.v6.moduleName.tool.RepSendJson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.loushang.util.IErrorHandler;
import org.loushang.util.IMessageHandler;
import org.loushang.waf.mvc.ViewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: funDesc业务实现
 * @description:
 * @author: funAuther
 * @date: funDate
 * @修改: 
 *
 */
public class tableNameCamelBigCmd extends BaseCommandImpl {

  private static final long serialVersionUID = 1L;
  private static Log log = LogFactory.getLog(tableNameCamelBigCmd.class);

  private ItableNameCamelBigService tableNameCamelService = null;
  public ItableNameCamelBigService gettableNameCamelBigService() {
      return tableNameCamelService;
  }
  public void settableNameCamelBigService(ItableNameCamelBigService tableNameCamelService) {
      this.tableNameCamelService = tableNameCamelService;
  }

  /**
   * 查询 funDesc初始化
   * @param req
   * @param rep
   * @param errorHandler
   * @param messageHandler
   * @param viewHelper
   * @return
   */
  public void gettableNameCamelBigData(HttpServletRequest req, HttpServletResponse rep,
      IErrorHandler errorHandler, IMessageHandler messageHandler,	ViewHelper viewHelper) {
      if (log.isInfoEnabled()) {
          log.info("tableNameCamelBigCmd.forinsert--begin");
      }
      Map paramMap = new HashMap();
      Map resMap = new HashMap();
      Boolean ok = true;
      String msg = "";
      Map dataMap = new HashMap();
      try {
funCmdModel

          List resList = tableNameCamelService.gettableNameCamelBig(paramMap);

          ok = true;
          msg = "查询成功";
          dataMap.put("resList", resList);

      } catch (Throwable e) {

          if (log.isErrorEnabled()) {
              log.error("tableNameCamelBigCmd.forinsert--error");
              log.error(e);
          }
          ok = false;
          msg = "查询失败";

      } finally {

          if (log.isInfoEnabled()) {
              log.info("tableNameCamelBigCmd.forinsert--end");
          }
          resMap.put("data", dataMap);
          resMap.put("msg", msg);
          resMap.put("ok", ok);
          RepSendJson.sendJson(resMap, rep);

      }

  }

}
