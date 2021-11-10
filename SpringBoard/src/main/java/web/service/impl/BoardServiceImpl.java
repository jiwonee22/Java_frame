package web.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.Boardfile;
import web.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;
	@Autowired private ServletContext context;
	
	@Override
	public List<Board> list(Paging paging) {
		
		return boardDao.selectList(paging);
	}

	@Override
	public Paging getPaging(Paging paramData) {
		
		//총 게시글 수 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징 계산
		Paging paging = new Paging(totalCount, paramData.getCurPage());
		
		return paging;
	}
	
	@Override
	public Board view(Board viewBoard) {
		
		boardDao.hit(viewBoard); //조회수 증가
		
		return boardDao.selectBoardByBoardno(viewBoard);
	}
	
	@Override
	@Transactional
	public void write(Board board, MultipartFile file) {

		//게시글 정보 처리
		
		if( "".equals(board.getTitle()) ) {
			board.setTitle("(제목없음)");
		}
		boardDao.insertBoard(board);
		
		//--------------------------------------------------------
		
		//빈 파일
		if( file.getSize() <= 0 ) {
			return;
		}
		
		//파일이 저장될 경로
		String storedPath = context.getRealPath("upload");
	
		File storedFolder = new File(storedPath);
		if( !storedFolder.exists() ) {
			storedFolder.mkdir();
		}
		
		//저장될 파일의 이름 생성하기
		String originName = file.getOriginalFilename();
		String storedName = originName + UUID.randomUUID().toString().split("-")[4];
		
		//저장할 파일 객체
		File dest = new File(storedPath, storedName);
		
		try {
			file.transferTo(dest); //업로드 파일 저장
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//--------------------------------------------------------
		
		Boardfile boardfile = new Boardfile();
		boardfile.setBoardNo( board.getBoardNo() );
		boardfile.setOriginName(originName);
		boardfile.setStoredName(storedName);
		
		boardDao.insertFile(boardfile);
	}
	
	@Override
	public Boardfile getAttachFile(Board viewBoard) {
		return boardDao.selectBoardfileByBoardno(viewBoard);
	}
	
	@Override
	public Boardfile getFile(int fileNo) {
		return boardDao.selectBoardfileByFileno(fileNo);
	}
	
	
	@Override
	@Transactional
	public void update(Board board, MultipartFile file) {
		if( "".equals(board.getTitle()) ) {
			board.setTitle("(제목없음)");
		}
		boardDao.update(board);

		//----------------------------------------

		if( file.getSize() <= 0 ) {
			return;
		}
	
		//파일이 저장될 경로(real path)
		String storedPath = context.getRealPath("upload");
		
		//폴더가 존재하지 않으면 생성하기
		File stored = new File(storedPath);
		if( !stored.exists() ) {
			stored.mkdir();
		}
		
		//원본파일이름 알아내기
		String originName = file.getOriginalFilename();
		
		//원본파일이름에 UUID추가하기 (파일명이 중복되지않도록 설정)
		String storedName = originName + UUID.randomUUID().toString().split("-")[4];
		
		//저장될 파일 정보 객체
		File dest = new File( stored, storedName );
		
		try {
			//업로드된 파일을 저장하기
			file.transferTo(dest);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//----------------------------------------
		
		Boardfile boardfile = new Boardfile();
		boardfile.setBoardNo(board.getBoardNo());
		boardfile.setOriginName(originName);
		boardfile.setStoredName(storedName);
		
		boardDao.deleteFile(board);
		boardDao.insertFile(boardfile);
		
	}
	
	@Override
	@Transactional
	public void delete(Board board) {
		boardDao.deleteFile(board);
		boardDao.delete(board);
	}

	
}






















