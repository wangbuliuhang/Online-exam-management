package com.cn.shixun.emtity;

import java.util.Date;

public class Score {
    private Integer id;

    private Integer userId;

    private Integer subjectId;

    private Integer score;

    private Date answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getAnswer() {
        return answer;
    }

    public void setAnswer(Date answer) {
        this.answer = answer;
    }
}