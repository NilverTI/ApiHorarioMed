package com.tantalean.apihorariomed.repository;

import com.tantalean.apihorariomed.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
