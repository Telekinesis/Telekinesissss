package com.ibm.crl.simpledao.resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ResultSetReader {
	private ResultSetReader(){}
	
	public static Object readByIndex(ResultSet result, int index, int dataType) throws SQLException{
		if(dataType == Types.BIGINT){
			return result.getLong(index);
		}else if(dataType == Types.BOOLEAN){
			return result.getBoolean(index);
		}else if(dataType == Types.DATE){
			return result.getDate(index);
		}else if(dataType == Types.DECIMAL){
			return result.getBigDecimal(index);
		}else if(dataType == Types.DOUBLE){
			return result.getDouble(index);
		}else if(dataType == Types.FLOAT){
			return result.getFloat(index);
		}else if(dataType == Types.INTEGER){
			return result.getInt(index);
		}else if(dataType == Types.LONGNVARCHAR){
			return result.getString(index);
		}else if(dataType == Types.LONGVARCHAR){
			return result.getString(index);
		}else if(dataType == Types.NVARCHAR){
			return result.getString(index);
		}else if(dataType == Types.REAL){
			return result.getDouble(index);
		}else if(dataType == Types.SMALLINT){
			return result.getShort(index);
		}else if(dataType == Types.TIME){
			return result.getTime(index);
		}else if(dataType == Types.TIMESTAMP){
			return result.getTimestamp(index);
		}else if(dataType == Types.TINYINT){
			return result.getByte(index);
		}else if(dataType == Types.VARCHAR){
			return result.getString(index);
		}
		throw new UnsupportedReadTypeException(dataType);
	}
	
	public static Object readByLabel(ResultSet result, String label, int dataType) throws SQLException{
		if(dataType == Types.BIGINT){
			return result.getLong(label);
		}else if(dataType == Types.BOOLEAN){
			return result.getBoolean(label);
		}else if(dataType == Types.DATE){
			return result.getDate(label);
		}else if(dataType == Types.DECIMAL){
			return result.getBigDecimal(label);
		}else if(dataType == Types.DOUBLE){
			return result.getDouble(label);
		}else if(dataType == Types.FLOAT){
			return result.getFloat(label);
		}else if(dataType == Types.INTEGER){
			return result.getInt(label);
		}else if(dataType == Types.LONGNVARCHAR){
			return result.getString(label);
		}else if(dataType == Types.LONGVARCHAR){
			return result.getString(label);
		}else if(dataType == Types.NVARCHAR){
			return result.getString(label);
		}else if(dataType == Types.REAL){
			return result.getDouble(label);
		}else if(dataType == Types.SMALLINT){
			return result.getShort(label);
		}else if(dataType == Types.TIME){
			return result.getTime(label);
		}else if(dataType == Types.TIMESTAMP){
			return result.getTimestamp(label);
		}else if(dataType == Types.TINYINT){
			return result.getByte(label);
		}else if(dataType == Types.VARCHAR){
			return result.getString(label);
		}
		throw new UnsupportedReadTypeException(dataType);
	}
}
