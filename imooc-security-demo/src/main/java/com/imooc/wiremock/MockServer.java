package com.imooc.wiremock;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @类名: MockServer<br />
 * @包名：com.imooc.wiremock<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/13 9:38<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class MockServer {

    public static void main(String[] args) throws IOException {
        configureFor(8062);
        removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");
    }

    private static void mock(String url, String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + filename + ".json");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
    }
}
