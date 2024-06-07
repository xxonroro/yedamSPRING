package com.yedam.app.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 젠체 조회: URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();

		model.addAttribute("boardList", list);

		return "board/boardList";
	}

	// 단건 조회: URI - boardInfo / parameter - BoardVO(쿼리 스트링) return - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(@ModelAttribute BoardVO boardVO, Model model) {
		BoardVO vo = boardService.boardInfo(boardVO);

		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / return board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}

	// 등록 - 처리 : URI - boardInsert / parameter - BoardVO(쿼리 스트링) return - 전체조회 다시 호출
	@PostMapping("boardInset")
	public String boardInsert(BoardVO boardVO) {
		int result = boardService.insertBoard(boardVO);

		if (result == 1) {
			return "redirect:boardInfo?bno=result";
		} else {
			return "redirect:boardList";
		}
	}

	// 수정 - 페이지 : uri - boardUpdate - parameter - BoardVO(쿼리 스트링) return
	// board/boardUpdate
//	@GetMapping("boardUpdate")
//	public String boardUpdateForm(BoardVO boardVO, Model model) {
//		BoardVO findBoardVO = boardService.boardInfo(boardVO);
//		
//		model.addAttribute("boardInfo",findBoardVO);
//		
//		return "board/boardUpdate";
//	}
	
	@GetMapping("boardUpdate")
	public ModelAndView boardUpdateForm(BoardVO boardVO) {
		ModelAndView modelAndView = new ModelAndView("board/boardUpdate");
		
		Map<String, Object> map = boardService.updateBoard(boardVO);
		
		modelAndView.addObject(map);
		
		return modelAndView;
	}

	// 수정 - 처리 : uri - boardUpdate parameter - BoardVO(JSON) return - 수정 결과 데이터(map)
	
	@PutMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdate(@RequestBody BoardVO boardVO) {
		Map<String, Object> map = boardService.updateBoard(boardVO);
		
		return map;
	}
	
	// 삭제 - 처리 : uri - boardDelete / parameter - Inter Return - 전체 조회 다시 호출
	@DeleteMapping("boardDelete")
	public String boardDelete(@RequestParam Integer boardNO) {
		boardService.deleteBoard(boardNO);
		
		return "redirect:boardList";
	}
}
