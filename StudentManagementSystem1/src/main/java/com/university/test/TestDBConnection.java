package com.university.test;

import com.university.util.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        // Cố gắng kết nối đến cơ sở dữ liệu
        try {
            Connection connection = DBUtil.getConnection();
            if (connection != null) {
                System.out.println("Ket noi thanh cong!");
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
            // Đóng kết nối sau khi sử dụng
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            // In ra lỗi nếu có vấn đề khi kết nối
            System.out.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
