package com.university.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // Thông tin kết nối cơ sở dữ liệu
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";  // URL kết nối đến cơ sở dữ liệu
    private static final String USER = "root";  // Tên người dùng cơ sở dữ liệu (thay đổi nếu cần)
    private static final String PASSWORD = "Trungtin@1";  // Mật khẩu (thay đổi nếu cần)

    // Khối static để nạp driver của MySQL
    static {
        try {
            // Nạp driver của MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lấy kết nối đến cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Phương thức để đóng kết nối cơ sở dữ liệu
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

