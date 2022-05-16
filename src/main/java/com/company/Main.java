package com.company;

import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
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
//        push();


    }
//    static void push() throws GitAPIException, IOException {
//        Repository existingRepo = new FileRepositoryBuilder()
//                .setGitDir(new File("/home/brianbrix/IdeaProjects/RainMaker/rainmakerr/.git"))
//                .build();
//        Git git = new Git(existingRepo);
//
//        // add remote repo:
//        git.add().addFilepattern("/home/brianbrix/IdeaProjects/RainMaker/rainmakerr").call();
//        CommitCommand commitCommand = git.commit().setAll(true).setMessage("Commit");
//        RevCommit revCommit = commitCommand.call();
//        System.out.println(revCommit.getFullMessage());
//
//        // push to remote:
//        PushCommand pushCommand = git.push();
//        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("brianbrix", "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"));
//        // you can add more settings here if needed
//         Iterable<PushResult> pushResults = pushCommand.call();
//         pushResults.forEach(pushResult -> {
//                     System.out.println(pushResult.getRemoteUpdates());
//                     System.out.println(pushResult.getMessages());
//                 }
//         );
//    }
}
