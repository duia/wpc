package ${basePackage}.${moduleName}.${actionPackage};
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import ${basePackage}.${moduleName}.${entityPackage}.${entityCamelName};
import ${basePackage}.${moduleName}.${servicePackage}.${entityCamelName}Service;
import com.wpc.common.AjaxResult;
import com.wpc.common.datatables.DataTablesRequest;
import com.wpc.common.datatables.DataTablesResponse;

<#if subTables??>
	<#list subTables as sub>
import ${basePackage}.${moduleName}.${entityPackage}.${sub.entityCamelName};
	</#list>
</#if>

/**
 * ${remark!} 控制层
 * author wpc
 */
@Controller
@RequestMapping("/${entityLowerName}")
public class ${entityCamelName}Controller {
	
	@Resource(name=${entityCamelName}Service.BEAN_ID)
	private ${entityCamelName}Service ${entityName}Service;
	
	<#if module.persistance=="mybatis">
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String ${entityName}(ModelMap model) {
		return "${module.name}/${entityLowerName}/${tableName}";
	}
	
	/**
	 *
	 * 分页查询列表
	 */
	@RequestMapping(value="/searchPage", method=RequestMethod.POST)
	@ResponseBody
	public DataTablesResponse<${entityCamelName}> searchPage(ModelMap model, HttpServletRequest request, @RequestBody DataTablesRequest query) {
		return ${entityName}Service.searchPage(query);
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, ${entityCamelName} ${entityName}) {
		AjaxResult ajaxResult = new AjaxResult();
		if(${entityName}.get${primaryCamelProperty}()!=null && ${entityName}.get${primaryCamelProperty}()!=0){
			${entityName}Service.update(${entityName});
		}else{
			${entityName}Service.save(${entityName});
		}
		return ajaxResult;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(ModelMap model, ${primaryPropertyType} ${primaryKey}) {
		AjaxResult ajaxResult = new AjaxResult();
		${entityName}Service.delete(${primaryKey});
		return ajaxResult;
	}
	
	</#if>
	
	<#if module.persistance!="mybatis">
	
	<#if subTables??>
		<#list subTables as sub>
	@Resource(name="${sub.entityName}Action")
	private ${sub.entityCamelName}Action ${sub.entityName}Action;
		</#list>
	</#if>
	
	/**
	 * 查询${remark!}
	 * @param params 参数列表
	 * @param page
	 */
	@RequestMapping(value = "/list${entityCamelName}")
	public ModelAndView load${entityCamelName}List(HttpServletRequest req,@RequestParam(value="page",defaultValue="1",required=false) int page){
		ModelAndView mv = new ModelAndView("/${moduleName}/list${entityCamelName}");
		Pagination<${entityCamelName}> paging = new Pagination<${entityCamelName}>(10, page);
		Map<String,Object> params = new HashMap<String, Object>();
		${entityName}Service.load${entityCamelName}List(paging,params);
		mv.addObject("paging",paging);
		return mv;
	}
	
	/**
	 * 显示${remark!}详情
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value = "/show${entityCamelName}")
	public ModelAndView load${entityName}(${primaryPropertyType} ${primaryProperty}){
		ModelAndView mv = new ModelAndView("/${moduleName}/show${entityCamelName}");
		${entityCamelName} ${entityName} = ${entityName}Service.loadById(${primaryProperty});
		mv.addObject("${entityName}",${entityName});
		return mv;
	}
	
	@RequestMapping(value="/toAdd${entityCamelName}")
	public String toAdd${entityCamelName}(){
		return "/${moduleName}/add${entityCamelName}";
	}
	
	/**
	 * 保存${remark!}详情
	 * @param ${entityName}
	 * @return
	 */
	@RequestMapping(value = "/save${entityCamelName}",method=RequestMethod.POST)
	public ModelAndView save${entityCamelName}(${entityCamelName} ${entityName}){
		ModelAndView mv = new ModelAndView("redirect:/${moduleName}/list${entityCamelName}");
		${entityName}Service.save${entityCamelName}(${entityName});
		return mv;
	}
	

	@RequestMapping(value="/toEdit${entityCamelName}")
	public ModelAndView toEdit${entityCamelName}(${primaryPropertyType} ${primaryProperty}){
		ModelAndView mv = new ModelAndView("/${moduleName}/edit${entityCamelName}");
		${entityCamelName} ${entityName}= ${entityName}Service.loadById(${primaryProperty});
		mv.addObject("${entityName}",${entityName});
		return mv;
	}
	
	/**
	 * 保存修改的${remark!}
	 * @param ${entityCamelName}
	 * @return
	 */
	@RequestMapping(value = "/update${entityCamelName}",method=RequestMethod.POST)
	public ModelAndView update${entityCamelName}(${entityCamelName} ${entityName}){
		ModelAndView mv = new ModelAndView("redirect:/${moduleName}/list${entityCamelName}");
		${entityName}Service.update${entityCamelName}(${entityName});
		return mv;
	}
	/**
	 * 删除${remark!}
	 * @param ${entityCamelName}
	 * @return
	 */
	@RequestMapping(value = "/remove${entityCamelName}",method=RequestMethod.POST)
	public ModelAndView remove${entityCamelName}(HttpServletRequest req,${entityCamelName} ${entityName}){
		ModelAndView mv = new ModelAndView("redirect:/${moduleName}/list${entityCamelName}");
		${entityName}Service.remove${entityCamelName}(${entityName});
		return mv;
	}
	
	</#if>

}
