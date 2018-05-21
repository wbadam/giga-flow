package hu.ulyssys.giga.init;

import org.jsoup.nodes.Element;

import com.vaadin.flow.server.BootstrapListener;
import com.vaadin.flow.server.BootstrapPageResponse;

public class CustomBootstrapListener implements BootstrapListener {
    @Override
    public void modifyBootstrapPage(BootstrapPageResponse bootstrapPageResponse) {
        final Element head = bootstrapPageResponse.getDocument().head();

        // manifest needs to be prepended before scripts or it won't be loaded
        head.prepend("<link rel='manifest' href='manifest.json'>");

        // Add service worker
        bootstrapPageResponse.getDocument().body().appendElement("script")
                .attr("src", "register-sw.js");
    }
}
