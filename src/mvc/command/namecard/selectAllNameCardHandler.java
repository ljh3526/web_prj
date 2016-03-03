package mvc.command.namecard;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvc.command.CommandHandler;
import sk.didimdol.model.NameCard;
import sk.didimdol.model.NameCardDAO;

public class selectAllNameCardHandler implements CommandHandler {

	NameCardDAO dao = new NameCardDAO();
	@Override
	public String process(ServletRequest request, ServletResponse response) {

		request.setAttribute("cardList", dao.selectAllNameCards());

		return "/namecard/listView.jsp";
	}

}
