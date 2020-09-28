### 一、回顾

```

```

### 二、ModelAttribute和SessionAttribute注解的使用

```
1) ModelAttribute(请求范围)
	 a.标记了ModelAttribute注解的方法在执行控制器中任何一个方法时都会执行
     b.如果没有传递某个参数， 会从@ModelAttribute标记的方法获取参数值，进行赋值
    	@ModelAttribute
        public User showModel(String username){
            //模仿去数据库中查询了一个用户
            User a = getByName(username);
            System.out.println("showModel"+a);
            return a;
        }

        @RequestMapping("/testModelAttribute")
        public String testModelAttribute(User  user){
            // 如果没有传递某个参数， 会从@ModelAttribute标记的方法获取参数值，进行赋值
            System.out.println("testModelAttribute"+ user);
            return "show";
        }


        /**
         * 用来模仿根据姓名查询用户
         * @return
         */
        public User getByName(String name){
            User user = new User();
            user.setId(5);
            user.setUsername("maliu");
            user.setAge(30);
            return user;
        }
	c.  基于map集合
	@ModelAttribute
    public void showModel(String username, Map<String ,User> map){
        //模仿去数据库中查询了一个用户
        User a = getByName(username);
        map.put("abc",a);
        System.out.println("showModel"+a);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User  user){
        // 如果没有传递某个参数， 会从@ModelAttribute标记的方法获取参数值，进行赋值
        System.out.println("testModelAttribute"+ user);
        return "show";
    }
    注意：如果控制器中方法特别多，不适合使用
2) SessionAttributes：多次请求可以访问
	//一般用来保存中要的信息（账号的信息）
@SessionAttributes(value = {"username","password"})
public class TestSessionAttribute {
    /**
     * 将属性值添加session域中
     */
    @RequestMapping("/testPut")
    public String testPut(Model model){
        model.addAttribute("username","zhangsan");
        model.addAttribute("password","123");
        return "show";
    }

    /**
     * 从session域中获取信息
     */
    @RequestMapping("/testGet")
    public String testGet(ModelMap modelMap){
        System.out.println(modelMap.get("username"));
        System.out.println(modelMap.get("password"));
        return "show";
    }
    /**
     * 清除session
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/testClean")
    public String testClean(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "show";
    }
}
	
```

### 三、RestFul风格

```
1) 什么是Restful?
	是一种的新规范，并不是规则
	一种URL传递参数的新形势,以前我们传一个id参数应该是UserViewAction/findUserbyID?id=1
	restful 可以写成
	UserViewAction/findUserbyID/1
2) 优势
	简单直接,安全
3) Restful请求方法
	GET : 一般用来做查询
	POST： 保存
	PUT： 更新
	DELETE： 删除
4）注意：如果使用put和delete ，方法返回值必须返回字符串或者json
5) java代码
	/**
     *
     * 通过路径请求，默认get请求
     * @PathVariable("id"):把路径中的属性映射参数中
     * @param id
     * @return
     */
    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }


    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.POST)
    public String testPost(@PathVariable("id")Integer id,String username){
            System.out.println(id);
            return "show";
    }


    /**
     * @ResponseBody
     *  标记你的方法的返回为json或者为字符串格式
     * @param id
     * @return
     */
    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testPut(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }


    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testDel(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }
6） 页面数据
	a. get请求
	localhost:8080/testOperate/2

	b. <%--栗子2： 测试restful风格的post请求--%>
    <form action="${pageContext.request.contextPath}/testOperate/2" method="post">
        <input type="text" name="age">
        <input type="text" name="username">
        <input type="submit" >
    </form>


    c. <%--栗子3： 测试restful风格的PUT请求--%>
    <%--如果使用put和delete提交方法，name表单的提交必须指定post提交--%>
    <form action="${pageContext.request.contextPath}/testOperate/2" method="post">
        <%--设置隐藏域：属性名是_method ，值为put，name提交方式就变成了PUT提交--%>
        <input type="hidden" name="_method" value="PUT">
        <input type="text" name="age">
        <input type="text" name="username">
        <input type="submit" >
    </form>

    4. <%--栗子4： 测试restful风格的PUT请求--%>
    <form action="${pageContext.request.contextPath}/testOperate/2" method="post">
        <%--设置隐藏域：属性名是_method ，值为put，name提交方式就变成了PUT提交--%>
        <input type="hidden" name="_method" value="DELETE">
        <input type="text" name="age">
        <input type="text" name="username">
        <input type="submit" >
    </form>
```

