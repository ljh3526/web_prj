package mvc.command.namecard;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;
import sk.didimdol.model.NameCard;
import sk.didimdol.model.NameCardDAO;

public class InsertNameCardHandler implements CommandHandler {
	NameCardDAO dao = new NameCardDAO();
	@Override
	public String process(ServletRequest request, ServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		NameCard card = new NameCard(name, email, age);
		
		dao.insertNameCard(card);
		return "redirect:/namecard/list.do";
	}

}
