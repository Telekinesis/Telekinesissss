package telekinesis.simpledao.test.caster.noncasting;

public class NoCastingBetweenSameClass implements NoCastingRule {

	@Override
	public boolean isCastNotNeeded(Class<?> inputType, Class<?> parameterType) {
		return inputType == parameterType;
	}

}
