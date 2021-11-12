package com.bbs.service;

import java.util.List;

import com.bbs.model.BoardDTO;
import com.bbs.page.Criteria;

public interface BoardService {
	
	public void insert(BoardDTO dto);
	public List<BoardDTO> list_all();
	public void delete(Long bno); //삭제는 결과값 받을게 없어서 void
	public BoardDTO boardContent(Long bno);
	public void update(BoardDTO dto);
	public List<BoardDTO> getListPaging(Criteria cri);
	public int getTotal();
	//서비스단에서 impl로 넘긴다.
			
}
