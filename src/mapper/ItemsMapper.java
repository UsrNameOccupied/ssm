package mapper;

import java.util.List;

import pojo.Items;

public interface ItemsMapper {
    int insert(Items record);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeyWithBLOBs(Items record);
    Items selectByPrimaryKey(Integer id);
	// 商品查询列表
	List<Items> findItemsList() throws Exception;
}