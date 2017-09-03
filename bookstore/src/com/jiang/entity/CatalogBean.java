package com.jiang.entity;

public class CatalogBean extends BaseBean{
	private static final long serialVersionUID = -1599971132388573478L;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "CatalogBean [title=" + title + "]";
	}
	
}
