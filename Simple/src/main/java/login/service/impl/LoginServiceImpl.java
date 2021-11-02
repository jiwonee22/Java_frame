package login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.dao.face.LoginDao;
import login.dto.Login;
import login.service.face.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	//DAO 객체
	@Autowired private LoginDao loginDao;

	@Override
	public void join(Login login) {
		logger.info("join() 호출 {}", login);

		//DB삽입
		loginDao.insert(login);

	}
	
	@Override
	public boolean login(Login login) {
		logger.info("login() {}", login);

		if(loginDao.selectCnt(login) >= 1) {
			return true; //로그인 인증 성공
		}
		
		return false; //로그인 인증 실패
	}
	
	@Override
	public Login info(String loginid) {
		logger.info("info() loginid : {}", loginid);
		
		return loginDao.selectLoginById(loginid);

	}

}
