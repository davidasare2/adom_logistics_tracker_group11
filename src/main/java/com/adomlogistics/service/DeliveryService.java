package com.adomlogistics.service;

import com.adomlogistics.datastructures.MyQueue;
import com.adomlogistics.model.Delivery;
import com.adomlogistics.util.FileManager;
import java.util.List;

public class DeliveryService {
    private MyQueue<Delivery> deliveries = new MyQueue<>();

    public DeliveryService() {
        List<Delivery> loaded = FileManager.loadDeliveries();
        for (Delivery d : loaded) {
            deliveries.enqueue(d);
        }
    }

    public void addDelivery(Delivery d) {
        deliveries.enqueue(d);
        FileManager.saveDeliveries(deliveries.toList());
    }

    public boolean updateDeliveryStatus(String packageId, String newEta) {
        List<Delivery> all = deliveries.toList();
        for (Delivery d : all) {
            if (d.getPackageId().equals(packageId)) {
                d.setEta(newEta);
                FileManager.saveDeliveries(all);
                return true;
            }
        }
        return false;
    }

    public List<Delivery> listDeliveries() {
        return deliveries.toList();
    }
}
