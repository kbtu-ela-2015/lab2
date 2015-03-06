package view;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Footer {
    public static void render(HttpExchange t) throws IOException {
        Sidebar.render(t);
        View.print(t, "</div>");

        View.print(t, "<footer class=\"row\">\n" +
                "    <div class=\"large-12 columns\">\n" +
                "        <hr>\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"large-6 columns\">\n" +
                "                <p>© Copyright no one at all. Go to town.</p>\n" +
                "            </div>\n" +
                "            <div class=\"large-6 columns\">\n" +
                "                <ul class=\"inline-list right\">");

        model.Menu menu = new model.Menu();
        for (model.MenuItem menuItem : menu.getList()) {
            View.print(t, "<li><a href=\"" + menuItem.getUrl() + "\">" + menuItem.getLabel() + "</a></li>");
        }

        View.print(t, "</ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</footer>\n" +
                "</body>\n" +
                "</html>");

        OutputStream os = t.getResponseBody();
        os.close();
    }
}
