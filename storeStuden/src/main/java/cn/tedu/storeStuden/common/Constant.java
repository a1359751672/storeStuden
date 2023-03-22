package cn.tedu.storeStuden.common;

import cn.tedu.storeStuden.entity.JsonResult;
import cn.tedu.storeStuden.entity.User;

//常用的静态常量
public class Constant {
    public static final int MD5_HASH_TIME = 5;  //密码哈希迭代次数
    public static final int USER_GANDER_FEMALE = 0; //性别编号女性
    public static final int USER_GANDER_MALE = 1;//性别编号男性
    public static final int USER_GANDER_UNKNOWN = 2;//性别编号未知
    public static final int  IS_NOT_DELETE = 0; //标记数据未被删除
    public static final int  IS_DELETE = 1; //标记数据已被删除

    public static final JsonResult<User> JR_NOT_LOGGEDIN = new JsonResult<>(2004,"未登录");

    public static final int MAX_ADDRESS = 8; //最大收获地址条数
    public static final int IS_NOT_DEFAULT = 0; // 不是默认收获地址
    public static final int IS_DEFAULT = 1; //是默认收货地址
}
