
--DROP TABLE IF EXISTS group_table CASCADE;
--DROP TABLE IF EXISTS profile_table CASCADE;
--DROP TABLE IF EXISTS member_table CASCADE;
--DROP TABLE IF EXISTS trainfo_table CASCADE;
--DROP TABLE IF EXISTS traCourse_table CASCADE;
--DROP TABLE IF EXISTS role_table CASCADE;
--DROP TABLE IF EXISTS status_table CASCADE;
--DROP TABLE IF EXISTS TPM_table CASCADE;

--研修情報テーブル

CREATE TABLE IF NOT EXISTS trainfo_table(
	--研修ID: 主キー
	tra_ID CHAR(5) PRIMARY KEY,
	--研修名: 必須
	tra_name VARCHAR(20) NOT NULL,
	--想定時間
	est_time INTEGER,
	--使用教材
	text_book VARCHAR(50),
	--課題
	assignment VARCHAR(100),
	--説明
	description VARCHAR(100)
);

--ロールテーブル
CREATE TABLE IF NOT EXISTS role_table(
	--ロールID: 主キー
	role_ID SERIAL PRIMARY KEY,
	--ロール名: 受講者か講師、必須
	role_name CHAR(3) NOT NULL
);

--ステータステーブル
CREATE TABLE IF NOT EXISTS status_table(
	--ステータスID: 主キー
	status_ID SERIAL PRIMARY KEY,
	--ステータス名: 必須
	status VARCHAR(10) NOT NULL
);

--個人情報テーブル
CREATE TABLE IF NOT EXISTS profile_table(
	--ユーザID: 主キー
	username VARCHAR(30) PRIMARY KEY,
	--ユーザ名: 必須
	account_name VARCHAR(20) NOT NULL,
	--パスワード: 必須
	password VARCHAR(255) NOT NULL UNIQUE,
	--電話番号: 3ケタ-4ケタ-4ケタで11文字固定、必須
	TEL CHAR(11) NOT NULL UNIQUE,
	--住所
	address VARCHAR(50),
	--性別: 男性、女性、不明の2文字固定、必須
	gender CHAR(2) NOT NULL,
	--所属: アプリorインフラ、必須
	affiriation VARCHAR(5) NOT NULL,
	--出身学部
	departOfOrigin VARCHAR(10),
	--ロール: 必須
	role_ID INT NOT NULL,
	FOREIGN KEY (role_ID) REFERENCES role_table(role_ID) ON DELETE CASCADE
);

--グループ管理テーブル
CREATE TABLE IF NOT EXISTS group_table (
	--グループID
	group_ID SERIAL PRIMARY KEY,
	--グループ名: 必須
	group_name VARCHAR(30) NOT NULL UNIQUE,
	--概要
	summary TEXT
);

--グループメンバテーブル: ユーザーとグループの中間テーブル
CREATE TABLE IF NOT EXISTS member_table(
	--どのグループに誰が所属しているかを判別する主キー
	group_user_ID SERIAL PRIMARY KEY,
	--グループID
	group_ID INT NOT NULL,
	FOREIGN KEY (group_ID) REFERENCES group_table(group_ID) ON DELETE CASCADE,
	--グループに所属している利用者リスト
	username VARCHAR(30) NOT NULL,
	FOREIGN KEY (username) REFERENCES profile_table(username) ON DELETE CASCADE,
	--メイン講師のみtrueに設定
	isTeacher BOOLEAN NOT NULL
);

--受講研修テーブル
CREATE TABLE IF NOT EXISTS traCourse_table(
	--受講研修ID: 主キー
	traCourse_ID serial PRIMARY KEY,
	--研修ID: 必須
	tra_ID CHAR(5) NOT NULL,
	FOREIGN KEY (tra_ID) REFERENCES trainfo_table(tra_ID) ON DELETE CASCADE,
	--ユーザID: 必須
	username VARCHAR(30) NOT NULL,
	FOREIGN KEY (username) REFERENCES profile_table(username) ON DELETE CASCADE,
	--受講するかどうか: 必須
	isTakeCourse BOOLEAN NOT NULL,
	--最新進捗: 必須
	latestProgress INT NOT NULL,
	--ステータスID: 必須
	status_ID INT NOT NULL,
	FOREIGN KEY (status_ID) REFERENCES status_table(status_ID) ON DELETE CASCADE,
	--目標期日: 必須
	target_date DATE NOT NULL
);

--研修進捗管理テーブル(Training Progress Management)
CREATE TABLE IF NOT EXISTS TPM_table(
	--履歴No
	stack_No serial,
	--受講研修ID
	traCourse_ID INT NOT NULL,
	FOREIGN KEY (traCourse_ID) REFERENCES traCourse_table(traCourse_ID) ON DELETE CASCADE,
	--学習した日付: 必須
	study_day DATE NOT NULL,
	--メモ
	memo TEXT,
	--学習時間
	study_time REAL,
	--進捗: 必須
	progress INT NOT NULL,
	--ステータスID
	status_ID INT NOT NULL,
	FOREIGN KEY (status_ID) REFERENCES status_table(status_ID) ON DELETE CASCADE,
	--履歴Noと受講研修IDの組み合わせを主キーに設定
	PRIMARY KEY (stack_No, traCourse_ID)
);

--data.sqlのダミーデータの登録方法を変更したためそれに伴う追記
ALTER SEQUENCE role_table_role_ID_seq RESTART WITH 1;
ALTER SEQUENCE status_table_status_ID_seq RESTART WITH 1;
ALTER SEQUENCE group_table_group_ID_seq RESTART WITH 1;
ALTER SEQUENCE member_table_group_user_ID_seq RESTART WITH 1;
ALTER SEQUENCE traCourse_table_traCourse_ID_seq RESTART WITH 1;
ALTER SEQUENCE TPM_table_stack_No_seq RESTART WITH 1;