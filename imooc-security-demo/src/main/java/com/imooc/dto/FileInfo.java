package com.imooc.dto;

/**
 * @类名: FileInfo<br />
 * @包名：com.imooc.dto<br/>
 * @作者：kevin<br/>
 * @时间：2019/10/8 21:48<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
