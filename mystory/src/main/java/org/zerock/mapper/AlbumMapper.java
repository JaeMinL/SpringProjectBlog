package org.zerock.mapper;

import java.util.Date;
import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.AlbumVO;

public interface AlbumMapper{
	// @Select("select * from tb_album")
	public List<AlbumVO> getList();
	
	public void insert(AlbumVO album);

	public AlbumVO read(Date taken_dt);
	
	public AlbumVO readYM(Date taken_dt);
	
	public int updateThumb(AlbumVO album);
	
	public int updateCard(AlbumVO album);

	public List<AlbumVO> getYMList();
	
	public int checkDate(Date taken_dt);
}