package com.eosine.controller.business;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eosine.controller.BaseController;
import com.eosine.entity.business.EntityOrder;
import com.eosine.entity.business.view.EntityOrderView;
import com.eosine.service.business.EntityOrderServiceI;
import com.eosine.util.base.HqlFilter;

/**
 * 表单控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/entityOrderController")
public class EntityOrderController extends BaseController {

	@Autowired
	private EntityOrderServiceI entityOrderService;
	
	/**
	 * 添加表单
	 * 
	 * @return	返回true 添加成功 false 添加失败
	 */
	@ResponseBody
	@RequestMapping("/add")
	public String add(EntityOrder order){
		String result = "";
		try {
			
			entityOrderService.save(order);
			result = "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result ="false";
		}finally{
			return result;
		}
	}
	
	/**
	 * 添加表单
	 * 
	 * @return	
	 */
	@ResponseBody
	@RequestMapping("/findById")
	public EntityOrder query(String orderId){
		
		HqlFilter hqlFilter = new HqlFilter();
		
		hqlFilter.addFilter("QUERY_t#orderId_S_EQ",orderId);
		List<EntityOrder> list = this.entityOrderService.findByFilter(hqlFilter);
		
		return list.get(0);
		
	}
}
