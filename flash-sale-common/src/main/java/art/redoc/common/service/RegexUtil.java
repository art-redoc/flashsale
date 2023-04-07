package art.redoc.common.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    private static final Map<String, Pattern> patternCache = new ConcurrentHashMap<>();

    public static String find(String regex, String html) {
        Pattern pattern;
        if (patternCache.containsKey(regex)) {
            pattern = patternCache.get(regex);
        } else {
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            patternCache.put(regex, pattern);
        }
        Matcher matcher = pattern.matcher(html);
        return matcher.find() ? matcher.group("value") : "";
    }

    //提取年月日
    public static String findYYYYMMDD(String html) {
        Pattern RGX = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher mat = RGX.matcher(html);
        while (mat.find()) {
            return mat.group();
        }
        return "";
    }
}
