package org.zerock.service;

import java.util.Date;
import java.util.List;
import java.util.HashMap;

import org.zerock.domain.PicsVO;

public interface PicsService{
	
	public void register(PicsVO pic);
	
	public List<PicsVO> get(Date taken_dt);
	
	public List<PicsVO> getAll();
	
	public HashMap<Date, Integer> cntPics();
	
	public void updatePics(PicsVO pic);

	public PicsVO get(String fl_nm);
	
	public List<PicsVO> getGpsInfo();
	
}