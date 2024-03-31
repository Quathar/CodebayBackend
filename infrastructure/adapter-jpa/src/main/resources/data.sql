-- =========================
-- == DATA INITIALIZATION ==
-- =========================

-- [ SECURITY SCHEMA ]
insert into Role(id, name, description)
    values
        ('20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'USER',      'Basic visitors who have limited access'),
        ('119847ec-c01d-443f-9756-87f58e285aed', 'CUSTOMER',  'Fully registered users in the shop'),
        ('c4f7aa87-b916-40a1-b2da-b79dea51784b', 'ADMIN',     'Authorized personnel with full control over the platform'),
        ('c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', 'ASSISTANT', 'Users with partial administrative privileges, assisting admins in specific tasks'),
        ('367dbe6f-7bf1-4614-84b5-c769e2789251', 'STAFF',     'Employees or team members assigned specific roles within the platform');

insert into Operation(id, name)
    values
        ('77b678af-db22-4920-821b-a89ef5869fbe', 'READ_MY_PROFILE'),
        ('c5004c5a-273a-42cb-a099-4d167b2e3392', 'MODIFY_MY_PROFILE'),
        ('f6ae619f-8fdb-4948-bd09-9c2c32105b91', 'DELETE_MY_PROFILE');

insert into Granted_Permission(id, role_id, operation_id)
    values
        ('1f071194-5744-49e9-b0b5-7595f9167cbe', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', '77b678af-db22-4920-821b-a89ef5869fbe'),
        ('33a8641e-2fb8-40ec-a797-970683165b85', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'c5004c5a-273a-42cb-a099-4d167b2e3392'),
        ('f8971916-93e5-4b59-8428-0f756385e018', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'f6ae619f-8fdb-4948-bd09-9c2c32105b91'),
        ('43ccf223-d303-40db-bd60-a497434309dc', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '77b678af-db22-4920-821b-a89ef5869fbe');

-- [ USER SCHEMA ]
-- The User password is always 'aA1?12345678'
insert into Users(id,
                  username, nickname, email,
                  status, role_id, successful_auth, failed_auth,
                  creation_date,
                  password, password_expiration_date,
                  last_connection, end_block_date)
    values
        ('5c78e091-59c9-42b9-bf72-a7e148ec46c1',
         'root', 'Root', 'root@codebay.com',
         'ENABLED', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 1,  0,
         '2023-01-01T00:00:00',
         '$2a$10$CmY1fJn.F/Vncoc9FAO4xuCFSAw8T2FeDLH4Tm5Hc0jL0sujxcO3e', '2024-06-01T00:00:00',
         '2023-01-01T20:40:00', null),
        ('8bbdbe71-6c4c-4760-ad4c-3a8dd049746e',
         'master', 'Master', 'master@codebay.com',
         'ENABLED', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 7,  0,
         '2023-01-01T00:00:00',
         '$2a$10$jl.tDahzXPHImKeg9Wm5Qu.xRDB5gCeOdJMJXybTLPiY7S2OS00b.', '2024-06-01T00:00:00',
         '2023-01-01T20:40:00', null),
        ('e2c00c47-e16b-45ac-9dd0-950a105fe67c',
         'jsmith', 'Janie_Smith', 'jane@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 5,  2,
         '2023-12-01T00:00:00',
         '$2a$10$0L4xnPbdGlQsBzAn785ZreMCyd5I7yLeUdJguyLXdbyy.cEOoNQci', '2024-06-01T00:00:00',
         '2023-12-20T18:30:00', null),
        ('959bc138-68cc-441e-9b2b-ec2ce523042c',
         'lucasb',   'Lucas-Brown', 'lucas@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 10, 4,
         '2023-12-01T00:00:00',
         '$2a$10$u4b.d021cTgDFB9k56CqQ.l3jAxivzapZgXhA1qvOta/dmAN6./8W', '2024-06-01T00:00:00',
         '2023-12-22T09:15:00', null),
        ('cffa074b-9d70-4912-9ead-e910733de26a',
         'olitay',   'Oli-Tay', 'oliviataylor@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 6,  3,
         '2023-12-01T00:00:00',
         '$2a$10$WytEF3GKlGbVEGLvp3kfhOjqW6fl/XXpwGxp7tkhvMJL0P9uqgp8G', '2024-06-01T00:00:00',
         '2023-12-22T14:20:00', null),
        ('91d98af2-cee5-4bd0-a52e-72a12cd4ec1b',
         'mjones',   'MikeyJ', 'mjones@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 12, 6,
         '2023-12-01T00:00:00',
         '$2a$10$nJmiEaNH04jax0mkP32OcuGUp7hSoH1mEX8mOE/Li9yzlwJ.9u6.2', '2024-06-01T00:00:00',
         '2023-12-21T17:30:00', null),
        ('8e72b3f6-1a9d-4c87-bbfb-2f547eeb4eab',
         'thompson', 'SaraT', 'sarathompson@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 7,  2,
         '2023-12-01T00:00:00',
         '$2a$10$M15VX22oNpRWWeNkH3nVcOYFM7tKo6tu4zeyPrvWPpNmld0EgyxFq', '2024-06-01T00:00:00',
         '2023-12-21T12:45:00', null),
        ('9d5d8ea4-4b4e-414d-82cb-0fa2fc5f868f',
         'no_wi',    'Noah', 'noah_wilson@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 9,  1,
         '2023-12-01T00:00:00',
         '$2a$10$3Uuz05L/r6ChtPNojKemCuw4QXKcgmdaNNm2HrZWA2QnonuqJc0bi', '2024-06-01T00:00:00',
         '2023-12-23T10:45:00', null),
        ('a9df812b-3f4c-41e7-8d6c-ef70c6f61c3f',
         'emmas',    'EmSmith', 'esmith@email.com',
         'ENABLED', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 5,  2,
         '2023-12-01T00:00:00',
         '$2a$10$EQGDnbxNIJxzhJP/tNxYAePeky6DIoafWCxmHqICXSOoBd0REnmfy', '2024-06-01T00:00:00',
         '2023-12-22T09:15:00', null);

insert into Administrator(user_id,
                          document_type, document,
                          name, surnames, gender, birthdate,
                          phone_code, phone_number)
    values
        -- TODO: look if its better to create a superuser category for this admins
        ('5c78e091-59c9-42b9-bf72-a7e148ec46c1',
         'NO DEFINED', 'XXXXXXXXX',
         'Root', 'Root', 'OTHER', '2023-01-01',
         '+34', '000 00 00 00'),
        ('8bbdbe71-6c4c-4760-ad4c-3a8dd049746e',
         'NO DEFINED', 'XXXXXXXXX',
         'Master', 'Master', 'OTHER', '2023-01-01',
         '+34', '000 00 00 00');
