package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	//DAO 객체
	@Autowired MemberDao memberDao;
	
	@Override
	public boolean login(Member member) {
		logger.info("login() {}", member);
		
		if(memberDao.selectCnt(member) >= 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void join(Member member) {
		logger.info("join() {}", member);
		
		if(memberDao.selectCntById(member) <= 0) {
			logger.info("중복되는 ID 없음");
			memberDao.insertMember(member);
		} else {
			logger.info("이미 존재하는 ID");
		}
		
	}

	

}
