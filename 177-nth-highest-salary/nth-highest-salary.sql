CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  IF N < 1 THEN
    RETURN;
  END IF;

  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    select DISTINCT e.salary from Employee e order by salary desc limit 1 offset N-1 
  );
END;
$$ LANGUAGE plpgsql