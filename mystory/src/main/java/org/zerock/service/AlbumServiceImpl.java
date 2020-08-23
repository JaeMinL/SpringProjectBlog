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
public class AlbumServiceImpl implements AlbumService{
	
	private AlbumMapper mapper;
	
	@Override
	public List<AlbumVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList<Album>............");
		return mapper.getList();
	}
	
	@Override
	public List<AlbumVO> getYMList(){
		log.info("getYMList......");
		return mapper.getYMList();
	}

	@Override
	public void register(AlbumVO album) {
		// TODO Auto-generated method stub
		log.info("register<Album>.......");	
		mapper.insert(album);
	}

	@Override
	public AlbumVO read(Date taken_dt) {
		// TODO Auto-generated method stub
		log.info("read<Album>.......");
		return mapper.read(taken_dt);
	}

	@Override
	public int updateThumb(AlbumVO album) {
		// TODO Auto-generated method stub
		log.info("updateThumb<Album>.......");
		return 0;
	}

	@Override
	public int updateCard(AlbumVO album) {
		// TODO Auto-generated method stub
		log.info("updateCard<Album>.......");
		return 0;
	}


}
