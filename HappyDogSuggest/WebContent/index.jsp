<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乐狗搜索</title>
<link rel="stylesheet" type="text/css" href="style/css.css" />
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	window.onload = function(){
		var showTimeEle = document.getElementById("time");
		showTime();
		
		function showTime (){
			showTimeEle.innerHTML = new Date().toLocaleString();
			setTimeout(showTime,1000);
		}
	}
	
	$(function(){
		//获得焦点函数，鼠标点击输入框
		$("#query").focus(function(){
			//获取输入框内容，trim()去除空格
			var content = $.trim(this.value);
			if(content == this.defaultValue){
				this.value = "";  
			}		
		}).blur(function(){//失去焦点，鼠标点击输入框以外
 			var content = $.trim(this.value)
			if(content == ""){
				this.value = this.defaultValue;
				//resultDiv关闭，slideUp(int)关闭div
				$("#resultDiv").slideUp(300);
			}
		}) 
		//按下指定键后的响应函数keypress
		$("#query").keypress(function(event){
			//event事件对象
			//event.keyCode按键的ASCII码值
			if(event.keyCode == 13){
				
	 			var keyWords = $.trim(this.value)
	 			if(keyWords == ""){
					$("#resultDiv").empty()
								   .slideUp(200)
								   .slideDown(100)
	 							   .append("<div>没有相关查询结果</div>");
	 			}else{
					$("#resultDiv").slideUp(300,function(){
						//发送post请求
						$.post("QueryServlet",{"queryStr":keyWords},function(data){
							//清空resultDiv内容
							$("#resultDiv").empty();
							//数据长度等于0，表示没有相应的结果
							if(data.length == 0){
								//append("元素节点")向div中添加内容
								$("#resultDiv").append("<div>没有相关查询结果</div>");
							}else{
								//遍历json数组，得到每一个json对象
								for(var i = 0;i < data.length;i++){
									$("#resultDiv").append('<div><a href="#">'+data[i].companyName+"</a></dav>");
								}
							}
							//打开resultDiv，显示查询到的内容
							$("#resultDiv").slideDown(100);
						},"json")
					})
	 			}
			}
		})
	})  

</script>
</head>
<body>
	<p id="time" ></p>
	<img src="image/happydog.jpg" />

	<input type="text" id="query" placeholder="请输入内容，按回车搜索" />
	
	<div id="resultDiv"></div>
	<div class="welcome" align="center">欢迎光临乐狗搜索，愿竭诚为您服务</div>

</body>
</html>