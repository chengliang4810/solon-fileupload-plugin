package com.layjava.solon.file;

import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.handle.UploadedFile;

/**
 * 文件上传控制器
 *
 * @author chengliang
 * @since 2024/04/29
 */
public class FileUploadController {

    /**
     * 上传单文件
     *
     * @param file 文件
     */
    @Post
    @Mapping(value = "", multipart = true)
    public FileInfo uploadFile(@Param("file") UploadedFile file) {
        return FileStore.save(file);
    }

}
