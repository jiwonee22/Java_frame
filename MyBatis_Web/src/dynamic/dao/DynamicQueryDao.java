package dynamic.dao;

import java.util.HashMap;
import java.util.List;

import dto.Emp;

public interface DynamicQueryDao {
	
	public List<HashMap<String, Object>> select1();

	public List<HashMap<String, Object>> select2(String ename);

	public List<HashMap<String, Object>> select3(Emp emp);
	
	public List<HashMap<String, Object>> select4(HashMap<String, Object> param);
	
	
}
