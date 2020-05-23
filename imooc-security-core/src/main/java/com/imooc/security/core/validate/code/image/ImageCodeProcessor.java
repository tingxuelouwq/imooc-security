package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 类名: ImageCodeProcessor<br/>
 * 包名：com.imooc.security.core.validate.code.image<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/20 10:23<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Component
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    @Override
    protected void send(ServletWebRequest request, ImageCode ImageCode) throws Exception {
        ImageIO.write(ImageCode.getImage(), "JPEG",
                request.getResponse().getOutputStream());
    }
}
