package com.example.alinfinal.data;
/**
 * تمثل فئة Workplace مكان العمل في التطبيق.
 */
public class Workplace {
    /** معرف مكان العمل */
    protected String idPlace;

    /** اسم مكان العمل */
    protected String namePlace;

    /** الموقع الجغرافي لمكان العمل */
    protected String locationPlace;

    /** وصف مكان العمل */
    protected String description;

    /**
     * منشئ فئة Workplace.
     * @param id معرف مكان العمل
     * @param name اسم مكان العمل
     * @param location الموقع الجغرافي
     * @param description وصف مكان العمل
     */
    public Workplace(String id, String name, String location, String description) {
        this.idPlace = idPlace;
        this.namePlace = namePlace;
        this.locationPlace = locationPlace;
        this.description = description;
    }

    /**
     * @return معرف مكان العمل
     */
    public String getId() {
        return idPlace;
    }

    /**
     * تعيين معرف مكان العمل
     * @param id معرف مكان العمل
     */
    public void setId(String id) {
        this.idPlace = idPlace ;
    }

    /**
     * @return اسم مكان العمل
     */
    public String getName() {
        return namePlace;
    }

    /**
     * تعيين اسم مكان العمل
     * @param name اسم مكان العمل
     */
    public void setName(String name) {
        this.namePlace = namePlace;
    }

    /**
     * @return الموقع الجغرافي لمكان العمل
     */
    public String getLocation() {
        return locationPlace;
    }

    /**
     * تعيين الموقع الجغرافي لمكان العمل
     * @param location الموقع الجغرافي
     */
    public void setLocation(String location) {
        this.locationPlace = locationPlace;
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
        return "ID: " + idPlace + "\nName: " + namePlace + "\nLocation: " + locationPlace + "\nDescription: " + description;
    }
}
