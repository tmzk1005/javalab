package zk.javalab.ratelimit;

public interface RateLimiter {

    /**
     * 判断是否允许通过
     *
     * @param key 唯一key标识限流主体
     * @return 时间戳， -1 表示被限制，>=0 表示通过，并返回计算令牌数的时间戳
     */
    long isAllowed(String key);

}
