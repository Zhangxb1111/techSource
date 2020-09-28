package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class UploadController {


    /**
     * 上传到图片服务器
     * @param uploadFile
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile  , HttpServletRequest request){

        //生成一个随机的文件名称
        String uuidName  = UUID.randomUUID().toString().replace("-","");
        //获取文件的后缀名
        //获取文件的真实的名称
        String originalFilename = uploadFile.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //就是我上传服务器的文件的名称
        String serverFileName = uuidName + extendName;

        //把当前的时间作为路径
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String dateName = format.format(new Date());

        //创建jersey客户端对象
        Client client = Client.create();
        String url = "http://localhost:9090/img_server/upload/"+ serverFileName;
        System.out.println(url);
        //创建资源，指定上传的位置
        WebResource resource = client.resource(url);
        //实现真正的上传
        String result = null;
        try {
            result = resource.put(String.class, uploadFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return "redirect:/index.jsp";
    }


    @RequestMapping("/upload1")
    public String upload1(MultipartFile uploadFile  , HttpServletRequest request){

        //生成一个随机的文件名称
        String uuidName  = UUID.randomUUID().toString().replace("-","");
        //获取文件的后缀名
            //获取文件的真实的名称
        String originalFilename = uploadFile.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //就是我上传服务器的文件的名称
        String serverFileName = uuidName + extendName;
    
        //把当前的时间作为路径
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String dateName = format.format(new Date());

        //获取当前服务器的绝对路径
        //servlet的上下文对象
        ServletContext servletContext = request.getSession().getServletContext();
        //就是得到绝对路径
        String upload = servletContext.getRealPath("upload");

        File file = new File(upload +"\\" + dateName + "\\" );
        //判断不存在时候，去创建路径
        if(!file.exists()){
            file.mkdirs();
        }

        //最后一步的操作：提交文件到指定路径
        try {
            uploadFile.transferTo(new File(file , serverFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/index.jsp";
    }
}
