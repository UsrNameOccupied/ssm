package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;
import service.ItemsService;
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
        List<Items> itemsList=itemsService.findItemsList();

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
        //调用service查询商品的信息
        Items items=itemsService.findItemsById(id);

        //将id传到页面
        model.addAttribute("id",id);
        model.addAttribute("itemsCustom",items);
        return "editItem";
    }

    //商品提交页面
    //itemsQueryVo是包装类型的pojo
    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Model model,Items items) throws Exception
    {
        //进行数据回显
        itemsService.updateItems(items.getId(),items);

        model.addAttribute("id",items.getId());
        model.addAttribute("itemsCustom",items);
        return "editItem";
    }
}
