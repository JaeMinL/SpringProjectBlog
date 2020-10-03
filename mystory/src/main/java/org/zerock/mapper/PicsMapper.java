package org.zerock.mapper;

import java.util.Date;
import java.util.List;

import org.zerock.domain.PicsVO;

public interface PicsMapper{
	// @Select("select * from tb_pics")
	public List<PicsVO> getList();
	
	public void insert(PicsVO pic);

	public List<PicsVO> readByDt(Date taken_dt);
	
	public PicsVO readByNm(String fl_nm);
	
	public List<PicsVO> cntPictures();
	
	public void updateDate(PicsVO pics);
	
	public List<PicsVO> selectHasGps();
	
}