package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BaseController {

    @InitBinder    
    public void initBinder(WebDataBinder binder) {
    	// PO对象确实是有Date类型属性的，而页面上传的是String类型，springMVC在自动接收参数转换时可能会出现问题，报告400错误。
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));   
    }
}