import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;

/**
 * @author liangyt
 * @create 2021-04-17 23:15
 */
public class TestWrite {
    public static void main(String[] args) {
        ArrayList<UserData> list = new ArrayList<>();
        for (int i = 0; i <10; i++) {
        UserData userData = new UserData();
            userData.setUid(i);
            userData.setUserName("user"+i);
            list.add(userData);
        }
        //设置excel的文件路径和文件名称
        String fileName = "D:\\TestWriteExcel\\01.xlsx";
        //调用方法实现写操作
        EasyExcel.write(fileName,UserData.class).sheet("用户信息").doWrite(list);
    }
}
