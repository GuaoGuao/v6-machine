package com.v6.imr.pc.ttttest.tttest.testmachine;

import java.util.Map;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.v6.base.service.BaseServiceImpl;

/**
 * @title: 我是功能描述Service实现
 * @description:
 * @author: 我是码农的名字
 * @date: 2019-10-25
 * @修改:
 *
 */
public class TestMachineService  extends BaseServiceImpl implements ITestMachineService {

    private static Log log = LogFactory.getLog(TestMachineService.class);

    ITestMachineDomain testMachineDomain=null;	
    public ITestMachineDomain getTestMachineDomain() {
        return testMachineDomain;
    }
    public void setTestMachineDomain(ITestMachineDomain testMachineDomain) {
        this.testMachineDomain = testMachineDomain;
    }

    /**
      * 获取一条我是功能描述明细
      * @param  paraMap	
      * @return
      */
    public List getTestMachine(Map paraMap) {
        return getTestMachineDomain().getTestMachine(paraMap);
    }

    @Override
    protected void initService() {
        if (log.isInfoEnabled()) {
            log.info("TestMachineService.initService()--begin");
        }

        if (getTestMachineDomain() == null) {
            throw new RuntimeException(
                "TestMachineServiceImpl配置错误,属性testMachineDomain不能为空");
        }

        if (log.isInfoEnabled()) {
            log.info("TestMachineService.initService()--end");
        }
      
    }

}

