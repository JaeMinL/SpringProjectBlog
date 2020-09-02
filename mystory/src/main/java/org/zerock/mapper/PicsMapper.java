package org.zerock.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.zerock.domain.PicsVO;

public interface PicsMapper{
	// @Select("select * from tb_pics")
	public List<PicsVO> getList();
	
	public void insert(PicsVO pic);

	public List<PicsVO> read(Date taken_dt);
	
	public List<PicsVO> cntPictures();
	
}