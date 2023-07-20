package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;

public class BoardDAO {

	private SqlSession session;
	
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
		// 데이터를 외부장치를 통해서 저장하거나 가져오는 dao클래스에서 MyConfig에 있는 getInstance 메서드를 가져온다
	}
	
	public void insert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("VO로 삽입");
		board.setWriter("hong");
		
		int cnt = session.insert("board.dao.BoardDAO.insert", board);
		session.commit();
		System.out.println("총 " + cnt + " 개 행 삽입...");
	}
	
	public void select( ) {
		// 전체 게시글 조회 
		// 파라미터없으니 뒤에 , 할필요없이 얘만 보내면됨
//		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll2");
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
/*		
		Connection conn = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("  from t_board ");
			sql.append(" order by no desc ");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("viewCnt"));
				board.setRegDate(rs.getString("reg_date"));
			}
		}
	*/	
	public void selectOne() {
		
		int boardNo = 4;
		BoardVO result = session.selectOne("board.dao.BoardDAO.selectByNo", boardNo);
		System.out.println(result);
		
		BoardVO board = new BoardVO();
		board.setNo(4);
		result = session.selectOne("board.dao.BoardDAO.selectByNo2", board);
		System.out.println(result);
	}
	
	public void selectWhere() {
		
		/*
		 * 1. 제목이 될까? 이면서 writer가 홍길동인 게시글을 조회
		 *  BoardVO board = new BoardVO();
			board.setTitle("될까?");
			board.setWriter("홍길동");
		 */
		
		/*
		// 2. 글쓴이가 hong인 게시물 조회
		BoardVO board = new BoardVO();
		board.setWriter("hong");
		
		// 3. 제목이 될까? 검색
		BoardVO board = new BoardVO();
		board.setTitle("될까?");
		*/
		BoardVO board = new BoardVO();
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectWhere", board);
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void selectWhere2() {
		// 제목이 될까? , 작성자 홍길동인 게시물 조회
		
		Map<String, String> board = new HashMap<>();
		board.put("title", "될까?");
		board.put("writer", "홍길동");
		
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectWhere2", board);
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void work() {
		selectWhere2();
//		selectWhere();
//		selectOne();
//		select();
//		insert();
		
	}
	
}
