package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public void upload(String username , MultipartFile uploadFile, HttpServletRequest request){
        //1. 随机名
        String randomName = UUID.randomUUID().toString().replace("-", "");
        System.out.println(randomName);
        //2. 扩展名
        //获取真实的文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //文件的扩展名：  .txt .jpg
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(extendName);
        //3. 服务器路径
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("uploads");
        // 4. 时间路径

        // 5. 上传的目录文件
        File fileName = new File(realPath);
        if(!fileName.exists()){
            fileName.mkdirs();
        }
        //创建上传的文件:指定文件名，指定路径
        File file = new File(fileName,randomName+extendName );

        System.out.println(realPath);
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Account> accountList = accountService.findAll();

        for (Account account : accountList) {
            System.out.println(account.getUsername());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("show");
        return modelAndView;
    }


    /**
     * 删除账户
     * @param id
     */
    @RequestMapping("/del")
    public String del(Integer id){
        //删除完成后：
        accountService.del(id);
        //需要再次上数据库中查询
        return "redirect:/account/findAll";
    }

    /**
     * 更新数据回显
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        Account account = accountService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account",account);
        modelAndView.setViewName("account-update");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Account account){
        accountService.update(account);
        return "redirect:/account/findAll";
    }

    @RequestMapping("/save")
    public String save(Account account){

        accountService.save(account);

        return "redirect:/account/findAll";
    }

}
