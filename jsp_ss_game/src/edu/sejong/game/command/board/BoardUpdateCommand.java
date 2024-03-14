package edu.sejong.game.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.Command;
import edu.sejong.game.dao.BoardDao;
import edu.sejong.game.vo.BoardVo;

public class BoardUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bidStr = request.getParameter("bid");
		int bid = Integer.valueOf(bidStr);
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardVo board = new BoardVo();
		board.setBid(bid);
		board.setBname(bname);
		board.setBtitle(btitle);
		board.setBcontent(bcontent);
		
		BoardDao dao = new BoardDao();
		dao.boardUpdate(board);		
	}
}
