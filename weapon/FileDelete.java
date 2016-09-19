import  java.io.File;
import  java.io.IOException;
public class FileDelete{
    public static void main(String[] args)
    {
        try{
            deletefile("d:\\abc");
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static boolean deletefile(String path) throws IOException
    {
        try {
            if (path == null)
                return false;
            File file = new File(path);
            if (!file.exists())
                throw new IllegalArgumentException(path+"not exists");
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] fileList = file.list();
                for (String f : fileList) {
                    File file1 = new File(path + "\\" + f);
                    if (!file1.isDirectory())
                        file1.delete();
                    else if(file1.isDirectory())
                        deletefile(file1.getAbsolutePath());
                }
            }
            file.delete();
        }catch (Exception e){
            System.out.println("deletefile() exception:" + e.getMessage());
            return false;
        }
        return true;
    }
}