package com.layjava.solon.file.local;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
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
        String fileName = getFileName(file);

        // 不存在则创建的目录
        File storeFile = FileUtil.file(storePath, fileName);
        try {
            file.transferTo(storeFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileInfo();
    }

    /**
     * 获取文件名
     *
     * @param file 文件
     * @return {@link String}
     */
    private String getFileName(UploadedFile file){
        String fileName = IdUtil.getSnowflakeNextIdStr();
        if (StrUtil.isNotEmpty(file.getExtension())){
            fileName = fileName + "." + file.getExtension();
        }
        return fileName;
    }

}
