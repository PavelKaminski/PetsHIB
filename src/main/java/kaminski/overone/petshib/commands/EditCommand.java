package kaminski.overone.petshib.commands;


import kaminski.overone.petshib.model.PetDAO;
import kaminski.overone.petshib.model.PetsEntity;
import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page;
        ConfigurationManager manager = new ConfigurationManager();

        int id = 0;
        String species = null;
        String name = null;
        int age = 0;
        String color = null;
        String owner = null;

        try {
            id = Integer.parseInt(request.getParameter("id"));
            species = request.getParameter("species");
            name = request.getParameter("name");
            age = Integer.parseInt(request.getParameter("age"));
            color = request.getParameter("color");
            owner = request.getParameter("owner");
        } catch (NumberFormatException e) {
        }

        PetsEntity pet = new PetsEntity(id, species, name, age, color, owner);

        PetDAO petDAO = new PetDAO();
        int result = petDAO.editPet(pet);

        if (result != 0) {
            request.setAttribute("message", manager.getProperty("message.result.edit"));
            HttpSession session = request.getSession();
            session.invalidate();
        } else
            request.setAttribute("message", manager.getProperty("message.result.error"));

        page = manager.getProperty("path.page.result");
        return page;
    }
}
