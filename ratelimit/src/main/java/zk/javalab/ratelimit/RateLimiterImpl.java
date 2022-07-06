package zk.javalab.ratelimit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterImpl implements RateLimiter {

    private final long burstCapacity;

    private final long replenishRate;

    private final long requestedTokens;

    private final Map<String, TokenInfo> internalStatus = new ConcurrentHashMap<>();

    public RateLimiterImpl(long burstCapacity, long replenishRate, long requestedTokens) {
        this.burstCapacity = burstCapacity;
        this.replenishRate = replenishRate;
        this.requestedTokens = requestedTokens;
    }

    @Override
    public synchronized long isAllowed(String key) {
        internalStatus.computeIfAbsent(key, s -> new TokenInfo());
        final long currentTimeMillis = System.currentTimeMillis();
        final TokenInfo tokenInfo = internalStatus.get(key);
        tokenInfo.leftTokens = Math.max(burstCapacity, tokenInfo.leftTokens + replenishRate * (currentTimeMillis - tokenInfo.updateTime));
        tokenInfo.updateTime = currentTimeMillis;
        if (tokenInfo.leftTokens < requestedTokens) {
            return -1;
        }
        tokenInfo.leftTokens = tokenInfo.leftTokens - requestedTokens;
        return currentTimeMillis;
    }

    class TokenInfo {

        private long updateTime;

        private long leftTokens;

        public TokenInfo() {
            this.updateTime = System.currentTimeMillis();
            this.leftTokens = burstCapacity;
        }

    }

}
