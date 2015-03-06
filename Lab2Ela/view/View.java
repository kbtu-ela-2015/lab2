package view;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class View {
    public static void print(HttpExchange t, String data) throws IOException {
        OutputStream os = t.getResponseBody();
        os.write(data.getBytes());
    }
}
