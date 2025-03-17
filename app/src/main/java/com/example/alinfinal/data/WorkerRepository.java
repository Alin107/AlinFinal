package com.example.alinfinal.data;
import java.util.ArrayList;
import java.util.List;

/**
 * تمثل فئة WorkerRepository مستودعًا لعمال التطبيق.
 */
public class WorkerRepository {
    private List<Worker> workers;

    /**
     * منشئ الفئة، يبدأ المستودع بقائمة فارغة من العمال.
     */
    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    /**
     * إضافة عامل جديد إلى المستودع.
     * @param worker العامل المراد إضافته
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * استرجاع جميع العمال من المستودع.
     * @return قائمة بجميع العمال
     */
    public List<Worker> getAllWorkers() {
        return workers;
    }

    /**
     * البحث عن العمال بناءً على استعلام (اسم أو موقع).
     * @param query الاستعلام المستخدم للبحث
     * @return قائمة من العمال المطابقين للاستعلام
     */
    public List<Worker> searchWorkers(String query) {
        List<Worker> result = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.getName().toLowerCase().contains(query.toLowerCase()) ||
                    worker.getLocation().toLowerCase().contains(query.toLowerCase())) {
                result.add(worker);
            }
        }
        return result;
    }
}
