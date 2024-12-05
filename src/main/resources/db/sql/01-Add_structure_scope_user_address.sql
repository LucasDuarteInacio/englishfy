CREATE SCHEMA auth;
CREATE SCHEMA users;

CREATE TABLE auth.scope
(
    scope_id          UUID PRIMARY KEY,
    scope             VARCHAR(50) UNIQUE NOT NULL,
    scope_description VARCHAR(255)
);

COMMENT ON TABLE auth.scope IS 'Tabela contendo todos os escopos de permissões';
COMMENT ON COLUMN auth.scope.scope_id IS 'Identificador único do escopo';
COMMENT ON COLUMN auth.scope.scope IS 'Nome do escopo (ex: "user:read")';
COMMENT ON COLUMN auth.scope.scope_description IS 'Breve descrição da permissão associada ao escopo';


CREATE TABLE users.address
(
    address_id   UUID PRIMARY KEY,
    zip_code     VARCHAR(8),
    street       VARCHAR(100),
    number       VARCHAR(100),
    neighborhood VARCHAR(100),
    city         VARCHAR(100),
    state        VARCHAR(100),
    complement   VARCHAR(255),
    reference    VARCHAR(255)
);

COMMENT ON TABLE users.address IS 'Tabela de endereços armazenando informações de localização';
COMMENT ON COLUMN users.address.address_id IS 'Identificador único do endereço';
COMMENT ON COLUMN users.address.zip_code IS 'Código postal (CEP)';
COMMENT ON COLUMN users.address.street IS 'Nome da rua';
COMMENT ON COLUMN users.address.number IS 'Numero da rua';
COMMENT ON COLUMN users.address.neighborhood IS 'Nome do bairro';
COMMENT ON COLUMN users.address.city IS 'Nome da cidade';
COMMENT ON COLUMN users.address.state IS 'Nome do estado';
COMMENT ON COLUMN users.address.complement IS 'Complemento do endereço';
COMMENT ON COLUMN users.address.reference IS 'Ponto de referência para o endereço';



CREATE TABLE auth.group
(
    group_id   UUID PRIMARY KEY,
    name       VARCHAR(50) NOT NULL
);

COMMENT ON TABLE auth.group IS 'Tabela contendo os diferentes grupos de permissões';
COMMENT ON COLUMN auth.group.group_id IS 'Identificador único do grupo';
COMMENT ON COLUMN auth.group.name IS 'Nome do grupo';


CREATE TABLE auth.scope_group
(
    scope_group_id UUID PRIMARY KEY,
    scope_id       UUID NOT NULL,
    group_id       UUID NOT NULL
);

COMMENT ON TABLE auth.scope_group IS 'Tabela de associação entre escopos e grupos';
COMMENT ON COLUMN auth.scope_group.scope_group_id IS 'Identificador único da relação escopo-grupo';
COMMENT ON COLUMN auth.scope_group.scope_id IS 'Referência ao escopo na tabela scope';
COMMENT ON COLUMN auth.scope_group.group_id IS 'Referência ao grupo na tabela grupo';

CREATE TABLE users.user
(
    user_id      UUID PRIMARY KEY,
    group_id     UUID,
    address_id   UUID,
    name         VARCHAR(100) NOT NULL,
    email        VARCHAR(150) UNIQUE,
    phone_number VARCHAR(11) UNIQUE,
    password     VARCHAR      NOT NULL,
    status       VARCHAR(50),
    type         VARCHAR(50)
);

COMMENT ON TABLE users.user IS 'Tabela contendo as informações dos usuários cadastrados';
COMMENT ON COLUMN users.user.user_id IS 'Identificador único do usuário';
COMMENT ON COLUMN users.user.address_id IS 'Referência ao endereço à qual o usuário pertence';
COMMENT ON COLUMN users.user.group_id IS 'Referência ao grupo ao qual o usuário pertence';
COMMENT ON COLUMN users.user.name IS 'Nome completo do usuário';
COMMENT ON COLUMN users.user.email IS 'Endereço de email do usuário';
COMMENT ON COLUMN users.user.phone_number IS 'Número de telefone do usuário';
COMMENT ON COLUMN users.user.password IS 'Senha de acesso do usuário';
COMMENT ON COLUMN users.user.status IS 'Status do usuário (ativo, inativo, etc.)';
COMMENT ON COLUMN users.user.type IS 'Tipo de usuário (customer, delivery, main, admin)';


ALTER TABLE auth.scope_group
    ADD CONSTRAINT fk_scope
        FOREIGN KEY (scope_id)
            REFERENCES auth.scope (scope_id)
            ON DELETE CASCADE;

ALTER TABLE auth.scope_group
    ADD CONSTRAINT fk_group
        FOREIGN KEY (group_id)
            REFERENCES auth.group (group_id)
            ON DELETE CASCADE;

ALTER TABLE users.user
    ADD CONSTRAINT fk_address_user
        FOREIGN KEY (address_id)
            REFERENCES users.address (address_id)
            ON DELETE CASCADE;

ALTER TABLE users.user
    ADD CONSTRAINT fk_group_user
        FOREIGN KEY (group_id)
            REFERENCES auth.group (group_id)
            ON DELETE SET NULL;
