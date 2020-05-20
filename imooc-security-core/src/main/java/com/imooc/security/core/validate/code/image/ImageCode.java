package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * @类名: ImageCode<br />
 * @包名：com.imooc.security.core.validate.code<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/25 22:30<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class ImageCode extends ValidateCode {

    private static final long serialVersionUID = -133398810420215036L;

    private transient BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}

