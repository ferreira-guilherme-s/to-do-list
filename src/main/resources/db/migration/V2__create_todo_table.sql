CREATE TYPE statusTask AS ENUM ('COMPLETED','IN_PROGRESS','WAITING');

CREATE TABLE IF NOT EXISTS to_do (
    id UUID PRIMARY KEY,
    annotation text,
    status statusTask,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id UUID,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);