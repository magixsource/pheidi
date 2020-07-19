package gl.linpeng.pheidi.herald.utils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Convert data to MQ
 *
 * @author lin.peng
 * @since 0.0.1
 */
public class HeraldMessageSerializer {

    public static ByteBuffer convertStringToByte(String content) throws UnsupportedEncodingException {
        return ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(ByteBuffer byteBuffer) {
        Charset charset = StandardCharsets.UTF_8;
        return charset.decode(byteBuffer).toString();
    }
}
