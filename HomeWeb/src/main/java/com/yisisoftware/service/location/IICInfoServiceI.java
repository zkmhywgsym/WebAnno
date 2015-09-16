package com.yisisoftware.service.location;

import com.yisisoftware.entity.view.EntityICCard;
import com.yisisoftware.service.base.IBaseService;

public interface IICInfoServiceI extends IBaseService<EntityICCard> {

	public void saveFile(String imagePath, EntityICCard ic);

}
