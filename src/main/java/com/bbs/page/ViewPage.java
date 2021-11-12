package com.bbs.page;

import java.util.List;

import com.bbs.model.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViewPage {
	
	private int startPage; //시작 페이지
	private int endPage; // 끝 페이지(ex 1~10(end page))
	private boolean prev; //이전 버튼
	private boolean next; // 다음 버튼
	private int total; // 총 게시물 수
	private Criteria cri;
		
	public ViewPage(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10; // 한페이지 첫번째 나오는 페이징 카운트? 10으로 잡는다.
		this.startPage = this.endPage - 9; 
		
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));  
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
	
	
}
