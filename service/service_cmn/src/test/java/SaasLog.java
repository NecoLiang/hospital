import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangyt
 * @create 2021-05-30 10:24
 */
@Data
public class SaasLog {
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * openID
     */
    private String openId;

    /**
     * 商户id
     */
    private Integer bussinessId;

    /**
     * 创建时间
     */
    private Date createStime;

    /**
     * 更新时间
     */
    private Date updateStime;

}
