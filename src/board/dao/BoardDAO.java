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
		// �����͸� �ܺ���ġ�� ���ؼ� �����ϰų� �������� daoŬ�������� MyConfig�� �ִ� getInstance �޼��带 �����´�
	}
	
	public void insert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("VO�� ����");
		board.setWriter("hong");
		
		int cnt = session.insert("board.dao.BoardDAO.insert", board);
		session.commit();
		System.out.println("�� " + cnt + " �� �� ����...");
	}
	
	public void select( ) {
		// ��ü �Խñ� ��ȸ 
		// �Ķ���;����� �ڿ� , ���ʿ���� �길 �������
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
		 * 1. ������ �ɱ�? �̸鼭 writer�� ȫ�浿�� �Խñ��� ��ȸ
		 *  BoardVO board = new BoardVO();
			board.setTitle("�ɱ�?");
			board.setWriter("ȫ�浿");
		 */
		
		/*
		// 2. �۾��̰� hong�� �Խù� ��ȸ
		BoardVO board = new BoardVO();
		board.setWriter("hong");
		
		// 3. ������ �ɱ�? �˻�
		BoardVO board = new BoardVO();
		board.setTitle("�ɱ�?");
		*/
		BoardVO board = new BoardVO();
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectWhere", board);
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void selectWhere2() {
		// ������ �ɱ�? , �ۼ��� ȫ�浿�� �Խù� ��ȸ
		
		Map<String, String> board = new HashMap<>();
		board.put("title", "�ɱ�?");
		board.put("writer", "ȫ�浿");
		
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
