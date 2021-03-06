package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartQtyUpService;
import vo.ActionForward;

//장바구니 항목 수량 증가 요청을 처리하는 Action 클래스.
public class MdCartQtyUpAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 수량을 증가시킬 대상이 되는 장바구니 항목의 item 값을 파라미터 값으로 받음. 장바구니 항목의 식별자는 item 값을 사용.
		String item = request.getParameter("item");
		// 장바구니 항목의 수량을 증가시키는 비즈니스 로직을 처리하는 서비스 객체를 생성.
		MdCartQtyUpService mdCartQtyUpService = new MdCartQtyUpService();
		// 장바구니 항목의 수량을 증가시키는 메소드를 호출.
		mdCartQtyUpService.upCartQty(item,request);
		// 장바구니 항목의 수량을 증가시키는 요청 처리를 실행한 후 포워딩 정보를 ActionForward 객체로 생성.
		// 장바구니 항목의 수량 증가 처리를 한 후 장바구니 목록보기 요청을 다시 하기 위해 URL은 mdCartList.md로, 포워딩은 리다이렉트 방식으로 처리하기 위해 true로 지정.
		ActionForward forward = new ActionForward("mdCartList.md", true);
		
		return forward;
	}

}
