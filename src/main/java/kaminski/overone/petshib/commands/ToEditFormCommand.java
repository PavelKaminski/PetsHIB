package kaminski.overone.petshib.commands;



import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ToEditFormCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        ConfigurationManager manager = new ConfigurationManager();

        page= manager.getProperty("path.page.edit_form");
        return page;
    }
}
