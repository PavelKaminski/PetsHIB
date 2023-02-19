package kaminski.overone.petshib.commands;


import kaminski.overone.petshib.model.PetDAO;
import kaminski.overone.petshib.model.PetsEntity;
import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CreateCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page;
        ConfigurationManager manager = new ConfigurationManager();
        String species = null;
        String name = null;
        int age = 0;
        String color = null;
        String owner = null;

        try {
            species = request.getParameter("species");
            name = request.getParameter("name");
            age = Integer.parseInt(request.getParameter("age"));
            color = request.getParameter("color");
            owner = request.getParameter("owner");
        } catch (NumberFormatException e) {
        }

        PetsEntity pet = new PetsEntity(species, name, age, color, owner);

        PetDAO dao = new PetDAO();
        boolean result = dao.create(pet);

        if (result)
            request.setAttribute("message", manager.getProperty("message.result.create"));
        else
            request.setAttribute("message", manager.getProperty("message.result.error"));

        page = manager.getProperty("path.page.result");

        return page;
    }
}
