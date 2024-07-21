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
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    post_date DATETIME NOT NULL,
    view_count BIGINT DEFAULT 0,
    member_id BIGINT,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    post_date DATETIME NOT NULL,
    member_id BIGINT,
    notice_id BIGINT,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id)
    ON DELETE CASCADE,
    FOREIGN KEY (notice_id) REFERENCES notice(id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS heart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT,
    comment_id BIGINT,
    crate_date DATETIME NOT NULL,
    create_by VARCHAR(255) NOT NULL,
    update_date DATETIME NOT NULL,
    update_by VARCHAR(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id)
    ON DELETE CASCADE,
    FOREIGN KEY (comment_id) REFERENCES comment(id)
    ON DELETE CASCADE
);


CREATE SEQUENCE IF NOT EXISTS member_seq START WITH 1 INCREMENT BY 1;
