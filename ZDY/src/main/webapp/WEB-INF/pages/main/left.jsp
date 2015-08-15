<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/util/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>  
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});	
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能列表</div>
    <dl class="leftmenu">
	    <c:forEach items="${mainlist}" var="mainmenu" >
		    <dd>
			    <div class="title">
			    	<span><img src="${pageContext.request.contextPath }/util/images/leftico01.png" /></span>${mainmenu.name }
			    </div>
		    	<ul class="menuson">
					<c:forEach items="${caselist }" var="casemenu">
							<c:if test="${mainmenu.id == casemenu.pid }">
								<li><cite></cite><a href="${casemenu.url }" target="rightFrame">${casemenu.name }</a><i></i></li>
							</c:if>
					</c:forEach>
		        </ul>    
		    </dd>
	    </c:forEach>
    </dl>
</body>
</html>
