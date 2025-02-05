package me.xiaozhangup.bilibilitoper.bilibiliapi;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import me.xiaozhangup.bilibilitoper.utils.tools.IString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BGetter {

    @Nullable
    public static JSONObject getBaseJson(String bvid) {
        String api = IString.getStringFromURL("https://api.bilibili.com/x/web-interface/view?&bvid=" + bvid);

        if (api == null) return null;
        JSONObject data = JSON.parseObject(api);

        if (data.getIntValue("code") != 0) {
            return null;
        } else {
            return data;
        }

    }

    @NotNull
    public static String getPoster(JSONObject base) {
        JSONObject owner = getVideo(base).getJSONObject("owner");
        return owner.getString("name");
    }

    @NotNull
    public static JSONObject getVideo(JSONObject base) {
        JSONObject video = base.getJSONObject("data");
        return video;
    }

    public static long getLike(JSONObject video) {
        final JSONObject stat = video.getJSONObject("stat");
        return stat.getLongValue("like");
    }

    public static long getView(JSONObject video) {
        final JSONObject stat = video.getJSONObject("stat");
        return stat.getLongValue("view");
    }
}
