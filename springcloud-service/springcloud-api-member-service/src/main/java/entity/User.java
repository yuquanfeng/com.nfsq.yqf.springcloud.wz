package entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:34
 **/
@Setter
@Getter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private Integer id;
    private Integer userAge;
}
