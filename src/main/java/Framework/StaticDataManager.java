package Framework;

import java.util.HashMap;

 class StaticDataManager {
	static HashMap<String, Object> staticData;
	
	public StaticDataManager() {
		staticData  = new HashMap<String, Object>();
	}
	
	public static Object getData(String key) {
		return staticData.get(key);
	}
	
	public static void putData(String key , Object val) {
		
		staticData.put(key, val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
