------------------------------------------------------------------------
-- Módulo jurassic (Dinosaur)
------------------------------------------------------------------------
INSERT INTO dinosaur_sensor_data (dinosaur_id, sensor_type, sensor_value, measurement_time)
VALUES ('T-Rex', 'heart_rate', '89 BPM', '2025-01-01 12:00:00');

INSERT INTO dinosaur_sensor_data (dinosaur_id, sensor_type, sensor_value, measurement_time)
VALUES ('Velociraptor', 'location', '75 BPM', '2025-01-02 08:30:00');

------------------------------------------------------------------------
-- Módulo Pedidos (Order)
------------------------------------------------------------------------

INSERT INTO orders (id, product, quantity, price, status)
VALUES (1, 'Laptop', 2, 1299.99, 'NEW');

INSERT INTO orders (id, product, quantity, price, status)
VALUES (2, 'Mouse', 5, 25.50, 'NEW');

------------------------------------------------------------------------
-- Módulo Seguridad (SecurityLog)
------------------------------------------------------------------------

INSERT INTO security_logs (id, username, action, date_time)
VALUES (1, 'Batman', 'Check secure area', '2025-01-01 10:00:00');

INSERT INTO security_logs (id, username, action, date_time)
VALUES (2, 'Batman', 'Disable alarm system', '2025-01-01 11:30:00');

------------------------------------------------------------------------
-- Módulo magic (Spell)
------------------------------------------------------------------------

INSERT INTO spell (id, name, effect, mana_cost)
VALUES (1, 'Lumos', 'Illuminate area', 5);

INSERT INTO spell (id, name, effect, mana_cost)
VALUES (2, 'Alohomora', 'Unlock doors', 10);

------------------------------------------------------------------------
-- Módulo stark (RawData)
------------------------------------------------------------------------

INSERT INTO raw_data_record (source, payload, received_at) VALUES ('SensorA', 'DataA', '2025-01-01T10:00:00');
INSERT INTO raw_data_record (source, payload, received_at) VALUES ('SensorB', 'DataB', '2025-01-02T11:00:00');

