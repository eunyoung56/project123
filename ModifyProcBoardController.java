package com.spring.springmvcAno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class ModifyProcBoardController {

	@RequestMapping(value = "/modifyProcBoard.do")
	public ModelAndView modifyProBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyProBoardController() ");
		
		//������ �����Ͱ� DO�� �ؼ� ������, DO�� �̿��ؼ� ����(������Ʈ...)
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}


////�ش� Ŭ������ (handlerMapping �̿� ��) controller�� ���Ǳ� ���ؼ���
////Controller �������̽��� �߰��� ��� �Ѵ�...
//public class ModifyProcBoardController implements Controller {
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("ModifyProcBoardController ==> ");
//		
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		// �츮�� ������Ʈ �� �����͸� ������ ������Ʈ(DO)�� ������
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setTitle(title);
//		bdo.setContent(content);
//		
//		// dao �̿��Ͽ� ������ �����Ͱ� ����� DO�� �̿��Ͽ� �����͸� ������Ʈ��
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		// ������ �����Ͱ� ���Ե� ��ü ����Ʈ �����͸� �ο��ֱ�
//		ModelAndView mav = new ModelAndView();
//		// !!!�߿�!!! redirect �� �̿��Ͽ� getBoardListController�� ȣ����(handlerMapping �̿��ؼ�).
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}
//
//}
