package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.model.BoardDTO;
import com.bbs.page.Criteria;
import com.bbs.page.ViewPage;
import com.bbs.service.BoardService;


@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
		
	@GetMapping("/")
	public String home() {

		return "home";
	}
	
	@GetMapping("/register")
	public String goRegister() {
		
		return "register";
	}
		
	@PostMapping("/register")
	public String register(BoardDTO dto) {
		//System.out.println(dto); 콘솔창에 값 들어오는지 확인		
		boardService.insert(dto);
		return "redirect:/"; // 리다이렉트의 슬러시 의미는 @GetMapping("/") 주소로 가라
	}
	@GetMapping("/boardList")
	public String boardList(Model model, Criteria cri) {
		
		List<BoardDTO> boardList = boardService.getListPaging(cri);
		model.addAttribute("boardList", boardList); 
		
		int total = boardService.getTotal();
		ViewPage vp = new ViewPage(cri, total);
		model.addAttribute("pageMaker", vp);
		
		return "boardList";
		
		//컨트롤러에서 서비스단으로 넘긴다.(모델이라는 객체 이용하면 뷰단으로 쉽게 빼낼 수 있음)
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("bno")String ubno) { 
		
		Long bno = Long.parseLong(ubno); //들어오는 스트링값이 롱값으로 변환됌
		boardService.delete(bno);
		
		
		return "redirect:/boardList"; //리다이렉트로 새로고침된 값을 뿌린다.
	}
	@GetMapping("/boardContent")
	public String boardContent(@RequestParam("bno")String ubno, Model model) {
		
		Long bno = Long.parseLong(ubno);
		BoardDTO dto = boardService.boardContent(bno);
		model.addAttribute("dto", dto);
		
		return "boardContent";
	}
	@GetMapping("/modifyForm")
	public String modifyForm(@RequestParam("bno")String ubno, Model model) {		
		
		Long bno = Long.parseLong(ubno);
		BoardDTO dto = boardService.boardContent(bno);
		model.addAttribute("dto", dto);

		
		return "modifyForm";
		
	}
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @RequestParam("bno") String bno ) {
		
		boardService.update(dto);
		return "redirect:/boardContent?bno="+bno;
	}
		
	

}
