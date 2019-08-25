DELIMITER $$
DROP PROCEDURE IF EXISTS SalariesAndHireDates $$
CREATE PROCEDURE SalariesAndHireDates(
    IN GivenSalary INT,
    IN HireDate DATE)
BEGIN
    SELECT CONCAT(e.first_name, e.last_name) 'Name',
        e.emp_no 'Emp. No',
        e.hire_date 'Hire Date'
    FROM employees e
    INNER JOIN salaries s ON s.emp_no = e.emp_no
    WHERE e.hire_date = HireDate
    AND s.salary >= GivenSalary;
END $$
DELIMITER ;