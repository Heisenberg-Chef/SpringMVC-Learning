package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class fileControl {
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException {

        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : "+uploadFileName);

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        request.getServletContext().setAttribute("message","文件上传成功");
        return "redirect:/index.jsp";
    }

    /**
     * 采用file.Transto 老保存上传的文件
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        // 上传保存路径设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists())
        {
            realPath.mkdir();
        }

        // 上传文件地址
        System.out.println("上传文件保存地址 : " + realPath);

        // 通过CommonsMultipart的方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String downloads(HttpServletResponse resp,HttpServletRequest req) throws IOException {
        // 要下载文件的地址
        String path = req.getServletContext().getRealPath("/upload");
        String  fileName = "New File.htm";
        // 设置response响应头
        resp.reset();   // 设置页面不缓存,清空buffer
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("multipart/form-data"); // 二进制传输数据
        // 设置响应头
        resp.setHeader("Content-Disposition","attachment;fileName="
        + URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = resp.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        req.setAttribute("message","下载完成");
        return "redirect:/index.jsp";
    }
}
