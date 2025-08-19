package com.adomlogistics.service;

import com.adomlogistics.model.MaintenanceRecord;
import com.adomlogistics.util.FileManager;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceService {
    private List<MaintenanceRecord> records = new ArrayList<>();

    public MaintenanceService() {
        List<MaintenanceRecord> loaded = FileManager.loadMaintenanceRecords();
        records.addAll(loaded);
    }

    public void addRecord(MaintenanceRecord r) {
        records.add(r);
        FileManager.saveMaintenanceRecords(records);
    }

    public List<MaintenanceRecord> listRecords() {
        return new ArrayList<>(records);
    }
}
