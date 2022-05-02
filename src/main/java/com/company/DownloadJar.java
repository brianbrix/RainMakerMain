package com.company;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadJar {
    public static void download()
    {
        String token = "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";
        String url = "maven.pkg.github.com/brianbrix/RainMakerMain/mysec/rainmakerr/1.0.0/rainmakerr-1.0.0.exe";
        getGithubContentUsingHttpClient(token,url);
    }
    @SuppressWarnings("resource")
    private static void getGithubContentUsingHttpClient(String token, String url) {
        String newUrl = "https://" + token + ":x-oauth-basic@" + url;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(newUrl);
        System.out.println(newUrl);
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            String filePath = "rainmaker.exe";
            FileOutputStream fos = new FileOutputStream(filePath);
            int inByte;
            while((inByte = is.read()) != -1)
                fos.write(inByte);
            is.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
