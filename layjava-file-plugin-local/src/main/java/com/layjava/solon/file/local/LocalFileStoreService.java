package com.layjava.solon.file.local;

import cn.hutool.core.io.FileUtil;
import com.layjava.solon.file.FileInfo;
import com.layjava.solon.file.FileStoreService;
import org.noear.solon.core.handle.UploadedFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件存储服务实现
 */
public class LocalFileStoreService implements FileStoreService {

    private final String storePath;

    public LocalFileStoreService(String storePath) {
        this.storePath = storePath;
    }

    @Override
    public FileInfo save(UploadedFile file) {
        // 不存在则创建的目录
        File storeDir = FileUtil.file(storePath);
        if (!storeDir.exists()) {
            storeDir.mkdirs();
        }
        try {
            file.transferTo(new File(storePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileInfo();
    }

}
