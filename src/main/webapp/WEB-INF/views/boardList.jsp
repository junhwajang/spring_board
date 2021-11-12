<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Board List</title>
</head>
<style>
/* 현재 페이지 표시 배경색 두기 */
.active{
	background-color: #cdd5ec;
}
</style>
<body>
<!--뷰단에서 컨트롤러로 넘긴다  -->
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			
		</tr>
		
		<c:forEach var="boardList" items="${boardList}">
			<tr>
				<td>${boardList.bno}</td>
				<td><a href="/boardContent?bno=${boardList.bno}">${boardList.btitle}</a></td>
				<td>${boardList.bwriter}</td>
				<td>${boardList.bregdate}</td>
				<%-- <td><a href="/delete?bno=${boardList.bno}">삭제하기</a></td> --%> <!-- 파라미터값 bno를 컨트롤러단으로 넘겨준다  -->
			</tr>
		</c:forEach> 
	</table>
	

	<div class="pageInfo">
		<c:if test="${pageMaker.prev}">
			<li class="pageInfo_btn prev"> <a href="${pageMaker.startPage - 1}">이전</a> </li>	
		</c:if>
		
		<!-- 각 번호 페이지 버튼 -->
		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<!-- 현재 페이지 표시 배경색 두기-->
			<li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"> <a href="${num}">${num}</a> </li>			
		</c:forEach>	
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${pageMaker.next}">
			<li class="pageInfo_btn next"> <a href="${pageMaker.endPage + 1}">다음</a> </li>	
		</c:if>
			
	</div>
			
	<form method="get" class="moveForm">	
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	</form>
	
	
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(function() {
		
		var moveForm = $(".moveForm"); //선택자
		
		$(".pageInfo a").on("click", function(e) {			
			e.preventDefault();
			
			moveForm.find("input[name = 'pageNum']").val($(this).attr("href"));
			moveForm.attr("action", "/boardList");
			moveForm.submit();			
		});
		
	/* 	$(".move").on("click", function name(e) {
			e.preventDefault();
			
			moveForm.append("<input type = 'hidden' name = 'bno' value='"+ $(this).attr("href")+"'>");
			moveForm.attr("action", "/boardContent");
			moveForm.submit();
			
		}); */
		
		
	})

</script>

</body>
</html>
