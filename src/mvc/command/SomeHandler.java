package mvc.command;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeHandler implements CommandHandler {

	@Override
	public String process(ServletRequest request, ServletResponse response) {
		// TODO 1. 명령어와 관련된 비즈니스 로직 처리
		
		// TODO 2. 뷰 페이지에서 사용할 정보 저장
//		request.setAttribute("resultValue", resultObject);
		
		// TODO 3. 뷰 페이지 URI 리턴
		return "/view/someView.jsp";
	}

}
