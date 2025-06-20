schema.sqlとdata.sqlの動作に関して

テーブルを正常に定義するための手順を書きます

①何もコードを変更せずそのまま動作させ、エラーが無ければ実行を停止してください。
data.sqlにダミーデータを追加したので一度全部作り直します。
ここで個人情報、グループの外部キー参照以外の定義とそれ以外のテーブルの定義をします

②schema.sqlファイルのALTER TABLE profile_tableから続く3行をコメントアウトしてください
再実行時に「profile_tableには既にgroup_IDという列が存在しています」というエラーを防ぐためです

③schema.sqlの最上部のDROP TABLE group_table文以外をコメントアウトしてください
設定が新しくなったのでグループテーブルのみ一度削除して再度作成するようにします

④再実行します。
これで正しくテーブルが定義され、これ以降も使用できます。

！！！！⑤！！！！ ④でコメントアウトを外したDROP TABLE文を再度コメントアウトします
これをしないと実行するたびにグループ管理テーブルが初期化されます

以上です

どうしてこうなってしまったんでしょうね。
本当に申し訳ない。

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
グループテーブルでそのユーザIDを参照している全てのグループが一緒に削除される。
・ステータスIDを削除すると、受講研修一覧テーブルと研修進捗管理テーブルから
削除されたステータスIDと同じステータスIDが設定されていたデータが全て削除される。
・受講研修一覧テーブルと研修進捗管理テーブルのデータを削除しても、
ステータステーブルに影響は無い。


UPDATE文の1部のみトランザクションというめんどくさい処理が必要です。

例:
BEGIN;
INSERT INTO profile_table VALUES ('temp@example.jp', 'temp data', 'password', '08011112222', null, '不明', '未定', null, 2, null);
UPDATE group_table SET username = 'temp@example.jp' WHERE group_ID = 1 AND username='fugafuga@example.jp';
UPDATE profile_table SET username = 'gahagaha@example.jp', account_name = 'gaha gaha' WHERE username = 'fugafuga@example.jp';
UPDATE group_table SET username = 'gahagaha@example.jp' WHERE group_ID = 1 AND username = 'temp@example.jp';
DELETE FROM profile_table WHERE username='temp@example.jp';
COMMIT;

BEGIN～COMMIT間の処理中にエラーが出た場合、DBに対し何もしなかったことになるという処理です。
なるべくpgAdmin4上で先にSQL文が動作するかテストしてから記述した方がいいと思います。
また、「現在のトランザクションがアボートしました」というエラーが出た場合、
一度全部削除かコメントアウトしてからCOMMIT; だけ記述して実行してください。

上では個人情報テーブルのIDを変更したい場合の処理です。
個人情報テーブルにダミーデータ(temp)を登録
グループテーブルのメイン講師を一時的にダミーを参照させる
ユーザの情報を更新する
グループテーブルのメイン講師を情報更新されたユーザに再設定する
ダミーデータを削除する

まぁusernameとかtra_IDとかの主キーは今回そもそも編集画面で編集出来ないはずなので
こんなことする必要ないと思いますが念のため