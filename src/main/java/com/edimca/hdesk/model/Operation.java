package com.edimca.hdesk.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "operation", schema = "help_desk")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	private String mark;

	private LocalDateTime date_m;
	
	private Integer state;
	
	@JoinColumn(name = "fk_user_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User user;
	
	@JoinColumn(name = "fk_request_id", referencedColumnName = "id")
	@ManyToOne(optional = false)	
	private Request request;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public LocalDateTime getDate_m() {
		return date_m;
	}

	public void setDate_m(LocalDateTime date_m) {
		this.date_m = date_m;
	}

	
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	

	@Override
	public String toString() {
		return "Operation [id=" + id + ", mark=" + mark + ", date_m=" + date_m + "]";
	}

	
}
