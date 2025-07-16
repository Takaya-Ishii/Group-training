schema.sqlとdata.sqlの動作に関して

何もしなくてもテーブルを正常に定義できるようになりました
一度全テーブルをDROPしてからコメントアウトすれば問題なく動きます。

--追記--
以下DB操作について
SELECT, INSERT文は正常に動作します。

DELETE文は参照される側のデータを削除すると、
参照している側のデータも一緒に消えるので注意してください。
ER図でいうと線が繋がっているデータの(FK)がついてない側を削除すると
(FK)がついてる側のデータも削除されるということです。
(FK)がついてる側を削除しても(FK)がついてない側は消えません。

例:
・あるユーザIDを持ったユーザを個人情報テーブルから削除すると、
メンバーテーブル内のユーザIDを参照しているデータが全て一緒に削除される。
・ステータスIDを削除すると、受講研修一覧テーブルと研修進捗管理テーブルから
削除されたステータスIDと同じステータスIDが設定されていたデータが全て削除される。
・受講研修一覧テーブルと研修進捗管理テーブルのデータを削除しても、
ステータステーブルに影響は無い。


UPDATE文の1部のみトランザクションというめんどくさい処理が必要です。

例:
BEGIN;
INSERT INTO profile_table VALUES ('temp', 'temp', 'temp', '11111111111', NULL, '不明', 'アプリ', NULL, 2);
UPDATE member_table SET username = 'temp' WHERE username = 'fugafuga@example.jp';
UPDATE profile_table SET username = 'pakapaka@example.jp' WHERE username = 'fugafuga@example.jp';
UPDATE member_table SET username = 'pakapaka@example.jp' WHERE username = 'temp';
DELETE FROM profile_table WHERE username = 'temp';
COMMIT;

BEGIN～COMMIT間の処理中にエラーが出た場合、DBに対し何もしなかったことになるという処理です。
なるべくpgAdmin4上で先にSQL文が動作するかテストしてから記述した方がいいと思います。
また、「現在のトランザクションがアボートしました」というエラーが出た場合、
一度全部削除かコメントアウトしてからCOMMIT; だけ記述して実行してください。

上では個人情報テーブルのIDを変更したい場合の処理です。
個人情報テーブルにダミーデータ(temp)を登録
メンバーテーブルのメイン講師を一時的にダミーを参照させる
ユーザの情報を更新する
メンバーテーブルのメイン講師を情報更新されたユーザに再設定する
ダミーデータを削除する

まぁusernameとかtra_IDとかの主キーは今回そもそも編集画面で編集出来ないはずなので
こんなことする必要ないと思いますが念のため