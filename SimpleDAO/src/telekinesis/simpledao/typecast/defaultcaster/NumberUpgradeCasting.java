package telekinesis.simpledao.typecast.defaultcaster;

import telekinesis.simpledao.typecast.CasterMethod;

public class NumberUpgradeCasting {
	@CasterMethod
	public Double BigByteToBigDouble(Byte b){
		return b.doubleValue();
	}
	
	@CasterMethod
	public double BigByteToDouble(Byte b){
		return b.doubleValue();
	}
	
	@CasterMethod
	public Long BigByteToBigLong(Byte b){
		return b.longValue();
	}
	
	@CasterMethod
	public long BigByteToLong(Byte b){
		return b.longValue();
	}
	
	@CasterMethod
	public Float BigByteToBigFloat(Byte b){
		return b.floatValue();
	}
	
	@CasterMethod
	public float BigByteToFloat(Byte b){
		return b.floatValue();
	}
	
	@CasterMethod
	public Integer BigByteToBigInteger(Byte b){
		return b.intValue();
	}
	
	@CasterMethod
	public int BigByteToInteger(Byte b){
		return b.intValue();
	}
	
	@CasterMethod
	public Short BigByteToBigShort(Byte b){
		return b.shortValue();
	}
	
	@CasterMethod
	public short BigByteToShort(Byte b){
		return b.shortValue();
	}
	
	@CasterMethod
	public Double BigShortToBigDouble(Short s){
		return s.doubleValue();
	}
	
	@CasterMethod
	public double BigShortToDouble(Short s){
		return s.doubleValue();
	}
	
	@CasterMethod
	public Long BigShortToBigLong(Short s){
		return s.longValue();
	}
	
	@CasterMethod
	public long BigShortToLong(Short s){
		return s.longValue();
	}
	
	@CasterMethod
	public Float BigShortToBigFloat(Short s){
		return s.floatValue();
	}
	
	@CasterMethod
	public float BigShortToFloat(Short s){
		return s.floatValue();
	}
	
	@CasterMethod
	public Integer BigShortToBigInteger(Short s){
		return s.intValue();
	}
	
	@CasterMethod
	public int BigShortToInteger(Short s){
		return s.intValue();
	}
	
	@CasterMethod
	public Double BigIntegerToBigDouble(Integer i){
		return i.doubleValue();
	}
	
	@CasterMethod
	public double BigIntegerToDouble(Integer i){
		return i.doubleValue();
	}
	
	@CasterMethod
	public Long BigIntegerToBigLong(Integer i){
		return i.longValue();
	}
	
	@CasterMethod
	public long BigIntegerToLong(Integer i){
		return i.longValue();
	}
	
	@CasterMethod
	public Float BigIntegerToBigFloat(Integer i){
		return i.floatValue();
	}
	
	@CasterMethod
	public float BigIntegerToFloat(Integer i){
		return i.floatValue();
	}
	
	@CasterMethod
	public Double BigFloatToBigLong(Float f){
		return f.doubleValue();
	}
	
	@CasterMethod
	public double BigFloatToDouble(Float f){
		return f.doubleValue();
	}
	
	@CasterMethod
	public Double BigLongToBigDouble(Long l){
		return l.doubleValue();
	}
	
	@CasterMethod
	public double BigLongToDouble(Long l){
		return l.doubleValue();
	}
}
