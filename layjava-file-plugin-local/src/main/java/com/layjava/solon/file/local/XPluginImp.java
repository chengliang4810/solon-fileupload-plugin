package com.layjava.solon.file.local;

import com.layjava.solon.file.FileUploadController;
import org.noear.solon.Solon;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;

public class XPluginImp implements Plugin {

    @Override
    public void start(AppContext context) throws Throwable {
        //注册文件存储服务
        Solon.context().wrapAndPut(LocalFileStoreService.class, new LocalFileStoreService());
        // 注册文件上传接口
        Solon.app().add("/file/upload", FileUploadController.class);
    }

}
