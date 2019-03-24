package com.zsc.edu.entity;

import java.util.List;

public class PageModel {
	private int currPage;//��ǰҳ
	private int totalRecords;//�ܼ�¼��
	private List<?> list;
	private int pageSize;
	public PageModel(){}
	/*
	 * ��ȡ��ҳ��
	 
	public int getTotalPage(){
		return (totalRecords+pageSize-1)/pageSize;
	}*/
	/*
	 * ��ȡ��һҳ
	 
	public int getFirstPage(){
		return 1;
	}
	
	 * ��ȡ��һҳ
	 
	public int getPreviousPage(){
		return currPage<=1?1:currPage-1;
	}
	
	 * ��ȡ��һҳ
	 
	public int getNextPage(){
		if(currPage>=getTotalPage()){
			return getLastPage();
		}
		return currPage+1;
	}
	public int getLastPage(){
		return getTotalPage()<=0?1:getTotalPage();
	}*/
	
	public void setTotalRecords(int totalRecords){
		this.totalRecords=totalRecords;
	}
	public void setCurrPage(int currPage){
		this.currPage=currPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
}
