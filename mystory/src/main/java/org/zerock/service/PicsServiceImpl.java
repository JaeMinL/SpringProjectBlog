package org.zerock.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

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
	public List<PicsVO> get(Date taken_dt) {
		log.info("get<Pics_taken_dt>.......");
		return mapper.readByDt(taken_dt);
	}
	@Override
	public PicsVO get(String fl_nm) {
		log.info("get<Pics_fl_nm>");
		return mapper.readByNm(fl_nm);
	}
	
	@Override
	public List<PicsVO> getAll() {
		log.info("getList<Pics>.......");
		return mapper.getList();
	}
	
	public HashMap<Date, Integer> cntPics(){
		log.info("cntPic<>......");
		HashMap<Date, Integer> hashmap = new HashMap<Date, Integer>();
		List<PicsVO> resultList = mapper.cntPictures();
		
		for(PicsVO picsVO: resultList) {
			hashmap.put(picsVO.getTaken_dt(), picsVO.getCnt());
			System.out.println(picsVO.getTaken_dt() +"::"+ picsVO.getCnt() );
		}
		
		return hashmap;
	}
	
	public void updatePics(PicsVO pic) {
		log.info("updateDate .......");
		mapper.updateDate(pic);
	}
	
	public List<PicsVO> getGpsInfo(){
		log.info("getGpsInfo .......");
		return mapper.selectHasGps();
	}
}