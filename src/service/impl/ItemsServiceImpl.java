package service.impl;

import mapper.ItemsMapper;
import pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import service.ItemsService;
import java.util.List;

/**
 * Created by codingBoy on 16/11/15.
 */
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    //商品的查询列表
    @Override
    public List<Items> findItemsList() throws Exception {
        return itemsMapper.findItemsList();
    }

    @Override
    public Items findItemsById(int id) throws Exception {
        Items items=itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItems(Integer id,Items items) throws Exception {
        //在service中一定要写业务代码
        //对于关键业务数据的非空校验
        if (id==null)
        {
            //抛出异常，提示调用接口的用户，id不能唯恐
            //...
        }

        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
