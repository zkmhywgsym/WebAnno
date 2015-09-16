package com.yisisoftware.service.business.inventory.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yisisoftware.entity.WbWeight;
import com.yisisoftware.service.base.impl.BaseServiceImpl;
import com.yisisoftware.service.business.inventory.WbWeightInfoServiceI;
import com.yisisoftware.util.base.HqlFilter;

@Service("wbWeightInfo")
public class WbWeightInfoServiceImpl extends BaseServiceImpl<WbWeight>
		implements WbWeightInfoServiceI {

}
