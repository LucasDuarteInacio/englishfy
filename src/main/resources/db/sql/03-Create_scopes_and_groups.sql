INSERT INTO auth.scope (scope_id, scope, scope_description)
VALUES ('92d824ad-02d6-482e-b46e-684b1f954cbb', 'user:create', 'Cadastro de novos usuarios na aplicacao'),
       ('8b5b5589-5d1e-405f-a0b5-fe858400311b', 'user:read', 'Visualizar usuarios na aplicacao'),
       ('3016bc50-de1b-4c06-9a50-7eebfdbdf3a8', 'group:read', 'Visualizar grupos na aplicacao'),
       ('9784b1b4-b59f-4505-bbe9-cc6bfdda0034', 'group:write', 'Cadastra ou edita grupos na aplicacao');


INSERT INTO auth.scope_group(scope_group_id, scope_id, group_id)
VALUES ('ca9af5eb-f987-41d7-a710-3d55e63d55cb', '92d824ad-02d6-482e-b46e-684b1f954cbb',
        '7a60f29c-cc16-4d86-88f3-b69a6fa45ffd'),
       ('d7fbad69-bf28-4240-8aae-3c085b21b86e', '8b5b5589-5d1e-405f-a0b5-fe858400311b',
        '7a60f29c-cc16-4d86-88f3-b69a6fa45ffd'),
       ('69988427-e291-4a75-99df-e3fee6de331c', '3016bc50-de1b-4c06-9a50-7eebfdbdf3a8',
        '7a60f29c-cc16-4d86-88f3-b69a6fa45ffd'),
       ('57ff75c0-9186-4320-b994-28b6bd35808a', '9784b1b4-b59f-4505-bbe9-cc6bfdda0034',
        '7a60f29c-cc16-4d86-88f3-b69a6fa45ffd');