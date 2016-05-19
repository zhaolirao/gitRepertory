package com.atguigu.suggest.dao;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.suggest.bean.Company;

public class CompanyDao {
	
	public static final List<Company> COMPANY = new ArrayList<>();
	
	static {
		COMPANY.add(new Company(1, "中国银行尚硅谷分行"));
		COMPANY.add(new Company(2, "尚硅谷国际教育集团北京分部"));
		COMPANY.add(new Company(3, "硅谷世纪餐饮集团"));
		COMPANY.add(new Company(4, "尚硅谷教育科技研究中心"));
		COMPANY.add(new Company(5, "天津恒硅矿业"));
		COMPANY.add(new Company(6, "幽幽谷娱乐中心"));
		COMPANY.add(new Company(7, "俊尚美食城"));
		COMPANY.add(new Company(8, "中国硅谷影视城"));
		COMPANY.add(new Company(9, "尚硅谷图书中心"));
		COMPANY.add(new Company(10, "尚硅谷营销总部"));
		COMPANY.add(new Company(11, "Ajax学习指南"));
		COMPANY.add(new Company(12, "在Web项目中使用Ajax"));
		COMPANY.add(new Company(13, "Ajax异步交互"));
		COMPANY.add(new Company(14, "透析Ajax对象"));
		COMPANY.add(new Company(15, "详解Ajax异步交互技术"));
		COMPANY.add(new Company(16, "jQuery技术内幕"));
		COMPANY.add(new Company(17, "深度理解jQuery框架结构"));
		COMPANY.add(new Company(18, "jQuery中的JavaScript精华"));
		COMPANY.add(new Company(19, "增宪至>>>大神"));
		COMPANY.add(new Company(20, "乐狗搜索，明日之星"));
		COMPANY.add(new Company(21, "乐狗搜索 拳打google，脚踢百度"));
	}
	
	public static List<Company> queryList(String queryStr) {
		queryStr = queryStr.toLowerCase();
		List<Company> companyList = new ArrayList<>();
		
		for (Company company : COMPANY) {
			String companyName = company.getCompanyName().toLowerCase();
			boolean contains = companyName.contains(queryStr);
			if(contains) {
				companyList.add(company);
			}
		}
		
		return companyList;
	}
	
}
