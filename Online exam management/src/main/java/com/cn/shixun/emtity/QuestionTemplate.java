package com.cn.shixun.emtity;

public class QuestionTemplate {
    private Integer id;

    private String templateName;

    private Integer majorId;

    private Integer subjectId;

    private Integer singleNum;

    private Integer singleScore;

    private String singleDifficultyProportion;

    private Integer multipleNum;

    private Integer multipleScore;

    private String multipleDifficultyProportion;

    private Integer aggregateScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(Integer singleNum) {
        this.singleNum = singleNum;
    }

    public Integer getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Integer singleScore) {
        this.singleScore = singleScore;
    }

    public String getSingleDifficultyProportion() {
        return singleDifficultyProportion;
    }

    public void setSingleDifficultyProportion(String singleDifficultyProportion) {
        this.singleDifficultyProportion = singleDifficultyProportion;
    }

    public Integer getMultipleNum() {
        return multipleNum;
    }

    public void setMultipleNum(Integer multipleNum) {
        this.multipleNum = multipleNum;
    }

    public Integer getMultipleScore() {
        return multipleScore;
    }

    public void setMultipleScore(Integer multipleScore) {
        this.multipleScore = multipleScore;
    }

    public String getMultipleDifficultyProportion() {
        return multipleDifficultyProportion;
    }

    public void setMultipleDifficultyProportion(String multipleDifficultyProportion) {
        this.multipleDifficultyProportion = multipleDifficultyProportion;
    }

    public Integer getAggregateScore() {
        return aggregateScore;
    }

    public void setAggregateScore(Integer aggregateScore) {
        this.aggregateScore = aggregateScore;
    }
}