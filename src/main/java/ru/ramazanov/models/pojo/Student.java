package ru.ramazanov.models.pojo;

/**
 * Created by admin on 23.02.2017.
 */
public class Student {
    private int id;
    private int group_id;
    private String name;
    private String birthdate;
    private String sex;


    public Student(int id, int group_id, String name, String birthdate, String sex) {
        this.id = id;
        this.group_id = group_id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public Student(int id, int group_id, String name, String birthdate, String sex, String email) {
        this.id = id;
        this.group_id = group_id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return email.hashCode() * 21;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj == this){
            return true;
        }

        if(!(obj instanceof Student)){
            return false;
        }

        Student student = (Student) obj;
        if(this.getEmail().equals(student.getEmail())){
            return true;
        }
        return false;
    }

}
