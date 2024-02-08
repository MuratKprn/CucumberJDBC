package StepDefinitions;

import Manage.QueryManage;
import Utilities.JDBCReusableMethods;
import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    PreparedStatement preparedStatement;
    QueryManage queryManage = new QueryManage();
    String query;
    ResultSet resultSet;
    int rowCount;

    @Given("Database connection is established")
    public void database_connection_is_established() {

        JDBCReusableMethods.getConnection();
    }

    @Given("Query01 is prepared and executed")
    public void query_is_prepared_and_executed() throws SQLException {

        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet01 are processed")
    public void result_set01_are_processed() throws SQLException {
        resultSet.next();
        int actual = resultSet.getInt("user_id");
        int expected = 1;

        assertEquals(expected,actual);
    }

    @Given("Close the database connection")
    public void close_the_database_connection() {

        JDBCReusableMethods.closeConnection();
    }

    @Given("Query02 is prepared and executed")
    public void query02_is_prepared_and_executed() throws SQLException {

        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet02 results are processed")
    public void result_set02_results_are_processed() throws SQLException {

        List<String> names = new ArrayList<>();
        while(resultSet.next()) {
            String name = resultSet.getString("name");
            names.add(name);
        }

        List<String> expectedName = new ArrayList<>();
        expectedName.add("5 Minutes");
        expectedName.add("10 Minutes");

        for(int i = 0; i < names.size(); i++){
            assertEquals(expectedName.get(i),names.get(i));
            System.out.println(i +". index confirmed");
        }
    }

    @Given("Query03 is prepared and executed")
    public void query03_is_prepared_and_executed() throws SQLException {

        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet03 results are processed")
    public void result_set03_results_are_processed() throws SQLException {

        String expectedName= "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname")+ " " + resultSet.getString("lastname");

        assertEquals(expectedName,actualName);
        System.out.println("expected= " + expectedName);
        System.out.println("actual= " + actualName);
    }

    @Given("Query04 is prepared and executed")
    public void query04_is_prepared_and_executed() throws SQLException {

        query= queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }

    @Given("ResultSet04 results are processed")
    public void result_set04_results_are_processed() throws SQLException {

        while(resultSet.next()){
            String user = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("User_id " + user);
            System.out.println("Browser & OS " + browserOS);
        }
    }

    @Given("Create and execute Update01")
    public void create_and_execute_update01() throws SQLException {
        query = queryManage.getUpdate01();
        rowCount = JDBCReusableMethods.updateQuery(query);
    }

    @Given("Verify the results of Update1")
    public void verify_the_results_of_update1() {

        assertEquals(18, rowCount);
    }

    @Given("Create and execute Prepared01")
    public void create_and_execute_prepared01() throws SQLException {

        query= queryManage.getPrepared01();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 444444444);
        preparedStatement.setString(2, "%e_");

        rowCount = preparedStatement.executeUpdate();
    }

    @Given("Verify the results of Prepared1")
    public void verify_the_results_of_prepared1() {

        assertEquals(18,rowCount);
    }

    @Given("Create and execute Prepared02")
    public void create_and_execute_prepared02() throws SQLException {

        query= queryManage.getPrepared02();

        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,125);
        preparedStatement.setString(2,"email33@gmail.com");
        preparedStatement.setString(3,"125478");
        preparedStatement.setInt(4,1);

        rowCount = preparedStatement.executeUpdate();
    }

    @Given("Verify the results of Prepared2")
    public void verify_the_results_of_prepared2() {

        assertEquals(1,rowCount);
    }


}
