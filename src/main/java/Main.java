import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection succesfull!");
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists employees (Employee_ID int, First_Name varchar(50), Last_Name varchar(50), Department varchar(50), Salary int, primary key (Employee_ID));");
            // statement.execute("insert into employees (Employee_ID, First_Name, Last_Name, Department, Salary) values (1, 'John', 'Smith', 'Development', 5000)");
            // statement.execute("insert into employees (Employee_ID, First_Name, Last_Name, Department, Salary) values (2, 'NicK', 'Johnson', 'Development',6000);");
            // statement.execute("insert into employees (Employee_ID, First_Name, Last_Name, Department, Salary) values (3, 'Mary', 'Johnson', 'Sales',4000);");
            // statement.execute("insert into employees (Employee_ID, First_Name, Last_Name, Department, Salary) values (4, 'Cristopher', 'Robin', 'Sales' ,4000);");
            // statement.execute("insert into employees (Employee_ID, First_Name, Last_Name, Department, Salary) values (5, 'Harry', 'Gates', 'Management' ,8000);");
            ResultSet resultSet = statement.executeQuery("SELECT Department, sum(Salary) as Salary FROM employees GROUP BY Department");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Department") + ": " + resultSet.getInt("Salary"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
