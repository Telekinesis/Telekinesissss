package telekinesis.simpledao.typecast;

import telekinesis.simpledao.typecast.defaultcaster.NumberDowngradeCasting;
import telekinesis.simpledao.typecast.defaultcaster.NumberUpgradeCasting;

public class DefaultCasterSetCreator {
	private DefaultCasterSetCreator(){}
	
	public static CasterTable create(){
		CasterTable casters = new CasterTable();
		casters.registerCaster(new NumberUpgradeCasting());
		casters.registerCaster(new NumberDowngradeCasting());
		return casters;
	}
}
