package com.edimca.hdesk.model;

public class ValueMark {

	private String value;
	private Long pending;
	private Long approved;
	private Long assigned;
	private Long total;
	
	
	
	public ValueMark(String value, Long pending, Long approved, Long assigned, Long total) {
		super();
		this.value = value;
		this.pending = pending;
		this.approved = approved;
		this.assigned = assigned;
		this.total = total;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getPending() {
		return pending;
	}
	public void setPending(Long pending) {
		this.pending = pending;
	}
	public Long getApproved() {
		return approved;
	}
	public void setApproved(Long approved) {
		this.approved = approved;
	}
	public Long getAssigned() {
		return assigned;
	}
	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	
}
