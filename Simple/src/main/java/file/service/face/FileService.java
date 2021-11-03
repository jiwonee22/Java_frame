package file.service.face;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import file.dto.Filetest;

public interface FileService {
	
	/**
	 * 업로드된 파일과 전달파라미터를 처리한다
	 * 
	 * @param title - 제목
	 * @param fileupload - 업로드된 파일 정보 객체
	 */
	public void filesave(String title, MultipartFile fileupload);

	/**
	 * 파일의 리스트를 받아온다
	 * 
	 * @return - 업로드 된 파일 리스트
	 */
	public List<Filetest> getFileList();

	/**
	 * 파일번호를 이용하여 업로드된 파일의 정보를 조회한다
	 * 
	 * @param fileno - 조회할 파일의 번호
	 * @return - 조회된 파일 정보 객체
	 */
	public Filetest getFile(int fileno);

}
