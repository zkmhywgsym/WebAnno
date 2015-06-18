package com.eosine.service.business.impl;

import org.springframework.stereotype.Service;

import com.eosine.dao.base.impl.BaseDaoImpl;
import com.eosine.entity.business.EntityOrder;
import com.eosine.service.business.EntityOrderServiceI;
import com.eosine.service.impl.BaseServiceImpl;

@Service("entityOrderService")
public class EntityOrderServiceImpl extends BaseServiceImpl<EntityOrder> implements
		EntityOrderServiceI {

}
