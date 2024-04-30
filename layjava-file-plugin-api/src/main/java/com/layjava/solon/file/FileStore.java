package com.layjava.solon.file;

import org.noear.solon.Solon;
import org.noear.solon.core.handle.UploadedFile;

import java.util.List;

/**
 * 文件存储
 *
 * @author chengliang
 * @since 2024/04/29
 */
public interface FileStore {

    /**
     * 保存文件
     * @param file 文件对象
     */
    static FileInfo save(UploadedFile file) {
        // 获取所有文件存储服务
        List<FileStoreService> storeServices = Solon.context().getBeansOfType(FileStoreService.class);
        if (storeServices == null || storeServices.isEmpty()){
            throw new RuntimeException("No file storage service found");
        }

        // 使用找到的第一个，防止多个实现
        FileStoreService fileStoreService = storeServices.get(0);
        FileInfo fileInfo = fileStoreService.buildFileInfo(file);

        // 保存文件
        String fileName = fileStoreService.save(file);
        fileInfo.setName(fileName);

        return fileInfo;
    }

}
