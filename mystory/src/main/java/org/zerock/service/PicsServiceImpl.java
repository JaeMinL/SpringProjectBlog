package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.PicsVO;
import org.zerock.mapper.PicsMapper;

import org.zerock.domain.AlbumVO;
import org.zerock.mapper.AlbumMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PicsServiceImpl implements PicsService{
	
	//@Setter(onMethod_ = @(Autowired)
	private PicsMapper mapper;
	
	@Override
	public void register(PicsVO pic) {
		log.info("register<Pics>.......");
		mapper.insert(pic);
	}

	@Override
	public PicsVO get(Date taken_dt) {
		// TODO Auto-generated method stub
		log.info("get<Pics>.......");
		return mapper.read(taken_dt);
	}

	@Override
	public List<PicsVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList<Pics>.......");
		return getList();
	}

}