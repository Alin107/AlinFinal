package com.example.alinfinal.data;
/**
 * تمثل فئة Workplace مكان العمل في التطبيق.
 */
public class Workplace {
    /** معرف مكان العمل */
    private String id;

    /** اسم مكان العمل */
    private String name;

    /** الموقع الجغرافي لمكان العمل */
    private String location;

    /** وصف مكان العمل */
    private String description;

    /**
     * منشئ فئة Workplace.
     * @param id معرف مكان العمل
     * @param name اسم مكان العمل
     * @param location الموقع الجغرافي
     * @param description وصف مكان العمل
     */
    public Workplace(String id, String name, String location, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    /**
     * @return معرف مكان العمل
     */
    public String getId() {
        return id;
    }

    /**
     * تعيين معرف مكان العمل
     * @param id معرف مكان العمل
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return اسم مكان العمل
     */
    public String getName() {
        return name;
    }

    /**
     * تعيين اسم مكان العمل
     * @param name اسم مكان العمل
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return الموقع الجغرافي لمكان العمل
     */
    public String getLocation() {
        return location;
    }

    /**
     * تعيين الموقع الجغرافي لمكان العمل
     * @param location الموقع الجغرافي
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return وصف مكان العمل
     */
    public String getDescription() {
        return description;
    }

    /**
     * تعيين وصف مكان العمل
     * @param description وصف مكان العمل
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * عرض تفاصيل مكان العمل.
     * @return تفاصيل مكان العمل كنص
     */
    public String getWorkplaceDetails() {
        return "ID: " + id + "\nName: " + name + "\nLocation: " + location + "\nDescription: " + description;
    }
}
