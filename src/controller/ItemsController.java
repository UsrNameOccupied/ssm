package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import po.Items;
import po.ItemsCustom;
import service.ItemsService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by codingBoy on 16/11/15.
 */
@Controller
//定义url的根路径，访问时根路径+方法名的url
@RequestMapping("/items")
public class ItemsController extends BaseController {

    //注入service
    @Autowired
    private ItemsService itemsService;
    
    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception {
        //调用servie来查询商品列表
        List<ItemsCustom> itemsList=itemsService.findItemsList(null);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }

    //方法返回字符串，字符串就是逻辑视图名，Model作用时将数据填充到request域，在页面显示
    @RequestMapping(value = "/editItems",method = RequestMethod.GET)
    public String editItems(Model model, Integer id) throws Exception
    {
        //将id传到页面
        model.addAttribute("id",id);
        //调用service查询商品的信息
        ItemsCustom itemsCustom=itemsService.findItemsById(id);
        model.addAttribute("itemsCustom",itemsCustom);
        return "editItem";
    }

    //商品提交页面
    //itemsQueryVo是包装类型的pojo
    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Model model,ItemsCustom itemsCustom) throws Exception
    {
        //进行数据回显
        model.addAttribute("id",itemsCustom.getId());
        itemsService.updateItems(itemsCustom.getId(),itemsCustom);
        return "editItem";
    }
}
