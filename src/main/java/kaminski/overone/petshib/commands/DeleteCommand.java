package kaminski.overone.petshib.commands;

import kaminski.overone.petshib.model.PetDAO;
import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page;
        ConfigurationManager manager = new ConfigurationManager();
        int petID = 0;

        try {
            petID = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        PetDAO petDAO = new PetDAO();
        int result = petDAO.deletePet(petID);

        if (result != 0) {
            request.setAttribute("message", manager.getProperty("message.result.delete"));
            HttpSession session = request.getSession();
            session.invalidate();
        } else {
            request.setAttribute("message", manager.getProperty("message.result.error"));
        }
        page = manager.getProperty("path.page.result");
        return page;
    }
}
