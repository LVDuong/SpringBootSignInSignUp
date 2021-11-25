package com.javaspring.signinsignup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Trip")
public class Trip {

	@Id
	@Column (name = "Tripid")
	private int tripid;
	@Column (name = "Tripname")
	private String tripname;
	@Column (name = "Startpoint")
	private String startPoint;
	@Column (name = "Endpoint")
	private String endPoint;
	@Column (name = "Dercript")
	private String dercript;
	@Column (name = "Datetostart")
	private String datetostart;
	@Column (name = "Datetoend")
	private String datetoend;
	@Column(name = "Cost")
	private String cost;
	public Trip() {
		super();
	}
	public Trip(int tripid, String tripname, String startPoint, String endPoint, String dercript, String datetostart, String datetoend, String cost) {
		super();
		this.tripid = tripid;
		this.tripname = tripname;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.dercript = dercript;
		this.datetostart = datetostart;
		this.datetoend = datetoend;
		this.cost = cost;
	}
	public int getId() {
		return tripid;
	}
	public void setId(int tripid) {
		this.tripid = tripid;
	}
	public String getName() {
		return tripname;
	}
	public void setName(String tripname) {
		this.tripname = tripname;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getDercript() {
		return dercript;
	}
	public void setDercript(String dercript) {
		this.dercript = dercript;
	}
	public String getDatetostart() {
		return datetostart;
	}
	public void setDatetostart(String datetostart) {
		this.datetostart = datetostart;
	}
	public String getDatetoend() {
		return datetoend;
	}
	public void setDatetoend(String datetoend) {
		this.datetoend = datetoend;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
}
