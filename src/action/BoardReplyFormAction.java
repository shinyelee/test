package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// 답변글 쓰기 폼 출력 요청을 처리하는 Action 클래스.
public class BoardReplyFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		String nowPage = request.getParameter("page");
		// 답변글 등록 처리를 한 후 원래 보던 페이지로 되돌아 가야 하기 때문에 파라미터로 전송되어오는 페이지 번호 값을 얻어옴.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDetailService boardDetailService = new BoardDetailService();
		// 답변글을 달아줄 대상 글의 정보를 얻어옴.
		BoardBean article = boardDetailService.getArticle(board_num);
		// 글 정보와 페이지 번호를 request 영역에 속성으로 공유.
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/board/qna_board_reply.jsp");
		return forward;

	}
	
}