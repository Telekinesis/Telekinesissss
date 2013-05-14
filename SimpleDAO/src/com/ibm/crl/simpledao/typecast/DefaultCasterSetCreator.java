package com.ibm.crl.simpledao.typecast;

import com.ibm.crl.simpledao.typecast.defaultcaster.NumberDowngradeCasting;
import com.ibm.crl.simpledao.typecast.defaultcaster.NumberUpgradeCasting;

public class DefaultCasterSetCreator {
	private DefaultCasterSetCreator(){}
	
	public static CasterTable create(){
		CasterTable casters = new CasterTable();
		casters.registerCaster(new NumberUpgradeCasting());
		casters.registerCaster(new NumberDowngradeCasting());
		return casters;
	}
}
