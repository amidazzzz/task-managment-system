CREATE TABLE t_task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    author_id BIGINT NOT NULL,
    assignee_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES t_user(id),
    FOREIGN KEY (assignee_id) REFERENCES t_user(id)
);