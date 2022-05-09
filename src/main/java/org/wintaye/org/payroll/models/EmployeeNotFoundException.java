package org.wintaye.org.payroll.models;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
