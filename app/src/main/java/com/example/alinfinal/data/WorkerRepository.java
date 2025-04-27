package com.example.alinfinal.data;

import java.util.ArrayList;
import java.util.List;

public class WorkerRepository {

    // قائمة لتخزين جميع العمال
    private static List<Worker> workersList = new ArrayList<>();

    // إضافة عامل جديد إلى المستودع
    public static void addWorker(Worker worker) {
        workersList.add(worker);
    }

    // الحصول على قائمة العمال
    public static List<Worker> getWorkers() {
        return workersList;
    }

    // الحصول على عامل بناءً على ID
    public static Worker getWorkerById(String id) {
        for (Worker worker : workersList) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null; // إذا لم يتم العثور على العامل
    }

    // حذف عامل بناءً على ID
    public static void removeWorkerById(String id) {
        for (Worker worker : workersList) {
            if (worker.getId().equals(id)) {
                workersList.remove(worker);
                break;
            }
        }
    }

//
}

