package edu.sejong.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.sejong.game.vo.BoardVo;

public class BoardDao {
	DataSource dataSource = null;	
	
	public BoardDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			
		}
	}
	
	public List<BoardVo> boardList(int listCount, int page){
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int minListCount = (page-1)*listCount + 1;
		int maxListCount = page*listCount;
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		String sql= "SELECT * " + 
					"FROM (" + 
					"    SELECT " + 
					"        t.*," + 
					"        ROW_NUMBER() OVER (ORDER BY bid desc) AS row_num" + 
					"    FROM MVC_BOARD t" + 
					")" + 
					"WHERE row_num BETWEEN ? AND ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, minListCount);
			pstmt.setInt(2, maxListCount);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 int bid = rs.getInt("bid");
				 String bname = rs.getString("bname");
				 String btitle = rs.getString("btitle");
				 String bcontent = rs.getString("bcontent");
				 Timestamp bdate = rs.getTimestamp("bdate");
				 int bhit = rs.getInt("bhit");
				 int bgroup = rs.getInt("bgroup");
				 int bstep = rs.getInt("bstep");
				 int bindent = rs.getInt("bindent");
				 
				 BoardVo board = new BoardVo(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				 boardList.add(board);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}	
		
		return boardList;
	}
	
	public List<BoardVo> boardList(){
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		String sql= "SELECT * FROM MVC_BOARD ORDER BY bid desc";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 int bid = rs.getInt("bid");
				 String bname = rs.getString("bname");
				 String btitle = rs.getString("btitle");
				 String bcontent = rs.getString("bcontent");
				 Timestamp bdate = rs.getTimestamp("bdate");
				 int bhit = rs.getInt("bhit");
				 int bgroup = rs.getInt("bgroup");
				 int bstep = rs.getInt("bstep");
				 int bindent = rs.getInt("bindent");
				 
				 BoardVo board = new BoardVo(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				 boardList.add(board);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}			
		return boardList;
	}
	
	public BoardVo contentView(String bidStr) {		
		boardUpdateHit(bidStr);
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int selectedBid = Integer.valueOf(bidStr);		
		BoardVo board = null;
		
		String sql= "SELECT * FROM MVC_BOARD where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectedBid);
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				 int bid = rs.getInt("bid");
				 String bname = rs.getString("bname");
				 String btitle = rs.getString("btitle");
				 String bcontent = rs.getString("bcontent");
				 Timestamp bdate = rs.getTimestamp("bdate");
				 int bhit = rs.getInt("bhit");
				 int bgroup = rs.getInt("bgroup");
				 int bstep = rs.getInt("bstep");
				 int bindent = rs.getInt("bindent");
				 
				 board = new BoardVo(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return board;
	}
	
	public void boardUpdate(BoardVo board){
		Connection conn = null; 
		PreparedStatement pstmt = null;
				
		int result = 0;
		String sql= "update mvc_board set bname=?, btitle=?, bcontent=? where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setInt(4, board.getBid());
			result = pstmt.executeUpdate();
			System.out.println("수정 실행 결과 : " + result + ". 값이 0일 경우, 해당 처리가 되지 않은 것.");			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}			
	}
	
	public void boardDelete(String bidStr){
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		int bid = Integer.valueOf(bidStr);		
		int result = 0;
		String sql= "delete from mvc_board where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			System.out.println("삭제 실행 결과 : " + result + ". 값이 0일 경우, 해당 처리가 되지 않은 것.");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}			
	}
	
	private void boardUpdateHit(String bidStr) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
				
		int result = 0;
		String sql= "update mvc_board set bhit = bhit+1 where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bidStr));
			
			result = pstmt.executeUpdate();
			System.out.println("조회수 수정 실행 결과 : " + result + ". 값이 0일 경우, 해당 처리가 되지 않은 것.");			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
