package edu.sejong.game.command.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.Command;
import edu.sejong.game.dao.BoardDao;
import edu.sejong.game.vo.BoardVo;

public class BoardListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		BoardDao dao = new BoardDao();
		List<BoardVo> boardList = dao.boardList();
		request.setAttribute("boards", boardList);
	}

}
