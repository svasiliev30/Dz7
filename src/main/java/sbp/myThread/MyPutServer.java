package sbp.myThread;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONException;
import org.json.JSONObject;
import sbp.AnotherExecutorServiseExampleApp.AnotherExecutorServiseExampleApp;
import sbp.Person.Person;
import sbp.dao.ProductRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class MyPutServer implements HttpHandler {

    private final ProductRepository dao;

    /**
     * Принимаем репозиторий
     * @param dao
     */
    public MyPutServer(ProductRepository dao)
    {
        this.dao = dao;
    }

    /**
     * Если Приходит Get запрос, то посылаем информацию о персонажах
     * Если приходит Post запрос, то принимаем информацию о другом персонаже и
     * добавляем ее в таблицу
     * @param exchange
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        OutputStream outputStream = exchange.getResponseBody();

        StringBuilder htmlBuilder = new StringBuilder();

        if (exchange.getRequestMethod().equalsIgnoreCase("GET"))
        {
            htmlBuilder.append("<html>")
                    .append("<body>")
                    .append("<h1>")
                    .append("All persons from Data Base: " + getMethod())
                    .append("</h1>")
                    .append("</body>")
                    .append("</html>");
        }
        else if (exchange.getRequestMethod().equalsIgnoreCase("POST"))
        {
            String jsonPerson = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
                            .lines()
                            .collect(Collectors.joining());

                    JSONObject jsonObject = new JSONObject(jsonPerson);

                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String city = jsonObject.getString("city");
                    int age = jsonObject.getInt("age");

            htmlBuilder.append("<html>")
                    .append("<body>")
                    .append("<h1>")
                    .append("Create new person in DB: " + postMethod(new Person(id, name, city, age)))
                    .append("</h1>")
                    .append("</body>")
                    .append("</html>");
        }

        String htmlStr = htmlBuilder.toString();
        exchange.sendResponseHeaders(200, htmlStr.length ());

        outputStream.write(htmlStr.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }

    /**
     * Читаем информацию о персонажах из таблицы
     * @return
     */
    private String getMethod()
    {
        return this.dao.readAllPersons().toString();
    }

    /**
     * Добавляем информацию в таблицу в новом потоке
     * @param person
     * @return
     */
    private String postMethod(Person person)
    {
        List<Callable<Boolean>> taskCollection = new ArrayList<>();

        Callable task;

         try{
            task = () -> {
                this.dao.addPerson(person);
                return true;
            };
            taskCollection.add(task);

            AnotherExecutorServiseExampleApp execut = new AnotherExecutorServiseExampleApp(taskCollection,2);
            execut.ExecutorService();

            System.out.println("execut = " + execut);
            return "SUCCESS";
         }
        catch (Exception e)
        {
            e.printStackTrace();
            return "false";
        }
    }
}
