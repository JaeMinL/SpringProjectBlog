package org.zerock.mapper;

import java.util.Date;
import java.util.List;

import org.zerock.domain.PicsVO;

public interface PicsMapper{
	// @Select("select * from tb_pics")
	public List<PicsVO> getList();
	
	public void insert(PicsVO pic);

	public PicsVO read(Date taken_dt);
	
}