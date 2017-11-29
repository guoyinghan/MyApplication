package com.example.nm.myapplication;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 爱新觉罗璎汉 on 2017/11/28.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)//设置线程池
                .memoryCacheExtraOptions(480, 800)//内存缓存区图片的大小
                .memoryCacheSize(5 * 1024 * 1024)//设置内存缓存区的大小
                .memoryCache(new LruMemoryCache(5 * 1024 * 1024))//设置内存缓存
                .diskCacheFileCount(100)//磁盘缓存文件的数量
                .diskCacheSize(20 * 1024 * 1024)//磁盘缓存区空间大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//设置缓存文件的文件名为md5加密方式
                .writeDebugLogs()//写入日志
                .build();
        ImageLoader.getInstance().init(build);
    }
}
