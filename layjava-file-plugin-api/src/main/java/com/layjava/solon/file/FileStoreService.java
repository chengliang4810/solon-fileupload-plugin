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
     * @return {@link String } 完整的文件名
     */
    String save(UploadedFile file);

    /**
     * 构建文件信息
     *
     * @param file 上传的文件
     * @return 文件信息
     */
    default FileInfo buildFileInfo(UploadedFile file) {
        if (file == null) {
            return null;
        }

        FileInfo fileInfo = new FileInfo();
        fileInfo.setOriginalName(file.getName());
        fileInfo.setSize(file.getContentSize());
        fileInfo.setFileId(System.currentTimeMillis());
        return fileInfo;
    }

}
