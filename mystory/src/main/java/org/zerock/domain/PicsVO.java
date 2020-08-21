package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PicsVO{
	private Date taken_dt;
	private String fl_nm;
	private Date reg_dt;
	private Double gps_la;
	private Double gps_lo;
}