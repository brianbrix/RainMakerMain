package com.company;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws GitAPIException, IOException, URISyntaxException {
        ClipboardTextListener b = new ClipboardTextListener();
        Thread thread = new Thread(b);
//        thread.start();
//        JOptionPane.showMessageDialog(null, "RainMaker Started Successfully...");
        push();


    }
    static void push() throws GitAPIException, IOException, URISyntaxException {
//        Git git = Git.open(Paths.get(".").toAbsolutePath().normalize().toFile());
        Repository existingRepo = new FileRepositoryBuilder()
                .setGitDir(new File("/home/brianbrix/IdeaProjects/RainMaker/rainmakerr/.git"))
                .build();
        Git git = new Git(existingRepo);

        // add remote repo:
//        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        git.commit().setAll(true).setMessage("Commit").call();
//        remoteAddCommand.setName("origin/main");
//        remoteAddCommand.setUri(new URIish("https://github.com/brianbrix/RainMakerMain.git"));
        // you can add more settings here if needed
//        remoteAddCommand.call();

        // push to remote:
        PushCommand pushCommand = git.push();
        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("brianbrix", "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"));
        // you can add more settings here if needed
         Iterable<PushResult> pushResults = pushCommand.call();
         pushResults.forEach(pushResult -> {
                     System.out.println(pushResult.getRemoteUpdates());
                     System.out.println(pushResult.getMessages());
                 }
         );
    }
}
