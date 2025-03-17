package com.example.alinfinal.data;

import java.util.ArrayList;
import java.util.List;

/**
 * تمثل فئة JobMatch مطابقة بين العمال وأماكن العمل بناءً على الموقع.
 */
public class JobMatch {

    /**
     * العثور على العمال المطابقين لمكان العمل بناءً على الموقع.
     * @param workplace مكان العمل الذي سيتم البحث عن عمال له
     * @param workers قائمة من العمال
     * @return قائمة من العمال المطابقين
     */
    public static List<Worker> findMatchingWorkers(Workplace workplace, List<Worker> workers) {
        List<Worker> matchedWorkers = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.getLocation().equalsIgnoreCase(workplace.getLocation())) {
                matchedWorkers.add(worker);
            }
        }
        return matchedWorkers;
    }
}
