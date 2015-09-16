package com.yisisoftware.service.business.statistics.impl;

import org.springframework.stereotype.Service;

import com.yisisoftware.entity.EntityOrder;
import com.yisisoftware.service.base.impl.BaseServiceImpl;
import com.yisisoftware.service.business.statistics.EntityOrderServiceI;


@Service("entityOrderService")
public class EntityOrderServiceImpl extends BaseServiceImpl<EntityOrder> implements
		EntityOrderServiceI {

}
