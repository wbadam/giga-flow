package hu.ulyssys.giga;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;

public class GigaMenu extends Nav {

    public GigaMenu() {
        ListItem home = new ListItem(new Anchor("", "Home"));
        ListItem results = new ListItem(new Anchor("results", "Results"));
        ListItem races = new ListItem(new Anchor("races", "Races"));
        ListItem login = new ListItem(new Anchor("login", "Login"));

        UnorderedList list = new UnorderedList(home, results, races, login);

        add(list);
    }
}
