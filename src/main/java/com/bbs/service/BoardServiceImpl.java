package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.BoardMapper;
import com.bbs.model.BoardDTO;
import com.bbs.page.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void insert(BoardDTO dto) {
		
		mapper.insert(dto);				
	}
	@Override
	public List<BoardDTO> list_all(){
		return mapper.list_all();
		
		//impl에서 xml로 넘긴다.(mapper 자바도 가서 만들어줘야함)
	}
	@Override
	public void delete(Long bno) {
		mapper.delete(bno);
		
	}
	@Override
	public BoardDTO boardContent(Long bno) {
	
		return mapper.boardContent(bno);

		
	}

	@Override
	public void update(BoardDTO dto) {
		mapper.update(dto);
		
	}
	@Override
	public List<BoardDTO> getListPaging(Criteria cri) {
		
		return mapper.getListPaging(cri);
	}
	@Override
	public int getTotal() {
		
		return mapper.getTotal();
	}
	
	

}