### 四、控制器方法的返回值

```
1) 返回值的分类:
	返回值为String类型
	返回值类型为void
	返回值为ModelAndView类型
2) 转发和重定向
	重定向：redirect 
	转发：  forward
	/**
     * 如果返回值为字符串通过视图解析器，返回一个页面
     *
     * @return
     */
    @RequestMapping("/show")
    public String show(){
        return "show";
    }


    /**
     * 如果返回值为字符串
     * 如果标记了@ResponseBody,那么会按照流的方式返回页面
     *
     * @return
     */
    @RequestMapping("/show1")
    @ResponseBody
    public String show1(){
        return "show";
    }

    /**
     * 不设置返回值
     * 会拿着请求路径在视图解析器中查找页面 -- 一般会有404问题
     */
    @RequestMapping("/show2")
    public void show2(){
        System.out.println("执行show2的方法");
    }

    /**
     * 不设置返回值
     * 可以使用servlet API中的方法去设置返回页面
     */
    @RequestMapping("/show3")
    public void show3(HttpServletRequest request , HttpServletResponse response){
        System.out.println("执行show3的方法");
//        重定向
//        try {
//            response.sendRedirect("/index.jsp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //转发请求的路径
        try {
            request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ModelAndView : 模型和视图
     *
     * 如果需要向页面传递大量的数据，就可以ModelAndView对象
     */
    @RequestMapping("/show4")
    public ModelAndView show4(){
        //将来从数据库查询数据

        ModelAndView modelAndView = new ModelAndView();
        //向请求域添加对象
        modelAndView.addObject("username","zhangsan");
        modelAndView.addObject("user",new User());
        // 设置页面路径: 会自动进入到视图解析器包装成jsp返回页面
        modelAndView.setViewName("show");

        return modelAndView;
    }
    /**
     *
     * @return
     */
    @RequestMapping("/testShow")
    public String testShow(){
        return "show";
    }

    /**
     *forward:转发
     * 如果写了forward，不会走视图解析器
     * @return
     */
    @RequestMapping("/testShow2")
    public String testShow2(){
        System.out.println(":........");
        return "forward:/success.jsp";
    }
    /**
     *redirect:转发
     * 如果写了redirect，不会走视图解析器
     * @return
     */
    @RequestMapping("/testShow3")
    public String testShow3(){
        System.out.println(":........");
        return "redirect:/success.jsp";
    }
```

### 五、交互JSON数据

```
1） 交互json需要引入的jar包坐标
	<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.9.0</version>
    </dependency>
```

### 六、SpringMVC实现文件上传

```
(1) 实现springMVC文件上传
1. <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="uploadFile">
        <input type="submit">
    </form>
2. @RequestMapping("/upload1")
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
  <!-- id的值是固定的-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!-- 设置上传文件的最大尺寸为5MB -->
        <property name="maxUploadSize"> <value>5242880</value></property>
    </bean>
(2) 实现springMVC文件跨服上传
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
  <!--核心-->
    <dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-core</artifactId>
      <version>1.18.1</version>
    </dependency>

    <!--客户端-->
    <dependency>
      <groupId>com.sun.jersey</groupId>
      <artifactId>jersey-client</artifactId>
      <version>1.18.1</version>
    </dependency>
```

### 七、SpringMVC的异常处理

```

```

