package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.AlbumVO;

public interface AlbumService{
	public List<AlbumVO> getList();
	
	public List<AlbumVO> getYMList();
	
	public void register(AlbumVO album);

	public AlbumVO read(Date taken_dt);
	
	public int updateThumb(AlbumVO album);
	
	public int updateCard(AlbumVO album);
	
	public boolean isThumb(Date taken_dt);
	
}