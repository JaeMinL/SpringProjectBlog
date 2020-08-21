package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AlbumVO{
	private Date taken_dt;
	private String title;
	private String text;
	private String thumb_fl_nm;
}