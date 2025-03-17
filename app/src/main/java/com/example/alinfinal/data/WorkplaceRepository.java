package com.example.alinfinal.data;

import java.util.ArrayList;
import java.util.List;

/**
 * تمثل فئة WorkplaceRepository مستودعًا لأماكن العمل في التطبيق.
 */
public class WorkplaceRepository {
    private List<Workplace> workplaces;

    /**
     * منشئ الفئة، يبدأ المستودع بقائمة فارغة من أماكن العمل.
     */
    public WorkplaceRepository() {
        this.workplaces = new ArrayList<>();
    }

    /**
     * إضافة مكان عمل جديد إلى المستودع.
     * @param workplace مكان العمل المراد إضافته
     */
    public void addWorkplace(Workplace workplace) {
        workplaces.add(workplace);
    }

    /**
     * استرجاع جميع أماكن العمل من المستودع.
     * @return قائمة بجميع أماكن العمل
     */
    public List<Workplace> getAllWorkplaces() {
        return workplaces;
    }

    /**
     * البحث عن أماكن العمل بناءً على استعلام (اسم أو موقع).
     * @param query الاستعلام المستخدم للبحث
     * @return قائمة من أماكن العمل المطابقة للاستعلام
     */
    public List<Workplace> searchWorkplaces(String query) {
        List<Workplace> result = new ArrayList<>();
        for (Workplace workplace : workplaces) {
            if (workplace.getName().toLowerCase().contains(query.toLowerCase()) ||
                    workplace.getLocation().toLowerCase().contains(query.toLowerCase())) {
                result.add(workplace);
            }
        }
        return result;
    }
}
