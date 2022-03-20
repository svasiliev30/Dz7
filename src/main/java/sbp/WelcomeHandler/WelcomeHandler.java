package sbp.WelcomeHandler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import sbp.dao.ProductRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WelcomeHandler implements HttpHandler {

    /**
     * Отправляем информацию на сервер
     * @param exchange
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {

            OutputStream outputStream = exchange.getResponseBody();
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html>")
                    .append("<body>")
                    .append("<h1>")
                    .append("Method " + exchange.getRequestMethod())
                    .append(" on URI " + exchange.getRequestURI().getPath())
                    .append("</h1>")
                    .append("</body>")
                    .append("</html>");
            String htmlStr = htmlBuilder.toString();
            exchange.sendResponseHeaders(200, htmlStr.length());

            outputStream.write(htmlStr.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
    }
}

