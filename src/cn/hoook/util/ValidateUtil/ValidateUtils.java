package cn.hoook.util.ValidateUtil;

public class ValidateUtils {
    /**
     * <li>判断数据是否为空</li>
     * @param str
     * @return
     */
    public static boolean validateEmpty(String str){ //验，验证数据类型
        if(str == null && "".equals(str)){
            return false;
        }
        return true;
    }
}
