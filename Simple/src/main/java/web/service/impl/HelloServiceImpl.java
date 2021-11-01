package web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.HelloDao;
import web.dto.Dept;
import web.service.face.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
	
	//로깅 객체
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	//DAO 객체
	@Autowired
	private HelloDao helloDao;
	
	@Override
	public List<Dept> serviceTest() {
		
		logger.info("serviceTest() 시작");
		
		List<Dept> list = helloDao.selectDept();
		
		for(Dept d : list) {
			logger.info("{}",d);
		}

		return list;
	}

}
