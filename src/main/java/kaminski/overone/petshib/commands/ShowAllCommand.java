package kaminski.overone.petshib.commands;

import kaminski.overone.petshib.model.PetDAO;
import kaminski.overone.petshib.model.PetsEntity;
import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAllCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        String page;
        List<PetsEntity> petList;
        PetDAO pets = new PetDAO();
        petList = pets.showAll();

        if (petList != null) {
            request.setAttribute("petList", petList);
            page = new ConfigurationManager().getProperty("path.page.showall_result");
        } else {
            page = new ConfigurationManager().getProperty("path.page.main");
        }
        return page;
    }
}
