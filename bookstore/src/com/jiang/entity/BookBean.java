package com.jiang.entity;

public class BookBean extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String title;
	private CatalogBean catalog = new CatalogBean();
	private String unit;
	private Double price;
	private String pic;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CatalogBean getCatalog() {
		return catalog;
	}
	public void setCatalog(CatalogBean catalog) {
		this.catalog = catalog;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "BookBean [title=" + title + ", catalog=" + catalog + ", unit="
				+ unit + ", price=" + price + ", pic=" + pic + ", getId()="
				+ getId() + "]";
	}
	
	
}
