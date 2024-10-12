select * from purchase_order;

insert into ship(uuid, arrival_time, name, vessel_number)
VALUES(gen_random_uuid() , '2024-10-01 12:00:00','ship name', 'test_vessel_number' );

insert into purchase_order(referenceuuid, po_number, vessel_number)
VALUES(gen_random_uuid() , 'testpoNumber','test_vessel_number' )