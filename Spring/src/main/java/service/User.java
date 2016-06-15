package service;

import bean.UsersEntity;

/**
 * Created by zzyo on 2016/5/28.
 */
public interface User {

    //用户注册
    public String register(UsersEntity usersEntity);

    //用户登陆
    public String login(UsersEntity usersEntity);

    //用户登出
    public  String logout(UsersEntity usersEntity);

    //检查MAC Email是否被注册
    public String vaildRegist(UsersEntity usersEntity);
}
