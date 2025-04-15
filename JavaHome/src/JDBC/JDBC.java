package JDBC;
import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        // Verilənlər bazasına qoşulmaq üçün məlumatlar
        String url = "jdbc:mysql://localhost:3306/school"; // MySQL bağlantısı
        String user = "root"; // MySQL istifadəçi adı
        String password = ""; // Şifrə (boş ola bilər)

        try {
            // 1. JDBC sürücüsünü yükləmək
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Verilənlər bazasına qoşulmaq
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Verilənlər bazasına uğurla qoşuldu!");

            // 3. SQL sorğusu icra etmək
            String query = "SELECT * FROM students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // 4. Nəticələri çap etmək
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Ad: " + name + ", Yaş: " + age);
            }

            // 5. Bağlantını bağlamaq
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
