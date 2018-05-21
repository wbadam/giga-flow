package hu.ulyssys.giga;

import hu.ulyssys.giga.components.GridLayout;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.router.Route;

@Route("results")
public class ResultsView extends GridLayout {

    public ResultsView() {
        Header header = new Header();
        GigaMenu menu = new GigaMenu();
        Div content = new Div();
        Footer footer = new Footer();
        add(header, menu, content, footer);
    }
}
