package me.xiaozhangup.bilibilitoper;

import com.alibaba.fastjson2.JSONObject;
import me.xiaozhangup.bilibilitoper.bilibiliapi.BGetter;
import org.testng.annotations.Test;

public class Get {

    @Test
    public void get() {
        String bvid = "BV1yt4y1m77u";
        JSONObject jsonObject = BGetter.getBaseJson(bvid);
        System.out.println(jsonObject);
        System.out.println(BGetter.getVideo(jsonObject).getString("title"));
        System.out.println(BGetter.getLike(BGetter.getVideo(jsonObject)));
        System.out.println(BGetter.getView(BGetter.getVideo(jsonObject)));
    }

}
