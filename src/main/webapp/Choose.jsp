<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button#put-to-cart").click(function(){
			if(!$("input.goods-item:checked").size()){
				alert("亲，选一样喜欢的带回家吧！");
			} else {
				var items = new Array();
				$("input.goods-item:checked").each(function(){
					items.push($(this).val()); 
				});
				$.ajax({
					url : "Put2Cart",
					traditional : true,
					data : { id : items },
					success : function(result){
						alert("成功加入购物车");
					}
				});
			}
		});
		$("button#my-shopping-cart").click(function(){
			location.href = "ShoppingCart";
		});
		$("input.goods-item").click(function(){
			if(!$(this).is(":checked")) {
				return;
			}
			var goods_name = $("label#" + $(this).val()).html();
			$("div#message").html("感谢选择" + goods_name);
		});
	});
</script>
</head>
	<body>
		<div id="message">
		</div>
	
		<c:forEach items="${goods}" var="g">
			<input class="goods-item" type="checkbox" name="item" value="${g.id}" /><label id="${g.id}"><c:out value="${g.name}"></c:out></label><br/>
		</c:forEach>
		<button id="put-to-cart" type="button">加入购物车</button><button id="my-shopping-cart" type="button">我的购物车</button>
	</body>
</html>