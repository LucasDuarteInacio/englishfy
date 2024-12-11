CREATE SCHEMA course;


CREATE TABLE course.course
(
    course_id       UUID PRIMARY KEY,
    name            VARCHAR(50) UNIQUE NOT NULL,
    description     VARCHAR(255),
    active          BOOL,
    course_level    VARCHAR(50),
    user_instructor UUID,
    CONSTRAINT fk_instructor FOREIGN KEY (user_instructor) REFERENCES USERS."user" (user_id)
);



COMMENT ON TABLE course.course IS 'Tabela que armazena as informações gerais dos cursos';
COMMENT ON COLUMN course.course.course_id IS 'Identificador único do curso';
COMMENT ON COLUMN course.course.name IS 'Nome do curso, deve ser único e é obrigatório';
COMMENT ON COLUMN course.course.description IS 'Descrição opcional do curso';
COMMENT ON COLUMN course.course.active IS 'Status do curso, como ACTIVE ou INACTIVE';
COMMENT ON COLUMN course.course.course_level IS 'Nível do curso, como BEGINNER, INTERMEDIARY ou ADVANCED';
COMMENT ON COLUMN course.course.user_instructor IS 'Identificador do instrutor responsável pelo curso';

CREATE TABLE course.module
(
    module_id   UUID PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255),
    active      BOOL,
    course_id   UUID               NOT NULL,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course.course (course_id) ON DELETE CASCADE
);


COMMENT ON TABLE course.module IS 'Tabela que armazena os módulos relacionados aos cursos';
COMMENT ON COLUMN course.module.module_id IS 'Identificador único do módulo';
COMMENT ON COLUMN course.module.active IS 'Status do módulo, como ACTIVE ou INACTIVE';
COMMENT ON COLUMN course.module.name IS 'Nome do módulo, deve ser único e é obrigatório';
COMMENT ON COLUMN course.module.description IS 'Descrição opcional do módulo';
COMMENT ON COLUMN course.module.course_id IS 'Identificador do curso ao qual o módulo pertence';


CREATE TABLE course.lesson
(
    lesson_id   UUID PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255),
    active      BOOL,
    video_url   VARCHAR(100),
    content_md  TEXT,
    module_id   UUID               NOT NULL,
    CONSTRAINT fk_module FOREIGN KEY (module_id) REFERENCES course.module (module_id) ON DELETE CASCADE
);


COMMENT ON TABLE course.lesson IS 'Tabela que armazena as lições associadas aos módulos';
COMMENT ON COLUMN course.lesson.lesson_id IS 'Identificador único da lição';
COMMENT ON COLUMN course.lesson.name IS 'Nome da lição, deve ser único e é obrigatório';
COMMENT ON COLUMN course.lesson.description IS 'Descrição opcional da lição';
COMMENT ON COLUMN course.lesson.active IS 'Status do lição, como ACTIVE ou INACTIVE';
COMMENT ON COLUMN course.lesson.video_url IS 'URL do vídeo associado à lição';
COMMENT ON COLUMN course.lesson.content_md IS 'Conteudo markdown associado a lição';
COMMENT ON COLUMN course.lesson.module_id IS 'Identificador do módulo ao qual a lição pertence';
