package mvc.command.namecard;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;
import sk.didimdol.model.NameCard;
import sk.didimdol.model.NameCardDAO;

public class UpdateNameCardHandler implements CommandHandler {
	NameCardDAO dao = new NameCardDAO();
	
	@Override
	public String process(ServletRequest request, ServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		NameCard card = new NameCard(id, name, email, age);
		
		dao.updateNameCard(card);
		return "redirect:/namecard/list.do";
	}
}
