package tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tx.dao.face.TxDao;
import tx.service.face.TxService;

@Service
public class TxServiceImpl implements TxService {
	
	@Autowired TxDao txDao;
	
	@Override
	@Transactional //트랜지션 관리 라이브러리
	public void test(int deptno) {
		
		txDao.insert2(deptno);
		
		txDao.insert1(deptno);
	}
}
