package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.suggest.bean.Company;
import com.atguigu.suggest.dao.CompanyDao;
import com.google.gson.Gson;

public class QueryListTest {

	@Test
	public void test() {
		
		List<Company> queryList = CompanyDao.queryList("jQuery");
		for (Company company : queryList) {
			System.out.println(company);
		}
		
		//将查询结果List集合对象转换为JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(queryList);
		System.out.println(json);
		
	}

}
