CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS notice (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    view_count BIGINT DEFAULT 0,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS comment (
    id BIGINT PRIMARY KEY,
    content TEXT NOT NULL,
    notice_id BIGINT,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS heart (
    id BIGINT PRIMARY KEY,
    member_id BIGINT,
    comment_id BIGINT,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL
);


CREATE SEQUENCE IF NOT EXISTS member_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS notice_seq START WITH 1 INCREMENT BY 1;
