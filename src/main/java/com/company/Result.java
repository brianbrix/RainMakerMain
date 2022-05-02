package com.company;

import java.util.List;

public class Result {
    private Integer total_count;
    private List<Artifact> artifacts;

    public Result(Integer totalCount, List<Artifact> artifacts) {
        this.total_count = totalCount;
        this.artifacts = artifacts;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    @Override
    public String toString() {
        return "Result{" +
                "totalCount=" + total_count +
                ", artifacts=" + artifacts +
                '}';
    }
}
