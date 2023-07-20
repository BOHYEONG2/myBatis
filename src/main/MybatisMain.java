package main;

import org.apache.ibatis.session.SqlSession;

import board.dao.BoardDAO;
import board.dao.MyConfig;

public class MybatisMain {

	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAO();
		dao.work();
		
	}

}
