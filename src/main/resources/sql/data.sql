insert into ship(uuid, arrival_time, name, vessel_number)
VALUES(gen_random_uuid() , '2024-10-01 12:00:00','ship name', 'test_vessel_number' );

insert into ship(uuid, arrival_time, name, vessel_number)
VALUES(gen_random_uuid() , '2024-10-01 12:00:00','ship name', 'test_vessel_number2' );

insert into shipping_order(referenceuuid, po_number)
VALUES(gen_random_uuid() , 'testpoNumber' );

insert into shipping_order(referenceuuid, po_number)
VALUES(gen_random_uuid() , 'testpoNumber2' );