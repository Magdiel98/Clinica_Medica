-- =========================
-- TABELA PACIENTE
-- =========================
CREATE TABLE paciente (
    id_paciente SERIAL PRIMARY KEY,
    nome_paciente VARCHAR(150) NOT NULL,
    email_paciente VARCHAR(150),
    cpf VARCHAR(14) UNIQUE NOT NULL
);

-- =========================
-- TABELA TELEFONE_PACIENTE
-- =========================
CREATE TABLE telefone_paciente (
    id_telefone_paciente SERIAL PRIMARY KEY,
    telefone_paciente VARCHAR(20) NOT NULL,
    paciente_id BIGINT NOT NULL,
    CONSTRAINT fk_telefone_paciente_paciente
        FOREIGN KEY (paciente_id)
        REFERENCES paciente (id_paciente)
        ON DELETE CASCADE
);

-- =========================
-- TABELA MEDICO
-- =========================
CREATE TABLE medico (
    id_medico SERIAL PRIMARY KEY,
    nome_medico VARCHAR(150) NOT NULL,
    email_medico VARCHAR(150),
    crm VARCHAR(20) UNIQUE NOT NULL
);

-- =========================
-- TABELA TELEFONE_MEDICO
-- =========================
CREATE TABLE telefone_medico (
    id_telefone_medico SERIAL PRIMARY KEY,
    telefone_medico VARCHAR(20) NOT NULL,
    medico_id BIGINT NOT NULL,
    CONSTRAINT fk_telefone_medico_medico
        FOREIGN KEY (medico_id)
        REFERENCES medico (id_medico)
        ON DELETE CASCADE
);

-- =========================
-- TABELA CONSULTA
-- =========================
CREATE TABLE consulta (
    id_consulta SERIAL PRIMARY KEY,
    data_consulta DATE NOT NULL,
    hora_consulta TIME NOT NULL,
    status_consulta VARCHAR(30) NOT NULL,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,

    CONSTRAINT fk_consulta_paciente
        FOREIGN KEY (paciente_id)
        REFERENCES paciente (id_paciente),

    CONSTRAINT fk_consulta_medico
        FOREIGN KEY (medico_id)
        REFERENCES medico (id_medico)
);
