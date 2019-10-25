package com.v6.imr.pc.ttttest.tttest.testmachine;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.v6.base.domain.BaseDomainImpl;
import com.lc.v6.jdbc.mybatis.V6SqlSessionUtil;

/**
 * @title: 我是功能描述Domain实现
 * @description:
 * @author: 我是码农的名字
 * @date: 2019-10-25
 * @修改: 
 *
 */
public class TestMachineDomain extends BaseDomainImpl implements	ITestMachineDomain {

  private static Log log = LogFactory.getLog(TestMachineDomain.class);

    /**
     * 查询我是功能描述数据
     */
    public List getTestMachine(Map paraMap) {
      return V6SqlSessionUtil.getSqlSession().selectList("TestMachineDomain.getTestMachine",paraMap);
    }

    @Override
    protected void initDomain() { 

    }	
}

   
