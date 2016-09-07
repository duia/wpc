package com.wpc.admin.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpc.admin.entity.User;
import com.wpc.admin.service.UserService;
import com.wpc.common.AjaxResult;
import com.wpc.common.DataTableResult;


/**
 * 
 * author wpc
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name=UserService.BEAN_ID)
	private UserService userService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String user(ModelMap model) {
		return "admin/user/user";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	@ResponseBody
	public DataTableResult<User> search(ModelMap model, HttpServletRequest request) {
		
		Integer orderColumn = Integer.valueOf(request.getParameter("order[0][column]"));
	    System.out.println("orderColumn:"+orderColumn);
	    //orderColumn = cols[Integer.parseInt(orderColumn)];
		
	    //获取Datatables发送的参数 必要
		Integer draw = Integer.valueOf(request.getParameter("draw"));//这个值作者会直接返回给前台
		System.out.println("draw:"+draw);
		//排序
		//String orderColumn = baseQuery.getOrder().get(0).getColumn();//[0]column'];//那一列排序，从0开始
		//$order_dir = $_GET['order']['0']['dir'];//ase desc 升序或者降序
		 
//		//拼接排序sql
//		$orderSql = "";
//		if(isset($order_column)){
//		    $i = intval($order_column);
//		    switch($i){
//		        case 0;$orderSql = " order by first_name ".$order_dir;break;
//		        case 1;$orderSql = " order by last_name ".$order_dir;break;
//		        case 2;$orderSql = " order by position ".$order_dir;break;
//		        case 3;$orderSql = " order by office ".$order_dir;break;
//		        case 4;$orderSql = " order by start_date ".$order_dir;break;
//		        case 5;$orderSql = " order by salary ".$order_dir;break;
//		        default;$orderSql = '';
//		    }
//		}
//		//搜索
//		$search = $_GET['search']['value'];//获取前台传过来的过滤条件
//		 
//		//分页
//		$start = $_GET['start'];//从多少开始
		Integer length = Integer.valueOf(request.getParameter("length"));
		System.out.println("length:"+length);
//		$length = $_GET['length'];//数据长度
//		$limitSql = '';
//		$limitFlag = isset($_GET['start']) && $length != -1 ;
//		if ($limitFlag ) {
//		    $limitSql = " LIMIT ".intval($start).", ".intval($length);
//		}
//		 
//		//定义查询数据总记录数sql
//		$sumSql = "SELECT count(id) as sum FROM DATATABLES_DEMO";
//		//条件过滤后记录数 必要
//		$recordsFiltered = 0;
//		//表的总记录数 必要
//		$recordsTotal = 0;
//		$recordsTotalResult = $db->query($sumSql);
//		while ($row = $recordsTotalResult->fetchArray(SQLITE3_ASSOC)) {
//		    $recordsTotal =  $row['sum'];
//		}
//		//定义过滤条件查询过滤后的记录数sql
//		$sumSqlWhere =" where first_name||last_name||position||office||start_date||salary LIKE '%".$search."%'";
//		if(strlen($search)>0){
//		    $recordsFilteredResult = $db->query($sumSql.$sumSqlWhere);
//		    while ($row = $recordsFilteredResult->fetchArray(SQLITE3_ASSOC)) {
//		        $recordsFiltered =  $row['sum'];
//		    }
//		}else{
//		    $recordsFiltered = $recordsTotal;
//		}
//		 
//		//query data
//		$totalResultSql = "SELECT first_name,last_name,position,office,start_date,salary FROM DATATABLES_DEMO";
//		$infos = array();
//		if(strlen($search)>0){
//		    //如果有搜索条件，按条件过滤找出记录
//		    $dataResult = $db->query($totalResultSql.$sumSqlWhere.$orderSql.$limitSql);
//		    while ($row = $dataResult->fetchArray(SQLITE3_ASSOC)) {
//		        $obj = array($row['first_name'], $row['last_name'], $row['position'], $row['office'], $row['start_date'], $row['salary']);
//		        array_push($infos,$obj);
//		    }
//		}else{
//		    //直接查询所有记录
//		    $dataResult = $db->query($totalResultSql.$orderSql.$limitSql);
//		    while ($row = $dataResult->fetchArray(SQLITE3_ASSOC)) {
//		        $obj = array($row['first_name'], $row['last_name'], $row['position'],$row['office'], $row['start_date'], $row['salary']);
//		        array_push($infos,$obj);
//		    }
//		}
//		 
//		/*
//		 * Output 包含的是必要的
//		 */
//		echo json_encode(array(
//		    "draw" => intval($draw),
//		    "recordsTotal" => intval($recordsTotal),
//		    "recordsFiltered" => intval($recordsFiltered),
//		    "data" => $infos
//		),JSON_UNESCAPED_UNICODE);
//		 
		 
		
		DataTableResult<User> dtr = new DataTableResult<User>();
		dtr.setDraw(draw);
		dtr.setRecordsTotal(57);
		dtr.setRecordsFiltered(57);
		List<User> list = new ArrayList<User>();
		User u = null;
		for (int i = 0; i < length; i++) {
			u = new User();
			u.setId(i);
			u.setUsername("admin"+i);
			u.setAccount("admin"+i);
			u.setPassword("123456");
			u.setAge((int)(Math.random()*50) + 1);
			u.setUpdateTime(new Date());
			list.add(u);
		}
		dtr.setData(list);
		return dtr;
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, User user) {
		AjaxResult responseJsonModel = new AjaxResult();
		if(user.getId()!=null && user.getId()!=0){
			userService.update(user);
		}else{
			userService.save(user);
		}
		return responseJsonModel;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(ModelMap model, Integer id) {
		AjaxResult responseJsonModel = new AjaxResult();
		userService.delete(id);
		return responseJsonModel;
	}
	
	

}
