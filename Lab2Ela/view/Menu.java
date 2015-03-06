package view;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class Menu extends View {
    public static void render(HttpExchange t) throws IOException {
        print(t, "<div class=\"row\">");
        print(t, "<div class=\"large-12 columns\">");
        print(t, "<div class=\"nav-bar right\">");
        print(t, "<ul class=\"button-group\">");

        model.Menu menu = new model.Menu();
        for (model.MenuItem menuItem : menu.getList()) {
            View.print(t, "<li><a href=\"" + menuItem.getUrl() + "\" class=\"button\">" + menuItem.getLabel() + "</a></li>");
        }

        print(t, "</ul>");
        print(t, "</div>");
        print(t, "<h1>Blog<small>This is my blog. </small></h1>");
        print(t, "<hr>");
        print(t, "</div>");
        print(t, "</div>");
        print(t, "<div class=\"row\">");
        print(t, "<div class=\"large-9 columns\" role=\"content\">");
    }
}
