package member.mapper;

import entity.User;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:14:03
 **/
public interface UserMapper {
    User selectUserByName(String userName);
}
