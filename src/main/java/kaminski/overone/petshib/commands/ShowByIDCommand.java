package kaminski.overone.petshib.commands;


import kaminski.overone.petshib.model.PetDAO;
import kaminski.overone.petshib.model.PetsEntity;
import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowByIDCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        ConfigurationManager manager = new ConfigurationManager();

        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
        }

        PetDAO dao = new PetDAO();
        PetsEntity pet = dao.showByID(id);

        if (pet != null) {
            HttpSession session = request.getSession();
            session.setAttribute("pet", pet);
            page = manager.getProperty("path.page.id_result");
        } else {
            request.setAttribute("message", manager.getProperty("message.result.error"));
            page = manager.getProperty("path.page.result");
        }
        return page;
    }
}
