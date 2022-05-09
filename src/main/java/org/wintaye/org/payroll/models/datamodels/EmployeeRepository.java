package org.wintaye.org.payroll.models.datamodels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wintaye.org.payroll.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
