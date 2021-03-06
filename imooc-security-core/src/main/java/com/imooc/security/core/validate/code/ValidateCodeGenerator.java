package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
