/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/process"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String usernameRaw = request.getParameter("username");
        String passwordRaw = request.getParameter("password");
        String message = "";
        
        if(usernameRaw.isEmpty() || passwordRaw.isEmpty()){
            message = "username and password are required!";
        }else if(!usernameRaw.equals("Admin") || !passwordRaw.equals("123")){
            message = "Login failed!";
        }else{
            request.setAttribute("name", usernameRaw);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            return;
        }
        
        // Tạo 1 cái thùng trước khi bắn sang trang jsp
        request.setAttribute("message_error", message);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

/*
    1. Bắt buộc dùng EL, JSTL
        Trò chơi con mực: Viết web app có context path: conmuc
            index.jsp: Cho phép user nhập vào 1 số từ 1 đến 5 và 1 nút submit
            RandomController.java (urlPattern: /random)
                viết hàm random để random ra 1 con số
                rồi lấy số random so sánh với số input
                nếu equal thì chuyển qua home.jsp kèm thông báo: lucky man
                nếu !equal thì trả về thông báo: "Chúc bạn may mắn lần sau"
        ** Phát triển: Oẳn tù xì Project :)))

    2. Code chay bằng java, ko dùng EL
        Đăng kí, đăng nhập flow:
            register.jsp: Cho phép user nhập vào các value sau: Họ và tên, username, password, email
            RegisterController.java (urlPattern: /process) => Cho user đăng kí tài khoản, info
            tạo 1 package model, tạo 1 class User.java và lưu thông tin theo dạng Object

            Sau khi register thành công, sẽ gửi thông tin user sang trang profile.jsp
*/
