package com.layjava.solon.file.local;

import com.layjava.solon.file.FileUploadController;
import org.noear.solon.Solon;
import org.noear.solon.core.AppContext;
import org.noear.solon.core.Plugin;
import org.noear.solon.web.staticfiles.StaticMappings;
import org.noear.solon.web.staticfiles.repository.FileStaticRepository;

public class XPluginImp implements Plugin {

    /**
     * 默认上传url
     */
    private static final String DEFAULT_UPLOAD_URL = "/file/upload";

    /**
     * 默认存储路径
     */
    private static final String DEFAULT_STORE_PATH = System.getProperty("user.dir") + "/upload";

    /**
     * 默认静态映射url
     */
    private static final String DEFAULT_STATIC_MAPPING_URL = "/upload/";


    @Override
    public void start(AppContext context) throws Throwable {
        // 是否启用上传接口
        boolean uploadControllerEnable = Solon.cfg().getBool("layjava.file.upload.controller.enable", true);
        boolean staticMappingEnable = Solon.cfg().getBool("layjava.file.mapping.enable", true);
        String storePath = Solon.cfg().get("layjava.file.store.path", DEFAULT_STORE_PATH);

        //注册文件存储服务
        Solon.context().wrapAndPut(LocalFileStoreService.class, new LocalFileStoreService(storePath));

        // 注册文件上传接口
        if (uploadControllerEnable){
            Solon.app().add(DEFAULT_UPLOAD_URL, FileUploadController.class);
        }

        // 静态资源访问映射
        if (staticMappingEnable){
            String mappingUrl = Solon.cfg().get("layjava.file.mapping.url", DEFAULT_STATIC_MAPPING_URL);
            StaticMappings.add(mappingUrl, new FileStaticRepository(storePath));
        }

    }

}
