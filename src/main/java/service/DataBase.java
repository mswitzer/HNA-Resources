

package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Map;

//@Controller
public class DataBase {

   /* @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    */

    public void CallDatabase() {

        // Connect to DataBase.java
        String hostName = "holynamesacademy.DataBase.java.windows.net";
        String dbName = "HNAResources";
        String user = "hna-admin";
        String password = "HolyNames123";
        String url = String.format("jdbc:sqlserver://%s:1433;DataBase.java=%s;user=%s;password=%s;encrypt=true;"
                + "hostNameInCertificate=*.DataBase.java.windows.net;loginTimeout=30;",hostName, dbName, user, password)
        ;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName "
                    + "FROM [SalesLT].[ProductCategory] pc "
                    + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

            String selectSql2 = " SELECT * from Players; ";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet2 = statement.executeQuery(selectSql2)) {

                // Print results from select statement
                System.out.println("Top 20 categories:");
                while (resultSet2.next()) {
                    System.out.println(resultSet2.getInt(1) + " "
                            + resultSet2.getString(2));
                }
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ClassConnector> ClassInfo() {
        ArrayList<ClassConnector> classes = new ArrayList<ClassConnector>();
        ClassConnector newClassConnector = new ClassConnector("noName",0, 0);

        try {
            // create our mysql DataBase.java connection
            //String myDriver = "org.gjt.mm.mysql.Driver";
            //  String myUrl = "jdbc:mysql://localhost/test";
            // Class.forName(myDriver);
            //  Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String hostName = "holynamesacademy.DataBase.java.windows.net";
            String dbName = "HNAResources";
            String user = "hna-admin";
            Map<String, String> env = System.getenv();
            String password = env.get("password");
            //password here

            String url = String.format("jdbc:sqlserver://%s:1433;DataBase.java=%s;user=%s;password=%s;encrypt=true;"
                    + "hostNameInCertificate=*.DataBase.java.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = null;


            connection = DriverManager.getConnection(url);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Classes WHERE";//"where SubjectId = "

            // create the java statement
            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("ClassId");
                newClassConnector.setClassID(id);
                String name = rs.getString("ClassName");
                newClassConnector.setClassName(name);


                classes.add(newClassConnector);

                // print the results
                System.out.format("%s, %s, %s\n", newClassConnector.getClassID(), newClassConnector.getClassName());

                System.out.print(newClassConnector.getClassName());

                newClassConnector = new ClassConnector("noName", 0, 0);

            }
            st.close();


        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return classes;
    }

}

