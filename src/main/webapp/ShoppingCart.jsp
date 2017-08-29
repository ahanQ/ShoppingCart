<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button#delete-item").click(function(){
			var item = $(this).val();
			$.ajax({
				url : "Delete",
				data : { id : item },
				success : function(result) {
					$("div#" + item).remove();
					if($("button#delete-item").size() == 0) {
						$("div#container").html("购物车为空");
					}
					alert("删除成功");
				}
			});
		});
		
		$("button#continue").click(function(){
			location.href = "Choose";
		});
		
		$("button#search-button").click(function(){
			var search_input = $("input#search-input").val();
			if(!search_input.trim()) {
				location.href = "ShoppingCart";
			}
			
			location.href = "Search?word=" + encodeURI(search_input.trim());
		});
		
	});
</script>
</head>
<body>
	<div id="search">
		<label>模糊搜索</label><input type="text" id="search-input" value="" /><button id="search-button">搜</button>
	</div>
	<c:if test="${empty display}">
		<c:out value="${message}"></c:out>
	</c:if>
	<c:if test="${!empty display}">
		<div id="container">
		<c:forEach items="${display}" var="g">
			<c:if test="${g != null}">
				<div id="${g.id}">
					<c:out value="${g.name}"></c:out><button id="delete-item" type="button" value="${g.id}">删除</button><br/>
				</div>
			</c:if>
		</c:forEach>
		</div>
	</c:if>
	<br/>
	<button id="continue" type="button">继续购物</button>
</body>
</html>