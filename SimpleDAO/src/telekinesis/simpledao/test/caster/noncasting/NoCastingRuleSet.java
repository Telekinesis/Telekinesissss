package telekinesis.simpledao.test.caster.noncasting;

import java.util.ArrayList;
import java.util.List;

public class NoCastingRuleSet {
	private List<NoCastingRule> ruleSet = new ArrayList<NoCastingRule>();
	
	public boolean noCastCheck(Class<?> inputType, Class<?> parameterType){
		for(NoCastingRule rule : ruleSet){
			if(rule.isCastNotNeeded(inputType, parameterType))
				return true;
		}
		return false;
	}
	
	public void registerRule(NoCastingRule rule){
		ruleSet.add(rule);
	}
}
