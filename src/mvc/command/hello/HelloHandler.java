package mvc.command.hello;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;

public class HelloHandler implements CommandHandler {

	@Override
	public String process(ServletRequest request, ServletResponse response) {
		String name = request.getParameter("name");
		request.setAttribute("message", "Hello, Your name is " + name);
		return "/view/helloView.jsp";
	}

}
