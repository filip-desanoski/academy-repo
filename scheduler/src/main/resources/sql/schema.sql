CREATE TABLE user_roles
(
    id   SERIAL,
    role VARCHAR(13) NOT NULL UNIQUE,
    PRIMARY KEY (id, role)
);

CREATE TABLE images
(
    id       SERIAL PRIMARY KEY,
    img_name TEXT  NOT NULL,
    img      bytea NOT NULL
);

CREATE TABLE contacts
(
    id           SERIAL PRIMARY KEY,
    image_id     INTEGER,
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL UNIQUE,
    email        VARCHAR(50) NOT NULL UNIQUE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (image_id) REFERENCES images (id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE users
(
    id              SERIAL PRIMARY KEY,
    username        VARCHAR(50)  NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    contact_id      INTEGER,
    user_role_id    INTEGER,
    user_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active          BOOLEAN,
    FOREIGN KEY (contact_id) REFERENCES contacts (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (user_role_id) REFERENCES user_roles (id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE r_user_userRole
(
    user_id INTEGER NOT NULL,
    user_role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, user_role_id),
     FOREIGN KEY (user_id) REFERENCES users (id)
         ON DELETE RESTRICT ON UPDATE CASCADE,
     FOREIGN KEY (user_role_id) REFERENCES user_roles (id)
         ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE trainings
(
    id                  SERIAL PRIMARY KEY,
    training_name       VARCHAR(50) NOT NULL UNIQUE,
    group_id            VARCHAR(50) NOT NULL UNIQUE,
    start_date          DATE        NOT NULL,
    end_date            DATE        NOT NULL,
    training_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    training_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active              BOOLEAN
);

-- CREATE TABLE r_training_instructors
-- (
--     training_id   INTEGER NOT NULL,
--     instructor_id INTEGER NOT NULL,
--     PRIMARY KEY (training_id, instructor_id),
--     FOREIGN KEY (training_id) REFERENCES trainings (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE,
--     FOREIGN KEY (instructor_id) REFERENCES users (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE
-- );

CREATE TABLE enrollments
(
    id              SERIAL PRIMARY KEY,
    student_id      INTEGER NOT NULL,
    training_id     INTEGER NOT NULL,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (training_id) REFERENCES trainings (id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE meetings
(
    id                 SERIAL PRIMARY KEY,
    meeting_name       VARCHAR(100)             NOT NULL,
    start_time         TIMESTAMP WITH TIME ZONE NOT NULL,
    end_time           TIMESTAMP WITH TIME ZONE NOT NULL,
    meeting_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    meeting_updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    active             BOOLEAN
);

-- CREATE TABLE r_meeting_attendees
-- (
--     meeting_id INTEGER NOT NULL,
--     user_id    INTEGER NOT NULL,
--     PRIMARY KEY (meeting_id, user_id),
--     FOREIGN KEY (meeting_id) REFERENCES meetings (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE,
--     FOREIGN KEY (user_id) REFERENCES users (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE
-- );

-- CREATE TABLE r_meeting_instructors
-- (
--     meeting_id    INTEGER NOT NULL,
--     instructor_id INTEGER NOT NULL,
--     PRIMARY KEY (meeting_id, instructor_id),
--     FOREIGN KEY (meeting_id) REFERENCES meetings (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE,
--     FOREIGN KEY (instructor_id) REFERENCES users (id)
--         ON DELETE RESTRICT ON UPDATE CASCADE
-- );