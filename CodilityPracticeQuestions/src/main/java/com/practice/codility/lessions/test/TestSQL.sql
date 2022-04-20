create table assessments (
      id integer not null,
      experience integer not null,
      sql integer,
      algo integer,
      bug_fixing integer,
      unique(id)
  );

  insert into assessments values ( 1, 3, 100, NULL, 50);
insert into assessments values ( 2, 5, NULL, 100, 100);
insert into assessments values ( 3, 1, 100, 100, 100);
insert into assessments values ( 4, 5, 100, 50, NULL);
insert into assessments values ( 5, 5, 100, 100, 100);


SELECT experience AS exp,
(SELECT count(1) FROM assessments B WHERE B.experience = A.experience
AND ((sql IS NULL OR sql = '100') AND (algo IS NULL OR algo = '100') AND (bug_fixing IS NULL OR bug_fixing = '100'))) As max, COUNT(id) AS count
FROM assessments A GROUP BY experience ORDER BY experience desc;