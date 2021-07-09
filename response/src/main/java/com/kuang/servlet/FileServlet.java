package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String filePath = "D:\\codeworkspace\\IDEA\\javaweb-01-maven02\\response\\src\\main\\resources\\小兴.png";
       String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
       resp.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

        FileInputStream in = new FileInputStream(filePath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while((len=in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        out.close();
        in.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
