package edu.sejong.game.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import edu.sejong.game.command.Command;
import edu.sejong.game.command.board.BoardDeleteCommand;
import edu.sejong.game.command.board.BoardListCommand;
import edu.sejong.game.command.board.BoardContentCommand;
import edu.sejong.game.command.board.BoardUpdateCommand;

/**
 * Servlet implementation class lottoController
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String comm = uri.substring(contextPath.length());
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("comm : " + comm);
		
		if(comm.equals("/board/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			
			viewPage = "/board_list.jsp";
		}else if(comm.equals("/board/delete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			
			viewPage = "/board/list.do";
		}else if(comm.equals("/board/update_view.do")) {
			command = new BoardContentCommand();
			command.execute(request, response);
			
			viewPage = "/board_update.jsp";
		}else if(comm.equals("/board/update.do")) {
			command = new BoardUpdateCommand();
			command.execute(request, response);
			
			viewPage = "/board/list.do";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
