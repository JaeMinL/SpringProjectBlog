package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.PicsVO;

public interface PicsService{
	
	public void register(PicsVO pic);
	
	public PicsVO get(Date taken_dt);
	
	public List<PicsVO> getList();
	
}