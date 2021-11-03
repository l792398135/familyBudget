import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        getFileList("d:/ruoyi/uploadPath");
        String s = "/profile/upload/2021/09/18/18c28e3e-93bd-49b3-ace4-e3a7553ca3eb.jpg";
        String substring = s.substring(8);
        List<String> list = new ArrayList<>();
        list.add("d:/ruoyi/uploadPath"+substring);
        System.out.println();
        for (File file : filelist) {
            String absolutePath = file.getAbsolutePath().replace('\\','/');
            if (list.get(0).contains(absolutePath)){
                System.out.println();
            }else{
                System.out.println("删除文件1"+file.getAbsolutePath());
                file.delete();
            }
        }

    }
    static List<File> filelist = new ArrayList<>();
    public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                }
            }

        }
        return filelist;
    }
}
