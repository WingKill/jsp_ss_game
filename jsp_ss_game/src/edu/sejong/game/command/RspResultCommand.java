package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.vo.RspVo;

public class RspResultCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String playerRspStr = null;
		RspVo playerRsp = null;
		RspVo comRsp = null; 
		if(request.getParameter("rsp") != null) {
			playerRspStr = request.getParameter("rsp");
			comRsp = new RspVo();
			playerRsp = new RspVo(playerRspStr);
			playerRsp.rspGame(comRsp);
		}else{
			playerRsp = new RspVo(3);
			comRsp = new RspVo(3);
		}	
		
		request.setAttribute("player", playerRsp);
		request.setAttribute("computer", comRsp);		
	}
}
