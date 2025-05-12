/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DemoController", urlPatterns = {"/first"})
public class DemoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Client nó gửi request đến cho doGet
        String calculateRaw = request.getParameter("calculate");
        String firstValueRaw = request.getParameter("firstvalue"); // String
        String secondValueRaw = request.getParameter("secondvalue");
        PrintWriter out = response.getWriter();
        try{
            int firstValue = Integer.parseInt(firstValueRaw);
            int secondValue = Integer.parseInt(secondValueRaw);
            int res;
            switch(calculateRaw){
                case "plus":{
                    res = firstValue + secondValue;
                    break;
                }
                case "minus":{
                    res = firstValue - secondValue;
                    break;
                }
                default:{
                    throw new Exception();
                }
            }
            out.println(res);
        }catch(Exception e){
            out.println("Invalid input.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String calculateRaw = request.getParameter("calculate");
        String firstValueRaw = request.getParameter("firstvalue"); // String
        String secondValueRaw = request.getParameter("secondvalue");
        PrintWriter out = response.getWriter();
        try{
            int firstValue = Integer.parseInt(firstValueRaw);
            int secondValue = Integer.parseInt(secondValueRaw);
            int res;
            switch(calculateRaw){
                case "plus":{
                    res = firstValue + secondValue;
                    break;
                }
                case "minus":{
                    res = firstValue - secondValue;
                    break;
                }
                default:{
                    throw new Exception();
                }
            }
            out.println(res);
        }catch(Exception e){
            out.println("Invalid input.");
        }
    }
}    

/*BTVN:
    1. Viết lại bài toán này và bổ sung thêm phép tính trừ
    2. Viết Webapp: context path: /login
                        URL pattern: /process
        Nhập vào 2 giá trị username và password
        So sánh với tài khoản: "Admin", "123"
            Nếu đúng trên thì login successfully
                ngược lại là login failed
    3. search Ytb: TITV JDBC xem từ 01 tới 08
*/

