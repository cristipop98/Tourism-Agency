TYPE=VIEW
query=select `agentie_turism`.`clienti`.`CNP` AS `CNP`,`agentie_turism`.`clienti`.`nume` AS `nume` from `agentie_turism`.`clienti` order by `agentie_turism`.`clienti`.`nume`
md5=d7c2f3e998de45866a2c36bf33848510
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2019-04-14 13:27:15
create-version=2
source=select CNP,nume from clienti\norder by nume asc
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `agentie_turism`.`clienti`.`CNP` AS `CNP`,`agentie_turism`.`clienti`.`nume` AS `nume` from `agentie_turism`.`clienti` order by `agentie_turism`.`clienti`.`nume`
mariadb-version=100136
