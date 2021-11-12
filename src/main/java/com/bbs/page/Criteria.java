package com.bbs.page;

//페이징

public class Criteria {

	private int pageNum; //현재 페이지(내가 원하는 페이지)
	
	private int amount; //한 페이지당 보여줄 갯수
	
	private int skip; // 처음 페이지가 열리면 기본적으로 1페이지에 10개의 게시물이 보이도록 변수 설정

	public Criteria() { //기본 생성자
		this(1, 10); //처음보여주는 페이지 1페이지, 보여줄 게시물 10개
		this.skip = 0;
	}

	public Criteria(int pageNum, int amount) { //위에꺼랑 같은게 아님 매개변수로 들어가는 것
		
		this.pageNum = pageNum;  //위에꺼랑 같게 하기위해 오버로딩
		this.amount = amount;
		this.skip = (pageNum-1) * amount; 
		//페이지 넘이 1페이지라면 값은 0이된다. 어마운트(게시물10) * 0 = 0 /쿼리문 -> select * from board limit 0, 10;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1) * this.amount; 
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip = (pageNum-1) * amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}

	
	
	
	
	
}
