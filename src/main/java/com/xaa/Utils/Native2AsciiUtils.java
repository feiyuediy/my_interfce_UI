package com.xaa.Utils;

public class Native2AsciiUtils {

    /**
     * prefix of ascii string of native character
     */
    private static String PREFIX = "\\u";

    /**
     * Native to ascii string. It's same as execut native2ascii.exe.
     *
     * @param str
     *            native string
     * @return ascii string
     */
    public static String native2Ascii(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(char2Ascii(chars[i]));
        }
        return sb.toString();
    }

    /**
     * Native character to ascii string.
     *
     * @param c
     *            native character
     * @return ascii string
     */
    private static String char2Ascii(char c) {
        if (c > 255) {
            StringBuilder sb = new StringBuilder();
            sb.append(PREFIX);
            int code = (c >> 8);
            String tmp = Integer.toHexString(code);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            code = (c & 0xFF);
            tmp = Integer.toHexString(code);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            return sb.toString();
        } else {
            return Character.toString(c);
        }
    }

    /**
     * Ascii to native string. It's same as execut native2ascii.exe -reverse.
     *
     * @param str
     *            ascii string
     * @return native string
     */
    public static String ascii2Native(String str) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int index = str.indexOf(PREFIX);
        while (index != -1) {
            sb.append(str.substring(begin, index));
            sb.append(ascii2Char(str.substring(index, index + 6)));
            begin = index + 6;
            index = str.indexOf(PREFIX, begin);
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    /**
     * Ascii to native character.
     *
     * @param str
     *            ascii string
     * @return native character
     */
    private static char ascii2Char(String str) {
        if (str.length() != 6) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must be 6 character.");
        }
        if (!PREFIX.equals(str.substring(0, 2))) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must start with \"\\u\".");
        }
        String tmp = str.substring(2, 4);
        int code = Integer.parseInt(tmp, 16) << 8;
        tmp = str.substring(4, 6);
        code += Integer.parseInt(tmp, 16);
        return (char) code;
    }

    public static void main(String[] args) {
        String uni = "{\"ret\":0,\"result\":[{\"gift_cat_name\":\"\\u666e\\u901a\\u793c\\u7269\",\"gift_cat_type\":\"1\",\"gift_list\":[{\"gift_id\":\"3\",\"cat_id\":\"1\",\"gift_name\":\"\\u5e78\\u8fd0\\u8349\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151120\\/b8a7160d4d1a27edec280266279a43191.png\",\"gift_price\":\"10\",\"gift_type\":\"1\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"38\",\"cat_id\":\"1\",\"gift_name\":\"\\u955c\\u5b50\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20170425\\/f20cb541a6b43d27f2123b003e028e58.png?width=168&amp;height=168\",\"gift_price\":\"1\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"17\",\"cat_id\":\"1\",\"gift_name\":\"\\u7ea2\\u73ab\\u7470\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151121\\/f37c4e7649251f95dfb2cbc55d2a810b.png\",\"gift_price\":\"5\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"24\",\"cat_id\":\"1\",\"gift_name\":\"VIP\\u793c\\u7269\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feed_ad\\/20160104\\/8f72ecf54de4611c58186b57ceab5343.png?width=&amp;height=\",\"gift_price\":\"10\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"1\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"45\",\"cat_id\":\"1\",\"gift_name\":\"\\u5151\\u6362\\u4f59\\u989d\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160818\\/c9b4c8146e444cfa68f08abaeff9cc70.jpg?width=&amp;height=\",\"gift_price\":\"77\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"2\",\"cat_id\":\"1\",\"gift_name\":\"\\u76f8\\u673a\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151110\\/713b56025068c328d85f0be7b9837fab.jpg?width=160&height=160\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"22\",\"cat_id\":\"1\",\"gift_name\":\"\\u62d0\\u6756\\u7cd6\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151224\\/8ff2cb30582cbcde84d489dcd5142f89.png\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"23\",\"cat_id\":\"1\",\"gift_name\":\"\\u59dc\\u997c\\u4eba\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151224\\/8c3d641d1cbdcdb38108d20df3a9480d.png\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"26\",\"cat_id\":\"1\",\"gift_name\":\"VIP\\u60c5\\u4e66\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201601\\/feeds\\/20160315\\/46402aee46ce1f27bd7fbcd2a27fc844.png?width=168&height=168\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"1\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"37\",\"cat_id\":\"1\",\"gift_name\":\"\\u5151\\u6362\\u4e13\\u7528\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160901\\/23b0aeeb2d3d371db5ae29de60187711.png?width=168&amp;height=168\",\"gift_price\":\"300\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"18\",\"cat_id\":\"1\",\"gift_name\":\"\\u94bb\\u6212\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151127\\/fe34a3ff9ea6205abfbbe73c8ba1f45d.png\",\"gift_price\":\"1000\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"19\",\"cat_id\":\"1\",\"gift_name\":\"\\u8dd1\\u8f66\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151121\\/6f975a28ac80a069e7ae0f9a2945a3c0.png\",\"gift_price\":\"10000\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"},{\"gift_id\":\"30\",\"cat_id\":\"1\",\"gift_name\":\"\\u8d85\\u7ea7\\u5927\\u793c\\u5305\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201601\\/feed_ad\\/20160322\\/870c5e079bb8cd2b7aefcbfa2b29553f.png?width=&amp;height=\",\"gift_price\":\"100000\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"}]},{\"gift_cat_name\":\"\\u9650\\u65f6\\u793c\\u7269\",\"gift_cat_type\":\"2\",\"gift_list\":[{\"gift_id\":\"28\",\"cat_id\":\"2\",\"gift_name\":\"123\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20170425\\/13fc19083e30d19c0056e030791ce7c5.png?width=168&height=168\",\"gift_price\":\"1\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"2\",\"start_time\":\"2017-05-25 16:06:00\",\"end_time\":\"2017-11-30 16:08:00\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\",\"countdown_time\":978}]},{\"gift_cat_name\":\"\\u9650\\u91cf\\u793c\\u7269\",\"gift_cat_type\":\"3\",\"gift_list\":[{\"gift_id\":\"39\",\"cat_id\":\"3\",\"gift_name\":\"\\u6d4b\\u8bd5\\u65b0\\u793c\\u7269\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/feeds\\/20151224\\/8ff2cb30582cbcde84d489dcd5142f89.png?width=&amp;height=\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"127\",\"gif_pic\":\"\"},{\"gift_id\":\"40\",\"cat_id\":\"3\",\"gift_name\":\"\\u65b0\\u5151\\u6362\\u6bd4\\u7387\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160901\\/23b0aeeb2d3d371db5ae29de60187711.png?width=168&amp;height=168\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"232\",\"gif_pic\":\"\"},{\"gift_id\":\"41\",\"cat_id\":\"3\",\"gift_name\":\"111\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20170425\\/0062ec9458be9ca7b3f3b10b1194072d.png?width=168&amp;height=168\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"9989\",\"gif_pic\":\"\"},{\"gift_id\":\"42\",\"cat_id\":\"3\",\"gift_name\":\"\\u897f\\u74dc\\u51b0\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20170725\\/9b3ad44daad1b8c19e93484bee0e8bb4.png?width=168&height=168\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"21\",\"gif_pic\":\"\"}]},{\"gift_cat_name\":\"\\u7279\\u6548\\u793c\\u7269\",\"gift_cat_type\":\"4\",\"gift_list\":[{\"gift_id\":\"52\",\"cat_id\":\"4\",\"gift_name\":\"\\u5e78\\u8fd0\\u661f\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160831\\/3224c836f0fcf958d30722f3411c256d.png?width=66&amp;height=72\",\"gift_price\":\"1\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"http:\\/\\/192.168.1.50:85http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160826\\/cd7f8cd6d25d979a96e325142fec514e.gif?width=400&amp;height=400\"},{\"gift_id\":\"53\",\"cat_id\":\"4\",\"gift_name\":\"\\u9ec4\\u91d1\\u72d7\\u7cae\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feed_ad\\/20170612\\/89d08c2d01b18a5f38afa1eea3f9d57d.png?width=&height=\",\"gift_price\":\"1\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"http:\\/\\/192.168.1.50:85http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160826\\/cd4aa2286be5729408fa306cd714e438.gif?width=200&amp;height=200\"},{\"gift_id\":\"56\",\"cat_id\":\"4\",\"gift_name\":\"\\u6d4b\\u8bd5-\\u5206\\u7c7b\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20171129\\/fa3a6eaa3e7ed5efd542d7123d13d3f9.jpg?width=1024&height=768\",\"gift_price\":\"10\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"1000\",\"gif_pic\":\"http:\\/\\/192.168.1.50:85http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20160824\\/78e97a03d9e77ddcc870b3c10112b9f8.gif?width=300&height=204\"},{\"gift_id\":\"57\",\"cat_id\":\"4\",\"gift_name\":\"\\u7279\\u6548\\u793c\\u7269\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20161110\\/cd114bbe444359a5f0cc1289a802ec54.jpg?width=220&height=220\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"http:\\/\\/192.168.1.50:85http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20171129\\/49fd1374cc342c1668539b6a9fba0716.gif?width=300&height=680\"}]},{\"gift_cat_name\":\"\\u66f4\\u591a\\u793c\\u7269\",\"gift_cat_type\":\"1\",\"gift_list\":[{\"gift_id\":\"5\",\"cat_id\":\"5\",\"gift_name\":\"\\u5496\\u5561\",\"gift_pic\":\"http:\\/\\/192.168.1.50:85\\/201608\\/feeds\\/20170425\\/1fe92586fd7c771412c44dd60e642aa9.png?width=168&amp;height=168\",\"gift_price\":\"100\",\"gift_type\":\"2\",\"is_active\":\"1\",\"effect_type\":\"1\",\"is_vip\":\"0\",\"limit_gift_total\":\"0\",\"gif_pic\":\"\"}]}]}\n";
        System.out.println(ascii2Native(uni));
    }
}
