package com.movie.model.common;

import java.io.Serializable;

public class ResultCode implements Serializable {

    private static final long serialVersionUID = -3358290732064426275L;

    /**
     * 请求参数传递不合法
     */
    public static final ResultCode PARAM_ILLEGAL    = new ResultCode("4001", "数据加载异常，请稍候重试");
    public static final ResultCode PARAM_FOLLOWED    = new ResultCode("4003", "已经关注该用户");
    public static final ResultCode PARAM_FOLLOW_USER_NULL    = new ResultCode("4004", "要关注的用户不存在");
    public static final ResultCode PARAM_UNFOLLOW_USER_NULL    = new ResultCode("4005", "要取消关注的用户不存在");
    public static final ResultCode PARAM_NO_FOLLOW_USER    = new ResultCode("4006", "还未关注该用户");
    public static final ResultCode PARAM_THREAD_NOT_EXIST    = new ResultCode("4007", "要收藏的帖子不存在");
    public static final ResultCode PARAM_USER_NO_LOGIN    = new ResultCode("4008", "用户未登录");
    public static final ResultCode PARAM_SERVICE_ERROR    = new ResultCode("4009", "数据加载异常，请稍候重试");
    public static final ResultCode PARAM_USER_HAS_SIGN = new ResultCode("4010", "用户已签到");
    public static final ResultCode PARAM_USER_NAME_MODIFY_TIME_LIMIT = new ResultCode("4011", "你不久前改过昵称, 等等再改吧");
    public static final ResultCode PARAM_USER_NAME_EXIST = new ResultCode("4012", "昵称已经被占");
    public static final ResultCode PARAM_USER_NAME_MODIFY_FAIL = new ResultCode("4013", "昵称修改失败");
    public static final ResultCode PARAM_USER_NOT_EXIST = new ResultCode("4014", "用户不存在");
    public static final ResultCode PARAM_NOT_BBS_USER    = new ResultCode("4015", "非社区用户");
    public static final ResultCode PARAM_POST_NOT_EXIST    = new ResultCode("4016", "内容不存在");
    public static final ResultCode PARAM_POST_AUTHOR_ILLEGAL    = new ResultCode("4017", "帖子作者不合法");
    public static final ResultCode PARAM_POST_ILLEGAL    = new ResultCode("4018", "该内容被屏蔽");
    public static final ResultCode PARAM_FORUM_NOT_EXIST    = new ResultCode("4019", "小组不存在");
    public static final ResultCode PARAM_OVER_MAX_FOLLOW_NUM    = new ResultCode("4020", "您的关注已达上限2000人");
    public static final ResultCode PARAM_MEMBER_ILLEGAL   = new ResultCode("4021", "您的账号因违规已被封禁, 请联系客服处理");
    public static final ResultCode NO_PERMISSION    = new ResultCode("4022", "权限不足");
    public static final ResultCode PARAM_REPLY_NOT_EXIST    = new ResultCode("4025", "该内容已被删除");
    public static final ResultCode PARAM_DELETE_ERROR    = new ResultCode("4026", "删除失败");
    public static final ResultCode PARAM_OVER_SEND_PRIVATEMSG_NUM = new ResultCode("4027", "您已超过今日给陌生人发送私信的上限");
    public static final ResultCode PARAM_TAG_NOT_EXIST = new ResultCode("4028", "小组不存在");
    public static final ResultCode PARAM_FOLLOW_SELF_DENY = new ResultCode("4029", "不能关注自己");

    // ---------------模型结构------------------
    private String                 errorCode;
    private String                 errorMessage;

    public ResultCode(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
