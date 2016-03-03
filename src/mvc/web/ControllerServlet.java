package mvc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processServlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processServlet(request, response);
	}
	private void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 분석
		String command = request.getParameter("cmd");
		CommandHandler handler = null;
		String viewPage = null;
		//모델을 사용하여 요청 기능 수행
		//request 또는 session에 처리 결과 저장
		if(command == null) {
			handler = new NullHandler();
		}else if(command.equals("BoardList")) {
			//handler = new BoardListHandler();
		}
		viewPage = handler.process(request, response);
		//View로 forward
		RequestDispatcher disp = request.getRequestDispatcher(viewPage);
		disp.forward(request, response);
	}
}


