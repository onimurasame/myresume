INSERT INTO PUBLIC.USERS (ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME) VALUES ('onimurasame', 'Raul', 'Astudillo', 'G');
INSERT INTO PUBLIC.RESUMES (ID, CREATED_ON, VERSION, USER_ID) VALUES (1, null, 1, 'onimurasame');
INSERT INTO PUBLIC.RESUMES_SECTIONS (RESUME_ID, SECTIONS_ID) VALUES (1, 1);
INSERT INTO PUBLIC.RESUMES_SECTIONS (RESUME_ID, SECTIONS_ID) VALUES (1, 2);
INSERT INTO PUBLIC.SECTIONS (ID, NAME) VALUES (1, 'Personal');
INSERT INTO PUBLIC.SECTIONS (ID, NAME) VALUES (2, 'Professional Experience');
INSERT INTO PUBLIC.SECTION_DATA (SECTION_ID, VALUE, KEY) VALUES (1, 'Raul Astudillo Markoch', 'Name');
INSERT INTO PUBLIC.SECTION_DATA (SECTION_ID, VALUE, KEY) VALUES (1, 'onimurasame@gmail.com', 'Email');
INSERT INTO PUBLIC.SECTION_DATA (SECTION_ID, VALUE, KEY) VALUES (2, 'IBM', '2010');
INSERT INTO PUBLIC.SECTION_DATA (SECTION_ID, VALUE, KEY) VALUES (2, 'HCL', '2015');