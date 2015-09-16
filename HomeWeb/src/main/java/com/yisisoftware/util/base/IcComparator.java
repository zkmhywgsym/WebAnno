package com.yisisoftware.util.base;

import java.util.Comparator;

import com.yisisoftware.entity.view.IcPicInfo;

public class IcComparator implements Comparator {


	@Override
	public int compare(Object obj1, Object obj2) {
		IcPicInfo ic0 = (IcPicInfo) obj1;
		IcPicInfo ic1 = (IcPicInfo) obj2;
		int flag = ic0.getTime().compareTo(ic1.getTime());
		return flag;
	}

}
