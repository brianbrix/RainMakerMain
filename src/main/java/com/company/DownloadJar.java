package com.company;

import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class DownloadJar {
    public static void download()
    {
        String token = "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";
        String url = "maven.pkg.github.com/brianbrix/RainMakerMain/mysec/rainmakerr/1.1.0/rainmakerr-1.1.0.exe";
//        getGithubContentUsingHttpClient(token,url);
        getArtifacts();
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
    private static void getArtifacts() {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://api.github.com/repos/brianbrix/RainMakerMain/actions/artifacts");
        httpGet.setHeader("Accept", "application/vnd.github.v3+json");
        try {
            HttpResponse response = client.execute(httpGet);
            String s = EntityUtils.toString(response.getEntity());
            Result result = new Gson().fromJson(s,Result.class);
            System.out.println(result);
            String url = result.getArtifacts().get(0).getArchive_download_url();
            getArtifact(url);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    private static void getArtifact(String url)
    {
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/vnd.github.v3+json");
        try {
            HttpResponse response = client.execute(httpGet);
            Header [] headers = response.getAllHeaders();
//            Result result = new Gson().fromJson(s,Result.class);
            System.out.println(Arrays.toString(headers));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
