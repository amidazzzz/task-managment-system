CREATE TABLE t_comment (
    id SERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    task_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (task_id) REFERENCES t_task(id),
    FOREIGN KEY (author_id) REFERENCES t_user(id)
);