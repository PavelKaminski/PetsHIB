package kaminski.overone.petshib.commands;


import kaminski.overone.petshib.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = new ConfigurationManager().getProperty("path.page.main");
        return page;
    }
}
