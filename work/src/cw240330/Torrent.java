package cw240330;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Torrent {
    public static void main(String[] args) {
        try{
            //https://youtu.be/vPHUm874EoA
            //https://videocdn.cdnpk.net/harmony/content/video/partners1363/large_watermarked/BB_e68759c8-8cba-47d9-b856-7f97a649be03_FPpreview.mp4?filename=5205438_branch_sakura_bloom_3840x2160.mp4
            URL url = new URL("https://videocdn.cdnpk.net/harmony/content/video/partners1363/large_watermarked/BB_e68759c8-8cba-47d9-b856-7f97a649be03_FPpreview.mp4?filename=5205438_branch_sakura_bloom_3840x2160.mp4");
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream("Video.mp4");
            int data = is.read();
            while(data!=-1){
                os.write(data);
                data = is.read();
            }
            os.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
