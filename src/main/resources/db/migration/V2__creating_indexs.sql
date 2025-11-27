CREATE UNIQUE INDEX idx_app_users_email ON app_users(email);
CREATE UNIQUE INDEX idx_offline_users_id_number ON offline_users(id_number);
CREATE UNIQUE INDEX idx_parcels_code ON parcels(code);
CREATE INDEX idx_trips_departure_at ON trips(departure_at)