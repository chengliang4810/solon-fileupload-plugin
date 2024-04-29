package com.layjava.solon.file;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件简介
 *
 * @author chengliang
 * @since 2024/04/29
 */
@Data
public class FileInfo implements Serializable {

    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 原名
     */
    private String originalName;

    /**
     * 文件名
     * 通常为随机生成以后的名称
     */
    private String name;

    /**
     * 访问文件的url
     */
    private String url;

    /**
     * 文件大小
     */
    private Long size;

}
