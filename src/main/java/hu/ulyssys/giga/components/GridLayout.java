package hu.ulyssys.giga.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasOrderedComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;

@Tag(Tag.DIV)
public class GridLayout extends Component implements
        HasOrderedComponents<GridLayout>, HasStyle, HasSize {

    public GridLayout() {
        getStyle().set("display", "grid");
    }

    public GridLayout(Component... children) {
        this();
        add(children);
    }

    public static void setGridArea(HasStyle component, String gridArea) {
        component.getStyle().set("grid-area", gridArea);
    }
}
