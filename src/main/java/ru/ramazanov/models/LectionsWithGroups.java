package ru.ramazanov.models;

import ru.ramazanov.models.pojo.Student;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Created by admin on 02.03.2017.
 */
public class LectionsWithGroups {

    private String lectionTitle;
    private String lectionSubject;
    private int lectionId;
    private int groupId;
    private Timestamp datetime;

    public int getLectionId() {
        return lectionId;
    }

    public void setLectionId(int lectionId) {
        this.lectionId = lectionId;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }


    public String getLectionTitle() {
        return lectionTitle;
    }

    public void setLectionTitle(String lectionTitle) {
        this.lectionTitle = lectionTitle;
    }

    public String getLectionSubject() {
        return lectionSubject;
    }

    public void setLectionSubject(String lectionSubject) {
        this.lectionSubject = lectionSubject;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
