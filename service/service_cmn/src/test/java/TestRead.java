import com.alibaba.excel.EasyExcel;

import javax.servlet.ReadListener;

/**
 * @author liangyt
 * @create 2021-05-16 21:48
 */
public class TestRead {
    public static void main(String[] args) {
        //读取文件的路径
        String fileName = "D:\\TestWriteExcel\\01.xlsx";
        //调用方法实现读取操作
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();
    }
}
