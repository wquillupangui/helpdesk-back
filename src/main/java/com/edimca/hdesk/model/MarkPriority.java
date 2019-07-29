package com.edimca.hdesk.model;

public class MarkPriority {
	
	private String mark;
	private Long high;
	private Long normal;
	private Long low;
	private Long total;
	
	
	
	public MarkPriority(String mark, Long high, Long normal, Long low, Long total) {
		super();
		this.mark = mark;
		this.high = high;
		this.normal = normal;
		this.low = low;
		this.total = total;
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Long getHigh() {
		return high;
	}
	public void setHigh(Long high) {
		this.high = high;
	}
	public Long getNormal() {
		return normal;
	}
	public void setNormal(Long normal) {
		this.normal = normal;
	}
	public Long getLow() {
		return low;
	}
	public void setLow(Long low) {
		this.low = low;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	
}
