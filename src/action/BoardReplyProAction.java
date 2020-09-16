/*

package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action {
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		BoardBean article = new BoardBean();
		// �亯�� �ۼ� ������ �ۼ��� �Ķ���� �����͵��� ���۹޾� BoardBean ��ü�� �Ӽ� ������ ����.
		article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setBoard_name(request.getParameter("board_name"));
		article.setBoard_pass(request.getParameter("board_subject"));
		article.setBoard_content(request.getParameter("board_content"));
		article.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		article.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		article.setBoard_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		// �亯�� ��� �۾��� �ϴ� �޼ҵ带 ȣ��.
		BoardReplyProService boardReplyProService = new BoardReplyProService();
		boolean isReplySuccess = boardReplyProService.replyArticle(article);
		
		if(isReplySuccess) { // �亯�� ��� �۾��� �������� �� �� ��� ���⸦ �ٽ� ��û.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo?page=" + nowPage);
		}
		else { // �亯�� ��� �۾��� �������� �� �ڹٽ�ũ��Ʈ�� ��� â�� ����ϰ� ���� �������� �ǵ��ư��� ó��.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�������');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;

	}

}

*/