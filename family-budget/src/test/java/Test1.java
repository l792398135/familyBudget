import com.ruoyi.fixedasset.utils.DesUtil;

public class Test1 {
    public static void main(String[] args) {
        String liuxingwu123 = DesUtil.encrypt("12345678","liuxingwu123");
        System.out.println(liuxingwu123);
        String decryptString = DesUtil.decrypt("12345678","7s1gkKwOSiG1gIvWiYgBKw==");
        System.out.println(decryptString);
    }
}
