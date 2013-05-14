package telekinesis.simpledao.test.caster.noncasting;

public class DefaultNoCastingRuleSetCreator {
	private DefaultNoCastingRuleSetCreator(){}
	
	public static NoCastingRuleSet create(){
		NoCastingRuleSet ruleSet = new NoCastingRuleSet();
		ruleSet.registerRule(new NoCastingBetweenBoxingType());
		ruleSet.registerRule(new NoCastingBetweenSameClass());
		ruleSet.registerRule(new NoCastingForNumericUpgrading());
		return ruleSet;
	}
}
