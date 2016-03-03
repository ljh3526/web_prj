package mvc.command.namecard;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;
import sk.didimdol.model.NameCard;
import sk.didimdol.model.NameCardDAO;

public class selectNameCardHandler implements CommandHandler {

	NameCardDAO dao = new NameCardDAO();
	@Override
	public String process(ServletRequest request, ServletResponse response) {
		String param = request.getParameter("id");
		if(param != null) {
			int id = Integer.parseInt(param);
			NameCard card = dao.selectNameCard(id);
			request.setAttribute("namecard", card);
		}
		return "/namecard/cardForm.jsp";
	}

}
