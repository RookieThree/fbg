package com.jiang.domain;

import java.io.Serializable;

public class PageBean implements Serializable {
	private static final long serialVersionUID = -8362529250815184516L;
	private int pageNum;
	private int maxPage;
	private int rowsNum;
	private int rowsPerpage = 15;
	public static int ALL_NUM=3;
	public int getBeginPage(){
		int beginPage = this.pageNum-ALL_NUM/2;
		if (beginPage<1) {
			beginPage=1;
		}
		return beginPage;
	}
	public int getEndPage(){
		int ss=this.getBeginPage()+ALL_NUM-1;
		if (ss>maxPage) {
			ss= maxPage;
		}
		return ss;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getRowsNum() {
		return rowsNum;
	}
	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}
	public int getRowsPerpage() {
		return rowsPerpage;
	}
	public void setRowsPerpage(int rowsPerpage) {
		this.rowsPerpage = rowsPerpage;
	}
	
}
