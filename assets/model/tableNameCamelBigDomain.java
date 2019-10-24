package com.v6.moduleName.funPathDot.tableNameLower;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.v6.base.domain.BaseDomainImpl;
import com.lc.v6.jdbc.mybatis.V6SqlSessionUtil;

/**
 * @title: funDescDomain实现
 * @description:
 * @author: funAuther
 * @date: funDate
 * @修改: 
 *
 */
public class tableNameCamelBigDomain extends BaseDomainImpl implements	ItableNameCamelBigDomain {

  private static Log log = LogFactory.getLog(tableNameCamelBigDomain.class);

    /**
     * 查询funDesc数据
     */
    public List gettableNameCamelBig(Map paraMap) {
      return V6SqlSessionUtil.getSqlSession().selectList("tableNameCamelBigDomain.gettableNameCamelBig",paraMap);
    }

    @Override
    protected void initDomain() { 

    }	
}

   
