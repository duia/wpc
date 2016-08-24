package ${basePackage}.${moduleName}.${servicePackage};

import ${basePackage}.${moduleName}.${entityPackage}.${entityCamelName};
import ${basePackage}.common.BaseService;

/**
 * ${remark!}操作相关
 * author wpc
 */
public interface ${entityCamelName}Service extends BaseService<${entityCamelName}, ${primaryPropertyType}> {
	
	public final static String BEAN_ID="${entityName}Service";
	
	<#if module.persistance!="mybatis">
	
	/**
	 * 新增保存${remark!}
	 * @param ${entityName}
	 */
	void save${entityCamelName}(${entityCamelName} ${entityName});
	
	/**
	 * 修改${remark!}
	 * @param ${entityName}
	 */
	void update${entityCamelName}(${entityCamelName} ${entityName});

	/**
	 * 删除${remark!}
	 * @param ${entityName}
	 */
	void remove${entityCamelName}(${entityCamelName} ${entityName});
	
	/**
	 * 根据编号查询${remark!}细信息
	 * @param ${primaryProperty}
	 * @return
	 */
	${entityCamelName} loadById(${primaryPropertyType} ${primaryProperty});
	
	/**
	 * 根据不同条件组合查询${remark!}，可分页查询
	 * @param page
	 * @param 
	 */
	void load${entityCamelName}List(Pagination<${entityCamelName}> page,Map<String,Object> params);
	
	</#if>

}
