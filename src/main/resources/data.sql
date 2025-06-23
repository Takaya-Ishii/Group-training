INSERT INTO trainfo_table (tra_ID, tra_name, est_time, text_book, assignment, description) VALUES ('H0001', 'HTML・CSS研修', 50, 'HTML&CSSとWebデザイン入門講座 第2版', 'テキストテキストテキストテキストテ', 'テキストテキストテキストテキスト') ON CONFLICT (tra_ID) DO NOTHING;
INSERT INTO trainfo_table (tra_ID, tra_name, est_time, text_book, assignment, description) VALUES ('J0001', 'Java研修', 100, 'スッキリわかるJava入門、プロになるJava', 'テキストテキストテキストテキストテキ', 'テキストテキストテキストテキスト') ON CONFLICT (tra_ID) DO NOTHING;
INSERT INTO trainfo_table (tra_ID, tra_name, est_time, text_book, assignment, description) VALUES ('S0001', 'SQL研修', 40, 'スッキリわかるSQL入門', 'テキストテキストテキストテキストテキス', 'テキストテキストテキストテキスト') ON CONFLICT (tra_ID) DO NOTHING;
INSERT INTO trainfo_table (tra_ID, tra_name, est_time, text_book, assignment, description) VALUES ('J0002', 'Spring研修', 60, 'SpringFramework超入門 やさしくわかるWebアプリ開発', 'テキストテキストテキストテキストテキスト', 'テキストテキストテキストテキスト') ON CONFLICT (tra_ID) DO NOTHING;

INSERT INTO role_table (role_name) VALUES ('受講者') ON CONFLICT (role_ID) DO NOTHING;
INSERT INTO role_table (role_name) VALUES ('講師') ON CONFLICT (role_ID) DO NOTHING;

INSERT INTO status_table (status) VALUES ('未着手') ON CONFLICT (status_ID) DO NOTHING;
INSERT INTO status_table (status) VALUES ('教材取組中') ON CONFLICT (status_ID) DO NOTHING;
INSERT INTO status_table (status) VALUES ('課題取組中') ON CONFLICT (status_ID) DO NOTHING;
INSERT INTO status_table (status) VALUES ('レビュー中') ON CONFLICT (status_ID) DO NOTHING;
INSERT INTO status_table (status) VALUES ('完了') ON CONFLICT (status_ID) DO NOTHING;
INSERT INTO status_table VALUES (99 ,'研修対象外') ON CONFLICT (status_ID) DO NOTHING;

INSERT INTO profile_table VALUES ('hogehoge@example.jp', 'hoge hoge', '$2a$10$mYGkEoalQQhh7TH.guLVHuECGxJa8K38gEPzzpX0tmfix7JGBVIO.', '08012345678', '埼玉県', '男性', 'アプリ', NULL,  1) ON CONFLICT (username) DO NOTHING;
INSERT INTO profile_table VALUES ('fugafuga@example.jp', 'fuga fuga', '$2a$10$NREZfIcvCJ9.vpcMnwEF0OzrwYW3X0Jncpfifm/QNCS.Dt9YJzWOu', '08098765432', '埼玉県', '男性', 'アプリ', NULL,  2) ON CONFLICT (username) DO NOTHING;
INSERT INTO profile_table VALUES ('foofoo@example.jp', 'foo foo', '$2a$10$87qj0TD2UMlxErEGSHNO1OGigYXg0K4JiXG1gYZinEO8ryQZw6aI.', '08011111111', '神奈川県', '女性', 'インフラ', NULL,  1) ON CONFLICT (username) DO NOTHING;
INSERT INTO profile_table VALUES ('hogahoga@example.jp', 'hoga hoga', '$2a$10$xvMnq/wYEVke.q.l294ocOBVJGoONYWoSiG2diceeLu88/suNklIG', '08022222222', '神奈川県', '男性', 'インフラ', NULL,  2) ON CONFLICT (username) DO NOTHING;
INSERT INTO profile_table VALUES ('hogehoge@example.jp', 'hoge hoge', '$2a$10$N9IHSVK46JKGQpB0C5miyeK/pXOJo/PUiQb.6em7Ljdx61OI9U/CC', '08012345678', '埼玉県', '男性', 'アプリ', NULL,  1) ON CONFLICT (username) DO NOTHING;
INSERT INTO profile_table VALUES ('fugafuga@example.jp', 'fuga fuga', '$2a$10$52gZqN8qwP3anJXG4nSOOueFpPDm/PfxBH9RMl2TultQ0I2eLVTUy', '08098765432', '埼玉県', '男性', 'アプリ', NULL,  2) ON CONFLICT (username) DO NOTHING;

INSERT INTO group_table (username, group_name, summary) VALUES ('fugafuga@example.jp', '25卒内定者グループ', '2025年内定者用グループ 配属決定前まで使用 インフラ・アプリ共有') ON CONFLICT (group_ID, username) DO NOTHING;
INSERT INTO group_table (username, group_name, summary) VALUES ('fugafuga@example.jp', 'インフラ研修グループ', 'インフラチーム研修用グループ') ON CONFLICT (group_ID, username) DO NOTHING;

INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('H0001', 'hogehoge@example.jp', TRUE, 100, 5, '2025-04-01') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('J0001', 'hogehoge@example.jp', TRUE, 100, 5, '2025-05-01') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('H0001', 'foofoo@example.jp', TRUE, 100, 5, '2025-05-01') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('J0001', 'foofoo@example.jp', TRUE, 90, 4, '2025-05-05') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('S0001', 'hogehoge@example.jp', TRUE, 62.5, 2, '2025-06-01') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('J0001', 'foofoo@example.jp', FALSE, 0, 99, '2025-04-01') ON CONFLICT (traCourse_ID) DO NOTHING;
INSERT INTO traCourse_table (tra_ID, username, isTakeCourse, latestProgress, status_ID, target_date) VALUES ('J0002', 'hogehoge@example.jp', FALSE, 0, 99, '2025-04-01') ON CONFLICT (traCourse_ID) DO NOTHING;

INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (1, '2025-03-01', 'テキストテキスト', 4.5, 30, 2) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;
INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (1, '2025-03-10', 'テキストテキスト', 5, 60, 3) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;
INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (3, '2025-03-01', 'テキストテキスト', 3, 25, 2) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;
INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (1, '2025-03-20', 'テキストテキスト', 6, 90, 4) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;
INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (2, '2025-03-22', 'テキストテキスト', 3, 20, 2) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;
INSERT INTO TPM_table (traCourse_ID, study_day, memo, study_time, progress, status_ID) VALUES (1, '2025-03-22', 'テキストテキスト', NULL, 100, 5) ON CONFLICT (stack_No, traCourse_ID) DO NOTHING;