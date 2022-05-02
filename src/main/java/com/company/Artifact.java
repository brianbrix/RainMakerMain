package com.company;

import java.util.Objects;

public class Artifact {
    private long id;
    private String node_id;
    private String name;
    private long size_in_bytes;
    private String url;
    private String archive_download_url;
    private boolean expired;

    public Artifact(){}

    public Artifact(long id, String nodeId, String name, long sizeInBytes, String url, String archiveDownloadUrl, boolean expired) {
        this.id = id;
        this.node_id = nodeId;
        this.name = name;
        this.size_in_bytes = sizeInBytes;
        this.url = url;
        this.archive_download_url = archiveDownloadUrl;
        this.expired = expired;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize_in_bytes() {
        return size_in_bytes;
    }

    public void setSize_in_bytes(long size_in_bytes) {
        this.size_in_bytes = size_in_bytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArchive_download_url() {
        return archive_download_url;
    }

    public void setArchive_download_url(String archive_download_url) {
        this.archive_download_url = archive_download_url;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Artifact{" +
                "id=" + id +
                ", nodeId='" + node_id + '\'' +
                ", name='" + name + '\'' +
                ", sizeInBytes=" + size_in_bytes +
                ", url='" + url + '\'' +
                ", archiveDownloadUrl='" + archive_download_url + '\'' +
                ", expired=" + expired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artifact artifact = (Artifact) o;
        return id == artifact.id && size_in_bytes == artifact.size_in_bytes && expired == artifact.expired && Objects.equals(node_id, artifact.node_id) && Objects.equals(name, artifact.name) && Objects.equals(url, artifact.url) && Objects.equals(archive_download_url, artifact.archive_download_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, node_id, name, size_in_bytes, url, archive_download_url, expired);
    }
}
