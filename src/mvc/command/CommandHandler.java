package mvc.command;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface CommandHandler {

	String process(ServletRequest request, ServletResponse response);

}
