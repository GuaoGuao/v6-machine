package com.v6.imr.pc.ttttest.tttest.testmachine;

import com.v6.base.cmd.QueryCommandImpl;
import com.v6.base.tool.DateTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.loushang.waf.mvc.QueryHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @title: 我是功能描述 查询实现类
 * @description:
 * @author: 我是码农的名字
 * @date: 2019-10-25
 * @修改:
 */
public class TestMachineQueryPageInitCmd  extends QueryCommandImpl {

    private static Log log = LogFactory.getLog(TestMachineQueryPageInitCmd.class);
    private ITestMachineService testMachineService = null;

    public ITestMachineService getTestMachineService() {
        if(testMachineService==null){
            log.error("testmachinequerypageinitcmd.getTestMachineService is null!");
        }
        return testMachineService;
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
            log.info("TestMachineQueryPageInitCmd.query--begin");
        }
        req.setAttribute("date", DateTool.getToday());
        req.setAttribute("month", DateTool.getCurMonth());
        req.setAttribute("year", DateTool.getToday().substring(0, 4));
        if (log.isInfoEnabled()) {
            log.info("TestMachineQueryPageInitCmd.query--end");
        }
        return null;
    }

    public void setTestMachineService(ITestMachineService testMachineService) {
        this.testMachineService = testMachineService;
    }
}
