package homeworks.DZ4;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Task27 {
    static boolean download(String link,String file_name){
        try{
            URL url = new URL(link);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(file_name);
            int data = is.read();
            while(data!=-1){
                os.write(data);
                data = is.read();
            }
            os.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(download(
                "https://img.freepik.com/premium-photo/trees-growing-in-forest_1048944-30368869.jpg",
                "work\\res\\task27_jpg_for_dz4.jpg"
        ));
        System.out.println(download(
                "https://videocdn.cdnpk.net/harmony/content/video/partners1363/large_watermarked/BB_e68759c8-8cba-47d9-b856-7f97a649be03_FPpreview.mp4?filename=5205438_branch_sakura_bloom_3840x2160.mp4",
                "work\\res\\task27_mp4_for_dz4.mp4"
        ));
        System.out.println(download(
                "https://dl3s4.zvuch.com/aHR0cDovL2YubXAzcG9pc2submV0L21wMy8wMDMvMDY5LzY2OC8zMDY5NjY4Lm1wMw==",
                "work\\res\\task27_mp3_for_dz4.mp3"
        ));

    }
}
