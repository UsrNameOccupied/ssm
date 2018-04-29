package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Items;
import po.ItemsExample;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Items record);
    Items selectByPrimaryKey(Integer id);
    int updateByPrimaryKeyWithBLOBs(Items record);
}