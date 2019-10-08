package com.imooc.controller;

import com.imooc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @类名: FileController<br />
 * @包名：com.imooc.controller<br/>
 * @作者：kevin<br/>
 * @时间：2019/10/8 21:46<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final String folder = "D:\\Workspace\\Idea\\imooc-security\\imooc-security-demo\\src\\main\\java\\com\\imooc\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        try (InputStream is = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream os = response.getOutputStream()) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(is, os);
            os.flush();
        }
    }
}
