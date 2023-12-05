package com.example.servletjspmodel.manager;

import com.example.servletjspmodel.model.EmployeeVacation;

import java.util.ArrayList;
import java.util.List;

public class VacationManager {
    private static List<EmployeeVacation> vacations = new ArrayList<>();

    public static List<EmployeeVacation> getAllVacations() {
        return vacations;
    }

    public static void addVacation(EmployeeVacation vacation) {
        vacations.add(vacation);
    }

    public static void editVacation(int index, EmployeeVacation updatedVacation) {
        vacations.set(index, updatedVacation);
    }

    public static void deleteVacation(int index) {
        vacations.remove(index);
    }

    public static EmployeeVacation getVacationById(int index) {
        return vacations.get(index);
    }

    // Другие методы для обработки данных
    // ...
}
