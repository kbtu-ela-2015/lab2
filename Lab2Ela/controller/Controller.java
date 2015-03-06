package controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import view.*;

import java.io.*;
import java.net.InetSocketAddress;

public class Controller {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MainHandler());
        server.createContext("/images.jpg", new ImageHandler());
        server.createContext("/style.css", new GetStyleHandler());
        server.setExecutor(null); 
        server.start();
    }

    static class MainHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String path = t.getRequestURI().getPath();
            if (path.equals("/") || path.equals("/main")) {
                Header.render(t);
                Main.render(t);
                Footer.render(t);
            } else if (path.equals("/photos")) {
                Header.render(t);
                View.print(t, "Photos");
                Footer.render(t);
            } else if (path.equals("/contact")) {
                Header.render(t);
                View.print(t, "Contact me via email or skype :)");
                Footer.render(t);

            } else {
                String response = "404 (Not Found)\n";
                t.sendResponseHeaders(404, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    static class GetStyleHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            File file = new File("style.css").getCanonicalFile();

            t.sendResponseHeaders(200, 0);
            OutputStream os = t.getResponseBody();
            FileInputStream fs = new FileInputStream(file);
            final byte[] buffer = new byte[0x10000];
            int count = 0;
            while ((count = fs.read(buffer)) >= 0) {
                os.write(buffer, 0, count);
            }
            fs.close();
            os.close();
        }
    }

    private static class ImageHandler implements HttpHandler {
        public void  handle(HttpExchange t) throws IOException {
            File image = new File("images.jpg").getCanonicalFile();

            t.sendResponseHeaders(200, 0);

            OutputStream os = t.getResponseBody();
            FileInputStream fs = new FileInputStream(image);
            final byte[] buffer = new byte[0x10000];
            int count = 0;
            while ((count = fs.read(buffer)) >= 0) {
                os.write(buffer, 0, count);
            }
            fs.close();
            os.close();
        }
    }
}
