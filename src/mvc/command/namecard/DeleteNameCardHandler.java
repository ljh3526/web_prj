package mvc.command.namecard;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;
import sk.didimdol.model.NameCard;
import sk.didimdol.model.NameCardDAO;

public class DeleteNameCardHandler implements CommandHandler {
	NameCardDAO dao = new NameCardDAO();
	@Override
	public String process(ServletRequest request, ServletResponse response) {
		String id = request.getParameter("id");
		NameCard card = new NameCard();
		card.setId(Integer.parseInt(id));
		dao.deleteNameCard(card);
		
		return "redirect:/namecard/list.do";
	}

}
