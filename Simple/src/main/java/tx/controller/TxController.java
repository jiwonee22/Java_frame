package tx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tx.service.face.TxService;

@Controller
public class TxController {
	
	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(TxController.class);
	
	//서비스 객체
	@Autowired TxService txService;
	
	@RequestMapping(value="/tx/test")
	public void txTest(int deptno) {
		logger.info("/tx/text GET");
		
		txService.test(deptno);
	}

}
