package com.suning.arttrain.util;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 读写分离处理
 * 
 * @author zhanglb
 */
@SuppressWarnings("all")
public class SeparateReadAndWriteHandler extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceName = DynamicDataSourceHolder.getDataSourceName();
		return dataSourceName;
	}

}
