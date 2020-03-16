TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`localhost` trigger tr2\nafter insert on rezervari\nfor each row begin\nupdate plata,pachete set suma=suma+pret where cont=\'BCR8756GHT74\' and destinatie=\'Roma\';\nend'
sql_modes=1342177280
definers='root@localhost'
client_cs_names='utf8'
connection_cl_names='utf8_general_ci'
db_cl_names='latin1_swedish_ci'
