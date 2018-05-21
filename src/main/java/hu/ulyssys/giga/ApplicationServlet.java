package hu.ulyssys.giga;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.flow.server.Constants;
import com.vaadin.flow.server.VaadinServlet;

@WebServlet(urlPatterns = "/*", name = "slot", asyncSupported = true,
        initParams = {@WebInitParam(name = Constants.I18N_PROVIDER, value =
                "hu.ulyssys.giga.i18n.TranslationProvider")})
public class ApplicationServlet extends VaadinServlet {
}
