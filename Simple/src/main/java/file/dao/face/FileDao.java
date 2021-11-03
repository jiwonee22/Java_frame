package file.dao.face;

import java.util.List;

import file.dto.Filetest;

public interface FileDao {
	
	/**
	 * 전달된 파일 정보 삽입하기
	 * @param filetest - 업로드된 파일의 정보 DTO객체
	 */
	public void insertFile(Filetest filetest);

	/**
	 * 업로드 된 파일의 리스트를 가져오기
	 * 
	 * @return fileList - 업로드된 파일의 리스트
	 */
	public List<Filetest> selectFileAll();

	/**
	 * fileno를 이용한 조회
	 * 
	 * @param - fileno 조회할 파일 번호
	 * @return - 조회된 파일 정보 객체
	 */
	public Filetest selectByFileno(int fileno);

}
