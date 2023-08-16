package pm.geetest.controller;

import org.springframework.web.bind.annotation.*;
import pm.geetest.utils.R;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/result")
public class ApiController {
    public Map<String, Object> resMap = new HashMap<>();

    @GetMapping("/get")
    public R getResult(@RequestParam(required = false) String key) {
        if (key == null) return R.ERROR("缺少参数key");
        Map<String, Object> res = (Map<String, Object>) resMap.get(key);
        if (res == null) return R.ERROR("无效的key");
        resMap.remove(key);
        return R.OK(res);
    }

    @PostMapping("/success")
    public R sucData(@RequestBody Map<String, Object> mp) {
        try {
            String key = (String) mp.get("key");
            Object data = mp.get("data");
            if (key == null || data == null) return R.ERROR("");
            resMap.put(key, data);
        } catch (Exception err) {
            return R.ERROR("");
        }
        return R.OK(null);
    }

    @GetMapping("/check")
    public R check() {
        return R.OK(resMap);
    }
}
