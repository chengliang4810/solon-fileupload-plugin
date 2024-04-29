package com.layjava.solon.file;

import org.noear.solon.core.handle.UploadedFile;

/**
 * 文件存储服务统一接口
 *
 * @author chengliang
 * @since 2024/04/29
 */
public interface FileStoreService {

    /**
     * 保存文件
     *
     * @param file 文件
     */
    FileInfo save(UploadedFile file);


}
