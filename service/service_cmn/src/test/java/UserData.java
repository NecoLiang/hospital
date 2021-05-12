import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liangyt
 * @create 2021-04-17 23:12
 */
@Data
public class UserData {
    @ExcelProperty("用户编号")
    private int uid;
    @ExcelProperty("用户名称")
    private String userName;

}
