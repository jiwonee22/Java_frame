package file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import file.dao.face.FileDao;
import file.dto.Filetest;
import file.service.face.FileService;

@Service
public class FileServiceImpl implements FileService {

	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	//서블릿 컨텍스트 객체
	@Autowired ServletContext context;
	
	//DAO객체
	@Autowired FileDao fileDao;

	@Override
	public void filesave(String title, MultipartFile fileupload) {
		logger.info("filesave()");
		
		if(fileupload.getSize() <= 0) {
			logger.info("파일의 크기가 0, 처리 중단");
			return; //없으면 중단안됨
		}    
		
		//파일이 저장될 경로(RealPath)
		String storedPath = context.getRealPath("upload");
		logger.info("upload realPath : {}", storedPath);
		
		//upload폴더가 존재하지 않으면 생성한다
		File storedFolder = new File(storedPath);
		if(!storedFolder.exists()) {
			storedFolder.mkdir();
		}
		
		String filename = fileupload.getOriginalFilename(); //원본 파일명
		filename += UUID.randomUUID().toString().split("-")[4]; //UUID추가
		logger.info("filename : {}", filename);
		
		
		//저장될 파일의 정보 객체 - java.util.File
		File dest = new File(storedFolder, filename);
		
		try {
			//업로드 된 임시 파일을 저장하기
			fileupload.transferTo(dest); 
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//DB에 기록할 정보 객체 - DTO
		Filetest filetest = new Filetest();
		filetest.setTitle(title);
		filetest.setOriginName(fileupload.getOriginalFilename());
		filetest.setStoredName(filename);
		
		fileDao.insertFile(filetest);
	
		
	}
	
	@Override
	public List<Filetest> getFileList() {
		logger.info("getFileList()");
		
		List<Filetest> fileList = fileDao.selectFileAll();
		
		for(Filetest f : fileList) {
			logger.info("{}", f);
		}
		
		return fileList;
	}
	
	@Override
	public Filetest getFile(int fileno) {
		return fileDao.selectByFileno(fileno);
	}

}
