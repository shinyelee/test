<!-- 삭제 요청 시 글의 비밀번호를 입력하는 화면을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	// 삭제 대상이 되는 글의 번호와 삭제 요청을 하기 전에 보고 있던 페이지 번호를 request 영역에서 얻어옴.
	// 이 값들은 BoardFrontController 클래스의
	// else if(command.equals("/boardDeleteForm.bo")) {
	//	   String nowPage = request.getParameter("page");
	//	   request.setAttribute("page", nowPage);
	//	   int board_num = Integer.parseInt(request.getParameter("board_num"));
	//	   request.setAttribute("board_num", board_num);
	//	   forward = new ActionForward();
	//	   forward.setPath("/board/qna_board_delete.jsp");
	//	   }
	// 부분에서 공유되어 있다.
	int board_num = (Integer)request.getAttribute("board_num");
    String nowPage = (String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>QnA 게시판</title>
<style>

#passForm {
	width: 500px;
	border: 1px solid gray;
	margin: auto;
	text-align: center;
}

div {
	padding: 2em;
}
	
</style>
</head>
<body>
	<section id="passForm">
		<h2>비밀번호 확인</h2>
		<form name="deleteForm" action="boardDeletePro.bo?board_num=<%=board_num %>" method="post">
			<input type="hidden" name="page" value="<%=nowPage %>"/>
			<div>비밀번호
				<input name="BOARD_PASS" type="password" placeholder="비밀번호를 입력하세요."><br><br>
				<input type="button" value="뒤로" onclick="history.back()">
				<input type="submit" value="삭제">
			</div>
		</form>
	</section>
</body>
</html>