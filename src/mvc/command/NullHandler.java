package mvc.command;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(ServletRequest request, ServletResponse response) {
		return "/";
	}

}
