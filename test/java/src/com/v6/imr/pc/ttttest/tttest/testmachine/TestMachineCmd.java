package com.v6.imr.pc.ttttest.tttest.testmachine;

import com.v6.base.cmd.BaseCommandImpl;
import com.v6.imr.tool.RepSendJson;
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
 * @title: 我是功能描述业务实现
 * @description:
 * @author: 我是码农的名字
 * @date: 2019-10-25
 * @修改: 
 *
 */
public class TestMachineCmd extends BaseCommandImpl {

  private static final long serialVersionUID = 1L;
  private static Log log = LogFactory.getLog(TestMachineCmd.class);

  private ITestMachineService testMachineService = null;
  public ITestMachineService getTestMachineService() {
      return testMachineService;
  }
  public void setTestMachineService(ITestMachineService testMachineService) {
      this.testMachineService = testMachineService;
  }

  /**
   * 查询 我是功能描述初始化
   * @param req
   * @param rep
   * @param errorHandler
   * @param messageHandler
   * @param viewHelper
   * @return
   */
  public void getTestMachineData(HttpServletRequest req, HttpServletResponse rep,
      IErrorHandler errorHandler, IMessageHandler messageHandler,	ViewHelper viewHelper) {
      if (log.isInfoEnabled()) {
          log.info("TestMachineCmd.forinsert--begin");
      }
      Map paramMap = new HashMap();
      Map resMap = new HashMap();
      Boolean ok = true;
      String msg = "";
      Map dataMap = new HashMap();
      try {

          String packBarSearch = req.getParameter("packBarSearch");
          paramMap.put("packBarSearch", packBarSearch);
          String distModeSearch = req.getParameter("distModeSearch");
          paramMap.put("distModeSearch", distModeSearch);

          List resList = testMachineService.getTestMachine(paramMap);

          ok = true;
          msg = "查询成功";
          dataMap.put("resList", resList);

      } catch (Throwable e) {

          if (log.isErrorEnabled()) {
              log.error("TestMachineCmd.forinsert--error");
              log.error(e);
          }
          ok = false;
          msg = "查询失败";

      } finally {

          if (log.isInfoEnabled()) {
              log.info("TestMachineCmd.forinsert--end");
          }
          resMap.put("data", dataMap);
          resMap.put("msg", msg);
          resMap.put("ok", ok);
          RepSendJson.sendJson(resMap, rep);

      }

  }

}
