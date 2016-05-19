package com.atguigu.suggest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.suggest.bean.Company;
import com.atguigu.suggest.dao.CompanyDao;
import com.google.gson.Gson;

public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.从请求参数中获取查询关键字
		String queryStr = request.getParameter("queryStr");
		
		//2.根据查询关键字获取查询结果
		List<Company> queryList = CompanyDao.queryList(queryStr);
		
		//3.将查询结果转换为JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(queryList);
		
		//4.将JSON字符串作为响应数据返回
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		
	}

}
