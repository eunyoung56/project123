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
		
		//수정된 데이터가 DO로 해서 들어오면, DO를 이용해서 저장(업데이트...)
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}


////해당 클래스가 (handlerMapping 이용 시) controller로 사용되기 위해서는
////Controller 인터페이스를 추가해 줘야 한다...
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
//		// 우리가 업데이트 할 데이터를 데이터 오브젝트(DO)에 저장함
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setTitle(title);
//		bdo.setContent(content);
//		
//		// dao 이용하여 수정된 데이터가 저장된 DO를 이용하여 데이터를 업데이트함
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		// 수정된 데이터가 포함된 전체 리스트 데이터를 부여주기
//		ModelAndView mav = new ModelAndView();
//		// !!!중요!!! redirect 를 이용하여 getBoardListController를 호출함(handlerMapping 이용해서).
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}
//
//}
