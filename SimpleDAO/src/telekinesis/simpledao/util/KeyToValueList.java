package telekinesis.simpledao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KeyToValueList<KEY_TYPE, VALUE_TYPE> {
	private Map<KEY_TYPE, List<VALUE_TYPE>> map = new HashMap<KEY_TYPE, List<VALUE_TYPE>>();
	
	public static <KEY_TYPE, VALUE_TYPE> KeyToValueList<KEY_TYPE, VALUE_TYPE> createHashMap(){
		KeyToValueList<KEY_TYPE, VALUE_TYPE> object = new KeyToValueList<KEY_TYPE, VALUE_TYPE>();
		object.map = new HashMap<KEY_TYPE, List<VALUE_TYPE>>();
		return object;
	}
	
	public static <KEY_TYPE, VALUE_TYPE> KeyToValueList<KEY_TYPE, VALUE_TYPE> createTreeMap(){
		KeyToValueList<KEY_TYPE, VALUE_TYPE> object = new KeyToValueList<KEY_TYPE, VALUE_TYPE>();
		object.map = new TreeMap<KEY_TYPE, List<VALUE_TYPE>>();
		return object;
	}
	
	public void put(KEY_TYPE key, VALUE_TYPE value){
		List<VALUE_TYPE> values = map.get(key);
		if(values == null){
			values = new ArrayList<VALUE_TYPE>();
			map.put(key, values);
		}
		values.add(value);
	}
	
	public void putMultipleValue(KEY_TYPE key, VALUE_TYPE... values){
		for (VALUE_TYPE v : values)
			put(key, v);
	}
	
	public List<VALUE_TYPE> get(KEY_TYPE key){
		List<VALUE_TYPE> result = map.get(key);
		if(result == null)
			return new ArrayList<VALUE_TYPE>();
		return result;
	}
	
	public void remove(KEY_TYPE key, VALUE_TYPE value){
		List<VALUE_TYPE> values = map.get(key);
		if(values == null)
			return;
		removeValue(values, value);
		if(values.isEmpty())
			map.remove(key);
	}
	
	private void removeValue(List<VALUE_TYPE> values, VALUE_TYPE valueToRemove){
		for(int i = 0; i < values.size(); i++){
			VALUE_TYPE v = values.get(i);
			if(v.equals(valueToRemove)){
				values.remove(i);
				i--;
			}
		}
	}
	
	public Set<KEY_TYPE> keySet(){
		return map.keySet();
	}
	
	public int countEntries(){
		int count = 0;
		for(KEY_TYPE key : map.keySet()){
			List<VALUE_TYPE> values = map.get(key);
			count += values.size();
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(KEY_TYPE key : map.keySet()){
			buffer.append(key);
			buffer.append("\n");
			buffer.append(map.get(key));
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
}