package com.v6.moduleName.funPathDot.tableNameLower;

import java.util.Map;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.v6.base.service.BaseServiceImpl;

/**
 * @title: funDescService实现
 * @description:
 * @author: funAuther
 * @date: funDate
 * @修改:
 *
 */
public class tableNameCamelBigService  extends BaseServiceImpl implements ItableNameCamelBigService {

    private static Log log = LogFactory.getLog(tableNameCamelBigService.class);

    ItableNameCamelBigDomain tableNameCamelDomain=null;	
    public ItableNameCamelBigDomain gettableNameCamelBigDomain() {
        return tableNameCamelDomain;
    }
    public void settableNameCamelBigDomain(ItableNameCamelBigDomain tableNameCamelDomain) {
        this.tableNameCamelDomain = tableNameCamelDomain;
    }

    /**
      * 获取一条funDesc明细
      * @param  paraMap	
      * @return
      */
    public List gettableNameCamelBig(Map paraMap) {
        return gettableNameCamelBigDomain().gettableNameCamelBig(paraMap);
    }

    @Override
    protected void initService() {
        if (log.isInfoEnabled()) {
            log.info("tableNameCamelBigService.initService()--begin");
        }

        if (gettableNameCamelBigDomain() == null) {
            throw new RuntimeException(
                "tableNameCamelBigServiceImpl配置错误,属性tableNameCamelDomain不能为空");
        }

        if (log.isInfoEnabled()) {
            log.info("tableNameCamelBigService.initService()--end");
        }
      
    }

}

