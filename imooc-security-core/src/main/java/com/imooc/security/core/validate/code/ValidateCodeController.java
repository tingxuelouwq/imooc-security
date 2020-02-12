package com.imooc.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @类名: ValidateCodeController<br />
 * @包名：com.imooc.security.core.validate.code<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/25 22:32<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";
    public static final String SESSION_KEY_IMAGE_CODE_EXPIRE_TIME = "SESSION_KEY_IMAGE_CODE_EXPIRE_TIME";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenrator;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ImageCode imageCode = imageCodeGenrator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),
                SESSION_KEY_IMAGE_CODE, imageCode.getCode());
        sessionStrategy.setAttribute(new ServletWebRequest(request),
                SESSION_KEY_IMAGE_CODE_EXPIRE_TIME, imageCode.getExpireTime());
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }
}
