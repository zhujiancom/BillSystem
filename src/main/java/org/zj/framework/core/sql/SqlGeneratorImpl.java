/**
 * 
 */
package org.zj.framework.core.sql;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.zj.framework.core.exception.ExceptionConstant.SQL;
import org.zj.framework.core.exception.ExceptionManage;
import org.zj.framework.core.exception.SqlException;

/**
 * @Description
 * @author zj
 * @Date 2014年10月20日
 *	
 */
@Component("SqlGeneratorImpl")
public class SqlGeneratorImpl implements SqlGenerator{
	/**
	 * @Function
	 * @param op
	 * @param mapping
	 * 	mapping固定形式：Map<tables,Map<tablename,alias>>
	 * 				Map<columns,Map<column,value>>
	 * 				Map<conditions,Map<column,value>>
	 * @return
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public String generate(CRUDType op,Map<String, Map<String,Object>> mapping) throws SqlException{
		Assert.notNull(mapping,"custom sql error! mapping can not be null!");
		if(mapping.get("tables") == null){
			ExceptionManage.throwSqlException(SQL.GENERATOR_SQL,"please specify a table at least!");
		}
		if(op.equals(CRUDType.CREATE)){
			return generateCreateSQL(mapping);
		}
		if(op.equals(CRUDType.UPDATE)){
			return generateUpdateSQL(mapping.get("tables"),mapping.get("columns"),mapping.get("conditions"));
		}
		return StringUtils.EMPTY;
	}

	/**
	 * @Function 更新sql语句
	 * @param mapping
	 * @return
	 * @author zj
	 * @Date 2014年10月20日
	 */
	private String generateUpdateSQL(Map<String,Object> tables,Map<String,Object> columns,Map<String,Object> conditions) throws SqlException{
		StringBuffer sb = new StringBuffer("UPDATE").append("\t");
		if(MapUtils.isEmpty(tables)){
			ExceptionManage.throwSqlException(SQL.GENERATOR_SQL,CRUDType.UPDATE+" ---> please specify a table at least!");
		}
		if(MapUtils.isEmpty(columns)){
			ExceptionManage.throwSqlException(SQL.GENERATOR_SQL,CRUDType.UPDATE+" ---> please specify a column to update!");
		}
		// 表
		for(Iterator<Entry<String,Object>> it = tables.entrySet().iterator();it.hasNext();){
			Entry<String,Object> entry = it.next();
			String table = entry.getKey();
			String alias = String.valueOf(entry.getValue());
			sb.append(table).append("\t").append(alias).append("\t");
			break;
		}
		//字段
		sb.append("SET").append("\t");
		buildStatement(sb,columns);
		if(!MapUtils.isEmpty(conditions)){
			sb.append("\t").append("WHERE").append("\t");
			buildStatement(sb,conditions);
		}
		return sb.toString();
	}

	private String generateCreateSQL(Map<String, Map<String,Object>> mapping) throws SqlException{
		return null;
	}



	private void buildStatement(StringBuffer sb,Map<String,Object> params){
		for(Iterator<Entry<String,Object>> it = params.entrySet().iterator();it.hasNext();){
			Entry<String,Object> entry = it.next();
			String column = entry.getKey();
			Object value = entry.getValue();
			if(String.class.isAssignableFrom(value.getClass()) && !"?".equals(value)){
				sb.append(column).append(" = '").append(value).append("'");
			}else{
				sb.append(column).append(" = ").append(value);
			}
			if(it.hasNext()){
				sb.append(" and ");
			}
		}
	}
}
