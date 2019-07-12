package redoc.sq.base.conts;

public class RequestCode {
    /**
     * 通用异常code
     */
    public static final String GENERAL_EXCEPTION = "255";
    /**
     * 生成二维码code
     */
    public static final String GENERATE_QR_CODE = "102";
    /**
     * Websocket心跳
     */
    public static final String WEBSOCKET_PING = "1001";
    /**
     * 允许登录code
     */
    public static final String ALLOW_LOGIN_CODE = "103";
    /**
     * 预约重复code
     */
    public static final String REPEAT_APPOINTMENT_CODE = "104";
    /**
     * 手机已存在
     */
    public static final String REPEAT_MOBILE = "105";
    /**
     * 手机验证码错误
     */
    public static final String MOBILE_VERIFICATION_ERROR = "106";
    /**
     * 身份证号不存在
     */
    public static final String ID_CARD_NOT_EXISTS = "107";
    /**
     * 用户不存在
     */
    public static final String USER_NOT_EXISTS = "108";
    /**
     * 交易密码错误
     */
    public static final String TRADEPASSWORD_ERROR = "109";
    /**
     * 未找到token
     */
    public static final String TOKEN_NOT_FOUND = "110";
    /**
     * token过期
     */
    public static final String TOKEN_EXPIRED = "111";
    /**
     * 赠送用户不存在
     */
    public static final String USER_GIVE_NOT_EXISTS = "112";
    /**
     * 用户信息不一致
     */
    public static final String USER_ID_ILLEGAL_EXCEPTION = "113";
    /**
     * 短信服务异常
     */
    public static final String SMS_SERVICE_EXCEPTION = "114";
    /**
     * 验证码重复发送异常
     */
    public static final String REPEAT_VALID_CODE_ERROR = "115";
    /**
     * 新旧手机不能相同
     */
    public static final String NEW_OLD_MOBILE_CANNT_SAME = "116";
    /**
     * 新手机已经注册
     */
    public static final String REPEAT_NEW_MOBILE = "117";
    /**
     * 同一手机号发送间隔过短
     */
    public static final String SAME_MOBILE_TOO_SHORT = "118";
    /**
     * 非法参数
     */
    public static final String PARAMS_ILLEGAL = "120";
    /**
     * 交易密码不能与密码相同
     */
    public static final String TRADEPASSWORD_IS_THE_SAME_AS_PASSWORD_ERROR = "121";
    /**
     * 上传文件异常
     */
    public static final String UPLOAD_AVATAR_ERROR = "122";
    /**
     * 繁育宠物失败
     */
    public static final String SIRING_PET_FAILED = "123";
    /**
     * 身份认证状态有误
     */
    public static final String CERTIFICATION_STATUS_ERROR = "124";
    /**
     * 邮箱验证码错误
     */
    public static final String MAIL_VERIFICATION_ERROR = "125";
    /**
     * 设置新邮箱失败
     */
    public static final String SET_NEW_EMAIL_ERROR = "126";
    /**
     * 手机号不存在
     */
    public static final String MOBILE_NOT_EXISTS = "128";
    /**
     * webSocket连接断开code
     */
    public static final String WEBSOCKET_DISCONNECTED = "201";
    /**
     * 账号/密码错误
     */
    public static final String USERNAME_OR_PASSWORD_ERROR = "202";
    /**
     * 宠物状态有误
     */
    public static final String STATUS_ERROR = "203";
    /**
     * 手机不一致
     */
    public static final String MOBILE_ERROR = "204";
    /**
     * 邮箱不一致
     */
    public static final String MAIL_ERROR = "205";
    /**
     * 图片验证码错误
     */
    public static final String PICTURE_VALID_CODE_ERROR = "206";
    /**
     * 调区块链失败
     */
    public static final String BLOCKCHAIN_SERVICE_ERROR = "207";
    /**
     * 余额不足
     */
    public static final String AMOUNT_ERROR = "208";
    /**
     * 领取宠物错误
     */
    public static final String DRAW_PET_ERROR = "209";
    /**
     * 宠物已经被领取错误
     */
    public static final String HAVE_DRAW_PET_ERROR = "210";
    /**
     * 连续看的两条广告的间隔时间太短
     */
    public static final String ADVERT_INTERVAL_TOO_SHORT_ERROR = "211";
    /**
     * 连续两条反馈的间隔时间太短
     */
    public static final String FEEDBACK_INTERVAL_TOO_SHORT_ERROR = "212";
    /**
     * 钱包地址不足
     * */
    public static final String WALLET_ADDRESS_NOT_ENOUGH_ERROR = "213";
    /**
     * 没有宠物不允许进行商城商品兑换
     */
    public static final String NO_PET_NOT_ALLOW_MALL_ERROR = "214";
    /**
     * 商品状态有误，无法购买
     */
    public static final String GOODS_STATUS_ERROR = "215";
    /**
     * 商品库存为0
     */
    public static final String GOODS_STORE_ZERO_ERROR = "216";
    /**
     * 未绑定手机
     */
    public static final String MOBILE_NOT_BIND = "217";
    /**
     * 守护码不存在
     */
    public static final String GUARD_CODE_NOT_EXISTS_ERROR = "218";
    /**
     * 体力不足
     */
    public static final String FATIGUE_INSUFFICIENT = "219";
    /**
     * 手机已绑定
     */
    public static final String MOBILE_HAS_BIND = "220";
    /**
     * 持续时间为0
     */
    public static final String DURATIVE_TIME_ERROR = "221";
    /**
     * 数据已存在
     */
    public static final String DATA_REPEAT_ERROR = "222";

    /** 短信API异常状态 */
    public static final String MOBILE_NUMBER_ILLEGAL = "300";
    public static final String RAM_PERMISSION_DENY = "301";
    public static final String OUT_OF_SERVICE = "302";
    public static final String ACCOUNT_ABNORMAL = "303";
    public static final String INVALID_PARAMETERS = "304";
    public static final String SYSTEM_ERROR = "305";
    public static final String MOBILE_COUNT_OVER_LIMIT = "306";
    public static final String BUSINESS_LIMIT_CONTROL = "307";
    public static final String BLACK_KEY_CONTROL_LIMIT = "308";
    public static final String AMOUNT_NOT_ENOUGH = "309";
    /** 短信API异常状态 */

    public static final String VALIDATION_STR_PAST = "310";

    public static final String VALIDATION_STR_ERROR = "311";

    /**
     * 邮箱为空
     */
    public static final String MAIL_IS_NULL = "127";
    /**
     * 邮箱已存在
     */
    public static final String EMAIL_ALREADY_EXISTS = "129";
    /**
     * websocket断开异常
     */
    public static final String WEBSOCKET_EXCEPTION = "130";
    /**
     * 无效的邀请码
     */
    public static final String INVALID_INVITATION_CODE_EXCEPTION = "131";
    /**
     * 验证码已失效
     */
    public static final String VERIFICATION_CODE_HAS_EXPIRED = "132";
}
