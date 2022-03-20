import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sbp.dao.ProductRepository;
import sbp.Person.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCreateTable {

    /**
     * Create table with id, name, age, city.
     * @throws SQLException
     */
    @Test
    void createTable()  {
        String sql = "CREATE TABLE person (" +
                "id VARCHAR(50)," +
                "name VARCHAR(50)," +
                "age VARCHAR(50)," +
                "city VARCHAR(100)" +
                ");";

        ProductRepository repository = new ProductRepository();
        Assertions.assertTrue(repository.createTable(sql));

    }

    /**
     * Error create table person.Table exists
     * @throws SQLException
     */
    @Test
    void createTableThrows()  {
        String sql = "CREATE TABLE person (" +
                "id VARCHAR(50)," +
                "name VARCHAR(50)," +
                "age VARCHAR(50)," +
                "city VARCHAR(100)" +
                ");";

            ProductRepository repository = new ProductRepository();
            Assertions.assertFalse(repository.createTable(sql));

    }

    /**
     * Added information to the table. Table person creating/
     * @throws SQLException
     */
    @Test
    void addInformation() throws SQLException {

            ProductRepository repository = new ProductRepository();

            List<Person> list = new ArrayList<>();
            list.add(new Person(1, "Дурин", "Кхазад-Дум", 160 ));
            list.add(new Person(2, "Торин", "Эребор", 99));
            list.add(new Person(3, "Трар", "Эребор", 120));
            list.add(new Person(4, "Трор", "Эребор", 138));
            list.add(new Person(5, "Дурин6", "Кхазад-Дум", 218));

            for (int i = 0; i < list.size(); i++) {
                Assertions.assertTrue(repository.addPerson(list.get(i)));
            }
    }

    /**
     * Added information to the table. Table person not created
     * @throws SQLException
     */
    @Test
    void addInformationError() throws SQLException {

           ProductRepository repository = new ProductRepository();
           Person person = new Person(1, "Дурин6", "Кхазад-Дум", 218);

           Assertions.assertFalse(repository.addPerson(person));
    }

    /**
     * Read information for table.
     * @throws SQLException
     */
    @Test
    void ReadTable()  {
        String sql = "CREATE TABLE person (" +
                "id VARCHAR(50)," +
                "name VARCHAR(50)," +
                "age VARCHAR(50)," +
                "city VARCHAR(100)" +
                ");";

        ProductRepository repository = new ProductRepository();
        System.out.println(repository.readAllPersons());

    }

    /**
     * Changing information to new.
     * @throws SQLException
     */
    @Test
    void changeName () throws SQLException {

            ProductRepository repository = new ProductRepository();
            Assertions.assertTrue(repository.changeAge(2, 119));
    }

    /**
     * Changing information to new.Error input information
     * @throws SQLException
     */
    @Test
    void changeNameError () throws SQLException {

           ProductRepository repository = new ProductRepository();
            Assertions.assertFalse(repository.changeAge(150, 118));
    }

    /**
     * Delete table.
     * @throws SQLException
     */
    @Test
    void deleteTable() throws SQLException {

        String nameTable = "DROP TABLE person";

            ProductRepository repository = new ProductRepository();
            Assertions.assertTrue(repository.deleteTable(nameTable));
    }

    /**
     * Delete table.Will be name table error.
     * @throws SQLException
     */
    @Test
    void deleteTableError() throws SQLException {

        String nameTable = "DROP TABLE person12345";

        ProductRepository repository = new ProductRepository();
        Assertions.assertFalse(repository.deleteTable(nameTable));
    }
}

