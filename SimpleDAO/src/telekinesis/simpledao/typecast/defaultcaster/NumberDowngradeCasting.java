package telekinesis.simpledao.typecast.defaultcaster;

import telekinesis.simpledao.typecast.CasterMethod;

public class NumberDowngradeCasting {
	@CasterMethod
	public Long BigDoubleToBigLong(Double d){
		return Math.round(d);
	}
	
	@CasterMethod
	public long BigDoubleToLong(Double d){
		return Math.round(d);
	}
	
	@CasterMethod
	public Float BigDoubleToBigFloat(Double d){
		return d.floatValue();
	}
	
	@CasterMethod
	public float BigDoubleToFloat(Double d){
		return d.floatValue();
	}
	
	@CasterMethod
	public Integer BigDoubleToBigInt(Double d){
		return d.intValue();
	}
	
	@CasterMethod
	public int BigDoubleToInt(Double d){
		return d.intValue();
	}
	
	@CasterMethod
	public Short BigDoubleToBigShort(Double d){
		return d.shortValue();
	}
	
	@CasterMethod
	public short BigDoubleToShort(Double d){
		return d.shortValue();
	}
	
	@CasterMethod
	public Byte BigDoubleToBigByte(Double d){
		return d.byteValue();
	}
	
	@CasterMethod
	public byte BigDoubleToByte(Double d){
		return d.byteValue();
	}
	
	@CasterMethod
	public Float BigLongToBigFloat(Long l){
		return l.floatValue();
	}
	
	@CasterMethod
	public float BigLongToFloat(Long l){
		return l.floatValue();
	}
	
	@CasterMethod
	public Integer BigLongToBigInteger(Long l){
		return l.intValue();
	}
	
	@CasterMethod
	public int BigLongToInteger(Long l){
		return l.intValue();
	}
	
	@CasterMethod
	public Short BigLongToBigShort(Long l){
		return l.shortValue();
	}
	
	@CasterMethod
	public short BigLongToShort(Long l){
		return l.shortValue();
	}
	
	@CasterMethod
	public Byte BigLongToBigByte(Long l){
		return l.byteValue();
	}
	
	@CasterMethod
	public byte BigLongToByte(Long l){
		return l.byteValue();
	}
	
	@CasterMethod
	public Integer BigFloatToBigInteger(Float f){
		return f.intValue();
	}
	
	@CasterMethod
	public int BigFloatToInteger(Float f){
		return f.intValue();
	}
	
	@CasterMethod
	public Short BigFloatToBigShort(Float f){
		return f.shortValue();
	}
	
	@CasterMethod
	public short BigFloatToShort(Float f){
		return f.shortValue();
	}
	
	@CasterMethod
	public Byte BigFloatToBigByte(Float f){
		return f.byteValue();
	}
	
	@CasterMethod
	public byte BigFloatToByte(Float f){
		return f.byteValue();
	}
	
	@CasterMethod
	public Short BigIntegerToBigShort(Integer i){
		return i.shortValue();
	}
	
	@CasterMethod
	public short BigIntegerToShort(Integer i){
		return i.shortValue();
	}
	
	@CasterMethod
	public Byte BigIntegerToBigByte(Integer i){
		return i.byteValue();
	}
	
	@CasterMethod
	public byte BigIntegerToByte(Integer i){
		return i.byteValue();
	}
	
	@CasterMethod
	public Byte BigShortToBigByte(Short s){
		return s.byteValue();
	}
	
	@CasterMethod
	public byte BigShortToByte(Short s){
		return s.byteValue();
	}
}
