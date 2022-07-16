package zk.javalab.jdk17.hmac;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256Sign {

    public static void main(String[] args) throws Exception {
        String secret = args[0];
        String content = args[1];
        final Mac hmac = Mac.getInstance("HmacSHA256");
        hmac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        final byte[] bytes = hmac.doFinal(content.getBytes(StandardCharsets.UTF_8));
        System.out.println(Hex.encode(bytes));
    }

    static class Hex {

        private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

        private Hex() {
        }

        public static char[] encode(byte[] bytes) {
            final int byteCount = bytes.length;
            char[] result = new char[2 * byteCount];
            int j = 0;
            for (byte oneByte : bytes) {
                // Char for top 4 bits
                result[j++] = HEX_CHARS[(0xF0 & oneByte) >>> 4];
                // Bottom 4
                result[j++] = HEX_CHARS[(0x0F & oneByte)];
            }
            return result;
        }

    }

}
