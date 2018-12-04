package bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:13:30
 **/
@Setter
@Getter
public class YQFRequest<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private Boolean success;
    private T data;
}
