TYPE=VIEW
query=select `h`.`nume` AS `nume`,`h`.`locatie` AS `locatie` from ((`agentie_turism`.`hoteluri` `h` join `agentie_turism`.`destinatii` `d` on((`d`.`oras` = `h`.`locatie`))) join `agentie_turism`.`pachete` `p` on((`d`.`oras` = `p`.`destinatie`)))
md5=e41b7d762c7f3b048219fe6af15e80ff
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2019-04-14 13:27:15
create-version=2
source=select nume,locatie from hoteluri h\ninner join destinatii d on d.oras=h.locatie\ninner join pachete p on d.oras=p.destinatie
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `h`.`nume` AS `nume`,`h`.`locatie` AS `locatie` from ((`agentie_turism`.`hoteluri` `h` join `agentie_turism`.`destinatii` `d` on((`d`.`oras` = `h`.`locatie`))) join `agentie_turism`.`pachete` `p` on((`d`.`oras` = `p`.`destinatie`)))
mariadb-version=100136
