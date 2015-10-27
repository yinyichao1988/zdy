package com.zdy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "z_car")
public class Car implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1652752686446331875L;

	private Long id;
	
	private String cph;
	
	private String clxh;
	
	private String clpp;
	
	private String csys;
	
	private String yy;
	
	private String jysj;
	
	private String jybm;
	
	private String jyxm;
	
	private String jysfzh;
	
	private Date lrsj;
	
	private Integer zt;

	
	@Id	
	@Column(name="id", unique = true, nullable = false, precision = 10, scale = 0)	
	@SequenceGenerator(name="car_seq",allocationSize=1,initialValue=1, sequenceName="SQ_ZCAR_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="car_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCph() {
		return cph;
	}

	public void setCph(String cph) {
		this.cph = cph;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	public String getYy() {
		return yy;
	}

	public void setYy(String yy) {
		this.yy = yy;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getJybm() {
		return jybm;
	}

	public void setJybm(String jybm) {
		this.jybm = jybm;
	}

	public String getJyxm() {
		return jyxm;
	}

	public void setJyxm(String jyxm) {
		this.jyxm = jyxm;
	}

	public String getJysfzh() {
		return jysfzh;
	}

	public void setJysfzh(String jysfzh) {
		this.jysfzh = jysfzh;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}
	
	
	
	
	
	
	
}
