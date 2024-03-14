package edu.sejong.game.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.Command;
import edu.sejong.game.dao.BoardDao;

public class BoardDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bidStr = request.getParameter("bid");
		BoardDao dao = new BoardDao();
		dao.boardDelete(bidStr);
	}
}
