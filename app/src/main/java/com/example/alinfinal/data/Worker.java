package com.example.alinfinal.data;

/**
 * تمثل فئة Worker عامل في التطبيق.
 */
public class Worker {
    /** معرف العامل */
    private String id;

    /** اسم العامل */
    private String name;

    /** سن العامل */
    private int age;

    /** الموقع الجغرافي للعامل */
    private String location;

    /**
     * منشئ فئة Worker.
     * @param id معرف العامل
     * @param name اسم العامل
     * @param age سن العامل
     * @param location الموقع الجغرافي للعامل
     */
    public Worker(String id, String name, int age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    /**
     * @return معرف العامل
     */
    public String getId() {
        return id;
    }

    /**
     * تعيين معرف العامل
     * @param id معرف العامل
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return اسم العامل
     */
    public String getName() {
        return name;
    }

    /**
     * تعيين اسم العامل
     * @param name اسم العامل
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return سن العامل
     */
    public int getAge() {
        return age;
    }

    /**
     * تعيين سن العامل
     * @param age سن العامل
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return الموقع الجغرافي للعامل
     */
    public String getLocation() {
        return location;
    }

    /**
     * تعيين الموقع الجغرافي للعامل
     * @param location الموقع الجغرافي
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * عرض تفاصيل العامل.
     * @return تفاصيل العامل كنص
     */
    public String getWorkerDetails() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nLocation: " + location;
    }
}
