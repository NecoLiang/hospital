import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.SimpleTimeZone;

/**
 * @author liangyt
 * @create 2021-05-30 10:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void  test1() {
        SaasLog saasLog = new SaasLog();

        ArrayList<String> userList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {


            saasLog.setId(i);
            saasLog.setUserId("666");
            saasLog.setBussinessId(i);
            saasLog.setCreateStime(new Date());
            saasLog.setUpdateStime(new Date());

//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String format = simpleDateFormat.format(saasLog.getCreateStime().getTime());
            Long time1 = saasLog.getCreateStime().getTime();
            double v = time1.doubleValue();
            String s = JSON.toJSONString(saasLog);
        }
        redisTemplate.opsForValue().set(saasLog.getUserId(), 1);
//            redisTemplate.opsForZSet().add(saasLog.getUserId(), saasLog, v);
        Set<Object> range = redisTemplate.opsForZSet().range(saasLog.getUserId(), 0, -1);
        System.out.println(range.toArray());
    }

}
