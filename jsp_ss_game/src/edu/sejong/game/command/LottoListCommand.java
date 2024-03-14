package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.vo.LottoVo;

public class LottoListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		LottoVo lotto = new LottoVo();
		request.setAttribute("lotto", lotto);
	}
}
