package view;

import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Header {
    public static void render(HttpExchange t) throws IOException {
        File file = new File("header.html").getCanonicalFile();

        t.sendResponseHeaders(200, 0);
        OutputStream os = t.getResponseBody();
        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fs.read(buffer)) >= 0) {
            os.write(buffer, 0, count);
        }
        fs.close();

        Menu.render(t);
    }
}
