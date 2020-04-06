
CREATE TABLE IF NOT EXISTS membership_pack (
    id SERIAL PRIMARY KEY,

    title VARCHAR(1024),
    director VARCHAR(1024),
    release_date DATE  NOT NULL
);