import java.sql.*;

public class Main {

    private static final String url= "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username= "root";
    private static final String password ="12345678";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = String.format
                    ("INSERT INTO  students (name, age, marks) " +
                            "VALUES('%s', %o, %f)", "Rohan", 22, 95.5);

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected > 0){
                System.out.println("Data Inserted Successfully!");
            } else{
                System.out.println("Data not Inserted!");
            }

//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//                System.out.println("ID: " +id);
//                System.out.println("NAME: " +name);
//                System.out.println("AGE: " +age);
//                System.out.println("MARKS: " +marks);
//
//            }


        }
        catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }
}