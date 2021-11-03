package file.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import file.dto.Filetest;
import file.service.face.FileService;

@Controller
public class FileController {
	
	//로그 객체
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	//서비스 객체
	@Autowired private FileService fileService;
	
	@RequestMapping(value="/file/fileup", method=RequestMethod.GET)
	public void fileForm() {
		logger.info("/file/fileup [GET]");
	}

	@RequestMapping(value="/file/fileup", method=RequestMethod.POST)
	public String fileup(
			
			String title
			, @RequestParam(value="title") String t
			
			, MultipartFile file
			, @RequestParam(value="file") MultipartFile fileupload

			
		) {
		
		logger.info("/file/fileup [POST]");

		logger.info("title : {}", title);
		logger.info("t : {}", t);
		
		logger.info("file : {}", file);
		logger.info("fileupload : {}", fileupload);
	
		logger.info("fileupload : {}", fileupload.getOriginalFilename());
		
		//업로드된 파일을 저장하고 DB기록
		fileService.filesave(title, fileupload);
		
		return "redirect:/file/list";
	}
	
	@RequestMapping(value="/file/list")
	public void filelist(Model model) {
		
		logger.info("/file/list [GET]");
		
		//서비스 메소드 호출
		List<Filetest> fileList = fileService.getFileList();
		
		model.addAttribute("fileList", fileList);
		
	}
	
	@RequestMapping(value="/file/download")
	public String download(int fileno, Model model) {
		logger.info("/file/download fileno : {}", fileno);
		
		//파일번호에 해당하는 파일정보를 가져오기
		Filetest file = fileService.getFile(fileno);
		logger.info("file {}",file);
		
		//다운로드할 파일의 정보를 모델값으로 전달하기
		model.addAttribute("downFile", file);
		
		//viewName 지정하기
		return "down"; //servlet-context에 BeanNameViewResolver로 전달
		
	}
	
	
	
}
	