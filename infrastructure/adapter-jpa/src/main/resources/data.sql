-- =========================
-- == DATA INITIALIZATION ==
-- =========================

-- [ SECURITY SCHEMA ]
insert into Role(id, name, description)
    values
        ('556098f0-b030-4a53-84bd-c5c22e181461', 'SYSADMIN',  'System administrators with comprehensive control over system-level configurations and operations.'),
        ('c4f7aa87-b916-40a1-b2da-b79dea51784b', 'ADMIN',     'Authorized personnel with full control over the platform'),
        ('20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'USER',      'Basic visitors who have limited access'),
        ('119847ec-c01d-443f-9756-87f58e285aed', 'CUSTOMER',  'Fully registered users in the shop'),
        ('c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', 'ASSISTANT', 'Users with partial administrative privileges, assisting admins in specific tasks'),
        ('367dbe6f-7bf1-4614-84b5-c769e2789251', 'STAFF',     'Employees or team members assigned specific roles within the platform');

insert into Operation(id, name)
    values
        ('77b678af-db22-4920-821b-a89ef5869fbe', 'READ_MY_PROFILE'),
        ('c5004c5a-273a-42cb-a099-4d167b2e3392', 'UPDATE_MY_PROFILE'),
        ('f6ae619f-8fdb-4948-bd09-9c2c32105b91', 'DELETE_MY_PROFILE'),
        ('33600df7-5a4d-48e4-b90b-9fa41bbf8c38', 'READ_ALL_ROLES'),
        ('9d05134c-244b-4204-a326-0ebe7415fbd8', 'READ_ROLE'),
        ('a642d3e1-5b1c-4b81-a48d-a7d7254aee0b', 'CREATE_ROLE'),
        ('edfbbaf4-2bbc-4363-8b0c-26a4f439fd9a', 'UPDATE_ROLE'),
        ('5574e9b8-20fe-4b05-8e5d-dd6b036026fd', 'DELETE_ROLE'),
        ('c96eb5fe-6841-4fd2-90af-2341b4fb584b', 'READ_ALL_OPERATIONS'),
        ('d0f24a15-4404-4b78-8e13-d67eb7b20fe5', 'READ_OPERATION'),
        ('de506300-f0be-49c4-8b52-c713d91f312c', 'CREATE_OPERATION'),
        ('95e2c5c3-5cf8-421b-a70d-fcffd568caf3', 'UPDATE_OPERATION'),
        ('d9c5f1ab-b16b-4de8-8b15-f5e2462ab400', 'DELETE_OPERATION'),
        ('efd9d80d-48b0-4b77-8b17-68bb1d779b92', 'READ_ALL_GRANTED_PERMISSIONS'),
        ('e2401549-e06e-45b2-b58e-9c9c3ae9af51', 'READ_GRANTED_PERMISSION'),
        ('a8126d44-9b8e-43bf-a165-2b7dccfd3fbf', 'GRANT_PERMISSION'),
        ('46702f4c-6987-4933-a088-625188a203bd', 'REVOKE_GRANTED_PERMISSION'),
        ('136b09a9-816f-4c9a-b102-64394c5d0c5e', 'READ_ALL_ADMINS'),
        ('a6abfa7f-b5e0-4d5e-937b-a100364236ee', 'READ_ADMIN_BY_ID'),
        ('ab279e72-ae31-4bcb-bd25-d4f6347381f5', 'READ_ADMIN_BY_USERNAME'),
        ('88254d6c-aff4-46ed-9637-c5c54dfdb85d', 'CREATE_ADMIN'),
        ('21370d41-8e7a-4f0c-a3d3-fc2bd64e15a7', 'UPDATE_ADMIN'),
        ('d8fd4b4f-8275-4929-8300-1dfc65ab6338', 'DELETE_ADMIN'),
        ('3e7f08c9-6d0c-4425-8c83-94cc01f01a4f', 'READ_ALL_USERS'),
        ('984f0352-bf27-4c0b-9ddc-7f16e5bf2052', 'READ_USER_BY_ID'),
        ('94ce90e2-6106-4f26-a492-df3b7962b764', 'READ_USER_BY_USERNAME'),
        ('ca317bbc-db38-4fda-9687-90e20836a112', 'CREATE_USER'),
        ('2e23910c-eccb-4941-81ec-480a4609e9d3', 'UPDATE_USER'),
        ('1a04015d-22ff-4ed0-8591-108e101a1f7a', 'DELETE_USER'),
        ('c393fd55-3ff4-4926-b9c1-f2257d8daded', 'READ_MY_CUSTOMER_PROFILE'),
        ('35877dd6-c3c7-4042-9395-963db57575e4', 'UPDATE_MY_CUSTOMER_PROFILE'),
        ('5ed26a29-c50e-4ffd-ae45-099ac4523a53', 'READ_MY_WISHLIST'),
        ('a9b480ed-bf1a-4c55-9ed7-75c92591b066', 'READ_MY_CART'),
        ('8f42697b-70dd-4f55-9dcf-783eb4f72c75', 'ADD_TO_MY_CART'),
        ('406fef21-e64b-4310-92ca-887da457732b', 'REMOVE_FROM_MY_CART'),
        ('20217087-4a43-4e57-b344-9ac42b54bb0b', 'MOVE_CART_TO_WISHLIST'),
        ('f7df451e-266d-4cdb-bb3d-d4b4618ef603', 'BUY_ONE_PRODUCT'),
        ('a99d6d18-be0e-486e-b473-4fc1c9c1506a', 'BUY_MY_CART_PRODUCTS'),
        ('f73918ea-d305-4467-a7d6-672f4b06e45e', 'ADD_TO_MY_WISHLIST'),
        ('0c755e1f-06bc-4512-9249-ebce33fb5fd0', 'REMOVE_FROM_MY_WISHLIST'),
        ('9ffb3ab4-f851-4b22-8912-887398957de5', 'MOVE_WISHLIST_TO_CART'),
        ('d9888bbf-4cc6-4198-98a0-b4a61dcf3e1f', 'READ_MY_ORDERS'),
        ('bdafc9d1-3ee2-4a9c-8561-de02b0350fd5', 'READ_ONE_ORDER');

insert into Granted_Permission(id, role_id, operation_id)
values
    -- SYSADMIN Permissions
    ('06e500de-e292-473d-b82a-d6438dbab13d', '556098f0-b030-4a53-84bd-c5c22e181461', '33600df7-5a4d-48e4-b90b-9fa41bbf8c38'), -- SYSADMIN, READ_ALL_ROLES
    ('dd120ee5-1391-4c55-bac1-bdbccd3b5161', '556098f0-b030-4a53-84bd-c5c22e181461', '9d05134c-244b-4204-a326-0ebe7415fbd8'), -- SYSADMIN, READ_ROLE
    ('78e831b3-6ae0-48cc-92b5-2b7b5e178fe0', '556098f0-b030-4a53-84bd-c5c22e181461', 'a642d3e1-5b1c-4b81-a48d-a7d7254aee0b'), -- SYSADMIN, CREATE_ROLE
    ('d8b5ac38-ce24-4eb9-bf81-6e49c1d02e91', '556098f0-b030-4a53-84bd-c5c22e181461', 'edfbbaf4-2bbc-4363-8b0c-26a4f439fd9a'), -- SYSADMIN, UPDATE_ROLE
    ('607905c7-0c69-4a57-8d80-45e94fa90039', '556098f0-b030-4a53-84bd-c5c22e181461', '5574e9b8-20fe-4b05-8e5d-dd6b036026fd'), -- SYSADMIN, DELETE_ROLE
    ('31d2a924-3805-46a1-8936-bec1014f2442', '556098f0-b030-4a53-84bd-c5c22e181461', 'c96eb5fe-6841-4fd2-90af-2341b4fb584b'), -- SYSADMIN, READ_ALL_OPERATIONS
    ('33fce394-78e3-4ce2-8ac2-d504045c775f', '556098f0-b030-4a53-84bd-c5c22e181461', 'd0f24a15-4404-4b78-8e13-d67eb7b20fe5'), -- SYSADMIN, READ_OPERATION
    ('0ef8d14f-274b-4908-9769-ae148a370a9f', '556098f0-b030-4a53-84bd-c5c22e181461', 'de506300-f0be-49c4-8b52-c713d91f312c'), -- SYSADMIN, CREATE_OPERATION
    ('c8a8b105-4e55-468d-990d-bc368b6536b4', '556098f0-b030-4a53-84bd-c5c22e181461', '95e2c5c3-5cf8-421b-a70d-fcffd568caf3'), -- SYSADMIN, UPDATE_OPERATION
    ('48109571-298f-4463-9928-d4c154c0ffe7', '556098f0-b030-4a53-84bd-c5c22e181461', 'd9c5f1ab-b16b-4de8-8b15-f5e2462ab400'), -- SYSADMIN, DELETE_OPERATION
    ('3cc182ef-f8a6-4c63-9bc5-7e9a76e78540', '556098f0-b030-4a53-84bd-c5c22e181461', 'efd9d80d-48b0-4b77-8b17-68bb1d779b92'), -- SYSADMIN, READ_ALL_GRANTED_PERMISSIONS
    ('f9984784-dbf2-4297-b48c-a7b22898b06c', '556098f0-b030-4a53-84bd-c5c22e181461', 'e2401549-e06e-45b2-b58e-9c9c3ae9af51'), -- SYSADMIN, READ_GRANTED_PERMISSION
    ('9c394e97-dcb2-4bd5-99c3-f4146fde44f7', '556098f0-b030-4a53-84bd-c5c22e181461', 'a8126d44-9b8e-43bf-a165-2b7dccfd3fbf'), -- SYSADMIN, GRANT_PERMISSION
    ('a33518b2-3ba0-47f3-ae8b-c428c22181e0', '556098f0-b030-4a53-84bd-c5c22e181461', '46702f4c-6987-4933-a088-625188a203bd'), -- SYSADMIN, REVOKE_GRANTED_PERMISSION
    ('477f6ad1-acda-4ac0-8a9a-473f7a01cccf', '556098f0-b030-4a53-84bd-c5c22e181461', '136b09a9-816f-4c9a-b102-64394c5d0c5e'), -- SYSADMIN, READ_ALL_ADMINS
    ('9e2bb291-de2b-43e5-b2f1-5f51a25ae5f0', '556098f0-b030-4a53-84bd-c5c22e181461', 'a6abfa7f-b5e0-4d5e-937b-a100364236ee'), -- SYSADMIN, READ_ADMIN_BY_ID
    ('2b4d662b-630c-4501-9284-3f15149c4dfd', '556098f0-b030-4a53-84bd-c5c22e181461', 'ab279e72-ae31-4bcb-bd25-d4f6347381f5'), -- SYSADMIN, READ_ADMIN_BY_USERNAME
    ('1f071194-5744-49e9-b0b5-7595f9167cbe', '556098f0-b030-4a53-84bd-c5c22e181461', '77b678af-db22-4920-821b-a89ef5869fbe'), -- SYSADMIN, READ_MY_PROFILE
    ('ce2d30e2-a3f0-4d99-b1bf-147caf6a0f14', '556098f0-b030-4a53-84bd-c5c22e181461', '88254d6c-aff4-46ed-9637-c5c54dfdb85d'), -- SYSADMIN, CREATE_ADMIN
    ('6232200f-f7a2-4feb-8879-84cd5a2deaea', '556098f0-b030-4a53-84bd-c5c22e181461', '21370d41-8e7a-4f0c-a3d3-fc2bd64e15a7'), -- SYSADMIN, UPDATE_ADMIN
    ('4ffb6c59-7df1-4ded-8831-cf138c0a6b25', '556098f0-b030-4a53-84bd-c5c22e181461', 'd8fd4b4f-8275-4929-8300-1dfc65ab6338'), -- SYSADMIN, DELETE_ADMIN
    ('9dad12e2-9221-470c-ab48-9946795c0b23', '556098f0-b030-4a53-84bd-c5c22e181461', '3e7f08c9-6d0c-4425-8c83-94cc01f01a4f'), -- SYSADMIN, READ_ALL_USERS
    ('c2343024-55ad-4ae6-8856-6d96a361554c', '556098f0-b030-4a53-84bd-c5c22e181461', '984f0352-bf27-4c0b-9ddc-7f16e5bf2052'), -- SYSADMIN, READ_USER_BY_ID
    ('2464de9b-6ea8-4df1-951c-37b56bfc035d', '556098f0-b030-4a53-84bd-c5c22e181461', '94ce90e2-6106-4f26-a492-df3b7962b764'), -- SYSADMIN, READ_USER_BY_USERNAME
    ('52902188-71b4-4442-be1f-21ad2e6ebdfe', '556098f0-b030-4a53-84bd-c5c22e181461', 'ca317bbc-db38-4fda-9687-90e20836a112'), -- SYSADMIN, CREATE_USER
    ('f1a9a919-ea38-4ed1-be31-306cdf90cbe4', '556098f0-b030-4a53-84bd-c5c22e181461', '2e23910c-eccb-4941-81ec-480a4609e9d3'), -- SYSADMIN, UPDATE_USER
    ('0fff33d0-905a-4469-8610-9a21ebfddc56', '556098f0-b030-4a53-84bd-c5c22e181461', '1a04015d-22ff-4ed0-8591-108e101a1f7a'), -- SYSADMIN, DELETE_USER

    -- ADMIN Permissions
    ('6ce53dd3-229c-470c-baf7-3e2095f5f202', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 'ab279e72-ae31-4bcb-bd25-d4f6347381f5'), -- ADMIN, READ_ADMIN_BY_USERNAME
    ('044ecf35-1699-4fef-ba95-6d6cf53e2512', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '77b678af-db22-4920-821b-a89ef5869fbe'), -- ADMIN, READ_MY_PROFILE
    ('04cf5585-0d99-43ef-8edc-d9463cef5d62', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '3e7f08c9-6d0c-4425-8c83-94cc01f01a4f'), -- ADMIN, READ_ALL_USERS
    ('bcedecbc-740e-459a-bee6-62a4a5f86e17', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '984f0352-bf27-4c0b-9ddc-7f16e5bf2052'), -- ADMIN, READ_USER_BY_ID
    ('12539350-443a-4681-ae4e-b51fd01862b6', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '94ce90e2-6106-4f26-a492-df3b7962b764'), -- ADMIN, READ_USER_BY_USERNAME
    ('b1334db6-218f-4e77-9eec-7d00cf8cc91d', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 'ca317bbc-db38-4fda-9687-90e20836a112'), -- ADMIN, CREATE_USER
    ('1467175b-b696-4c39-aacb-9d3c25a5e007', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '2e23910c-eccb-4941-81ec-480a4609e9d3'), -- ADMIN, UPDATE_USER
    ('dca9081c-a519-4921-a91f-e9b93f1f6b1b', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', '1a04015d-22ff-4ed0-8591-108e101a1f7a'), -- ADMIN, DELETE_USER
    ('cba67817-6727-44f1-9773-5c5bcf0be0d2', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 'c5004c5a-273a-42cb-a099-4d167b2e3392'), -- ADMIN, MODIFY_MY_PROFILE

    -- ASSISTANT Permissions
    ('fc586245-3ee4-45af-bec2-aafc0f01c95e', 'c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', '77b678af-db22-4920-821b-a89ef5869fbe'), -- ASSISTANT, READ_MY_PROFILE
    ('620f340a-c393-4a73-b837-7a08fcd2f08b', 'c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', '94ce90e2-6106-4f26-a492-df3b7962b764'), -- ASSISTANT, READ_USER_BY_USERNAME
    ('6f2f243e-3849-4e2b-b3f7-28c10e020f4b', 'c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', 'ca317bbc-db38-4fda-9687-90e20836a112'), -- ASSISTANT, CREATE_USER
    ('b6fd3567-b738-45f3-83ca-56dedb19cd7c', 'c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', 'c5004c5a-273a-42cb-a099-4d167b2e3392'), -- ASSISTANT, MODIFY_MY_PROFILE

    -- CUSTOMER Permissions
    ('8d4876d1-5a24-4600-9339-62524e4db565', '119847ec-c01d-443f-9756-87f58e285aed', '94ce90e2-6106-4f26-a492-df3b7962b764'), -- CUSTOMER, READ_USER_BY_USERNAME
    ('46a04a9f-3920-4349-bf22-92e2df4513fb', '119847ec-c01d-443f-9756-87f58e285aed', '77b678af-db22-4920-821b-a89ef5869fbe'), -- CUSTOMER, READ_MY_PROFILE
    ('66463aaa-2c06-4eac-905c-400ec70cc5e5', '119847ec-c01d-443f-9756-87f58e285aed', 'c5004c5a-273a-42cb-a099-4d167b2e3392'), -- CUSTOMER, UPDATE_MY_PROFILE
    ('abd787b8-0064-4c97-9d0c-4e6713900ac8', '119847ec-c01d-443f-9756-87f58e285aed', 'f6ae619f-8fdb-4948-bd09-9c2c32105b91'), -- CUSTOMER, DELETE_MY_PROFILE
    ('7cd3c239-d891-47e9-b447-5d27bd3e3078', '119847ec-c01d-443f-9756-87f58e285aed', 'c393fd55-3ff4-4926-b9c1-f2257d8daded'), -- CUSTOMER, READ_MY_CUSTOMER_PROFILE
    ('eb788f35-e79b-481e-a37e-228907a0c7fb', '119847ec-c01d-443f-9756-87f58e285aed', '35877dd6-c3c7-4042-9395-963db57575e4'), -- CUSTOMER, UPDATE_MY_CUSTOMER_PROFILE

    ('32aa683b-eeeb-4ede-a0c1-68ff605f3776', '119847ec-c01d-443f-9756-87f58e285aed', 'a9b480ed-bf1a-4c55-9ed7-75c92591b066'), -- CUSTOMER, READ_MY_CART
    ('72fecd9a-a9ee-415f-b576-42d2b36d91cb', '119847ec-c01d-443f-9756-87f58e285aed', '8f42697b-70dd-4f55-9dcf-783eb4f72c75'), -- CUSTOMER, ADD_TO_MY_CART
    ('7e3171bd-f23a-4e37-8a70-efe28b01a105', '119847ec-c01d-443f-9756-87f58e285aed', '406fef21-e64b-4310-92ca-887da457732b'), -- CUSTOMER, REMOVE_FROM_MY_CART
    ('de7f14c3-14ea-4a42-988d-43c16d85a6b0', '119847ec-c01d-443f-9756-87f58e285aed', '20217087-4a43-4e57-b344-9ac42b54bb0b'), -- CUSTOMER, MOVE_CART_TO_WISHLIST

    ('79575ef5-d9ae-4678-886d-a4d2dd344a1e', '119847ec-c01d-443f-9756-87f58e285aed', '5ed26a29-c50e-4ffd-ae45-099ac4523a53'), -- CUSTOMER, READ_MY_WISHLIST
    ('b1b8e794-4bc4-469e-b1f1-ed7bf8a8e4bf', '119847ec-c01d-443f-9756-87f58e285aed', 'f73918ea-d305-4467-a7d6-672f4b06e45e'), -- CUSTOMER, ADD_TO_MY_WISHLIST
    ('b832fcef-2b6c-4154-8616-728183ee5557', '119847ec-c01d-443f-9756-87f58e285aed', '0c755e1f-06bc-4512-9249-ebce33fb5fd0'), -- CUSTOMER, REMOVE_FROM_MY_WISHLIST
    ('604ab7f6-8388-4370-b89c-dad3a02bc34e', '119847ec-c01d-443f-9756-87f58e285aed', '9ffb3ab4-f851-4b22-8912-887398957de5'), -- CUSTOMER, MOVE_WISHLIST_TO_CART

    ('b65d8832-17a2-43cc-af4d-db1016dfaab0', '119847ec-c01d-443f-9756-87f58e285aed', 'f7df451e-266d-4cdb-bb3d-d4b4618ef603'), -- CUSTOMER, BUY_ONE_PRODUCT
    ('f7eb8989-6994-4771-8f52-e2aa5d14038d', '119847ec-c01d-443f-9756-87f58e285aed', 'a99d6d18-be0e-486e-b473-4fc1c9c1506a'), -- CUSTOMER, BUY_MY_CART_PRODUCTS
    ('243d6732-b87f-41d2-8b60-1333450b87ee', '119847ec-c01d-443f-9756-87f58e285aed', 'd9888bbf-4cc6-4198-98a0-b4a61dcf3e1f'), -- CUSTOMER, READ_MY_ORDERS
    ('14a17ee4-38f9-4b57-84c3-9c551d9f333c', '119847ec-c01d-443f-9756-87f58e285aed', 'bdafc9d1-3ee2-4a9c-8561-de02b0350fd5'), -- CUSTOMER, READ_ONE_ORDER

    -- USER Permissions
    ('5b7241b9-a6e0-49c6-9fe0-627b79391be2', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', '94ce90e2-6106-4f26-a492-df3b7962b764'), -- USER, READ_USER_BY_USERNAME
    ('33a8641e-2fb8-40ec-a797-970683165b85', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', '77b678af-db22-4920-821b-a89ef5869fbe'), -- USER, READ_MY_PROFILE
    ('5c436f0f-3fb6-432a-9117-a57367a3b713', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'c5004c5a-273a-42cb-a099-4d167b2e3392'), -- USER, UPDATE_MY_PROFILE
    ('f8971916-93e5-4b59-8428-0f756385e018', '20b53285-3ab0-427d-b8bf-f4e3cba7933b', 'f6ae619f-8fdb-4948-bd09-9c2c32105b91'); -- USER, DELETE_MY_PROFILE

-- [ USER SCHEMA ]
insert into User_Status(code, text)
    values
        ('ENB', 'ENABLED'),
        ('DSB', 'DISABLED'),
        ('BLK', 'BLOCKED');

insert into Gender(code, text)
    values
        ('M', 'Male'),
        ('F', 'Female'),
        ('O', 'Other');

insert into Document_Type(code, text)
    values
        ('NID', 'National Identification Document'),
        ('PSP', 'Passport'),
        ('SSN', 'Social Security Number');

-- The User password is always 'aA1?12345678'
insert into Users(id,
                  username, nickname, email,
                  status, role_id, successful_auth, failed_auth,
                  creation_date,
                  password, password_expiration_date,
                  last_connection, end_block_date)
values
    ('5c78e091-59c9-42b9-bf72-a7e148ec46c1', -- SYSADMIN
     'root', 'Root', 'root@codebay.com',
     'ENABLED', '556098f0-b030-4a53-84bd-c5c22e181461', 1,  0,
     '2023-01-01T00:00:00',
     '$2a$10$CmY1fJn.F/Vncoc9FAO4xuCFSAw8T2FeDLH4Tm5Hc0jL0sujxcO3e', '2024-06-01T00:00:00',
     '2023-01-01T20:40:00', null),
    ('8bbdbe71-6c4c-4760-ad4c-3a8dd049746e', -- SYSADMIN
     'master', 'Master', 'master@codebay.com',
     'ENABLED', '556098f0-b030-4a53-84bd-c5c22e181461', 7,  0,
     '2023-01-01T00:00:00',
     '$2a$10$jl.tDahzXPHImKeg9Wm5Qu.xRDB5gCeOdJMJXybTLPiY7S2OS00b.', '2024-06-01T00:00:00',
     '2023-01-01T20:40:00', null),
    ('7d213d92-64a9-40ed-baee-d48cc501c11a', -- ADMIN
     'hwilson',    'Henry Wilson', 'hwilson@codebay.com',
     'ENABLED', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 1,  1,
     '2023-12-01T00:00:00',
     '$2a$10$3Uuz05L/r6ChtPNojKemCuw4QXKcgmdaNNm2HrZWA2QnonuqJc0bi', '2024-06-01T00:00:00',
     '2023-12-23T10:45:00', null),
    ('98585064-1044-4941-831a-e56bc273e3bf', -- ADMIN
     'ilee',    'Isabella Lee', 'ilee@codebay.com',
     'ENABLED', 'c4f7aa87-b916-40a1-b2da-b79dea51784b', 1,  1,
     '2023-12-01T00:00:00',
     '$2a$10$3Uuz05L/r6ChtPNojKemCuw4QXKcgmdaNNm2HrZWA2QnonuqJc0bi', '2024-06-01T00:00:00',
     '2023-12-23T10:45:00', null),
    ('a0c819da-d3a7-439d-aa5c-7b3b14c8cd0f', -- ASSISTANT
     'wjones',    'William Jones', 'wjones@codebay.com',
     'ENABLED', 'c65576bf-dfb0-443a-bad5-fa9aebc6ea0a', 1,  2,
     '2023-12-01T00:00:00',
     '$2a$10$EQGDnbxNIJxzhJP/tNxYAePeky6DIoafWCxmHqICXSOoBd0REnmfy', '2024-06-01T00:00:00',
     '2023-12-22T09:15:00', null),
    ('e2c00c47-e16b-45ac-9dd0-950a105fe67c',
     'jsmith', 'Janie_Smith', 'jane@email.com',
     'ENABLED', '119847ec-c01d-443f-9756-87f58e285aed', 5,  2,
     '2023-12-01T00:00:00',
     '$2a$10$0L4xnPbdGlQsBzAn785ZreMCyd5I7yLeUdJguyLXdbyy.cEOoNQci', '2025-06-01T00:00:00',
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
     '$2a$10$M15VX22oNpRWWeNkH3nVcOYFM7tKo6tu4zeyPrvWPpNmld0EgyxFq', '2024-10-01T00:00:00',
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

insert into Country(code, text)
    values
        ('ES', 'Spain'),
        ('PT', 'Portugal'),
        ('CH', 'Switzerland'),
        ('DE', 'Germany'),
        ('UK', 'United Kingdom'),
        ('FR', 'France');

insert into Administrator(user_id,
                          document_type, document,
                          name, surnames, gender, birthdate,
                          phone_code, phone_number)
values
    ('5c78e091-59c9-42b9-bf72-a7e148ec46c1',
     'NO DEFINED', 'XXXXXXXXX',
     'Root', 'Root', 'OTHERS', '2023-01-01',
     '+34', '000 00 00 00'),
    ('8bbdbe71-6c4c-4760-ad4c-3a8dd049746e',
     'NO DEFINED', 'XXXXXXXXX',
     'Master', 'Master', 'OTHERS', '2023-01-01',
     '+34', '000 00 00 00'),
    ('7d213d92-64a9-40ed-baee-d48cc501c11a',
     'NID', '49471573E',
     'Henry', 'Wilson', 'MALE', '2000-01-01',
     '+34', '626 131 685'),
    ('98585064-1044-4941-831a-e56bc273e3bf',
     'NID', '32307123N',
     'Isabella', 'Lee', 'MALE', '2000-01-01',
     '+34', '677 047 193'),
    ('a0c819da-d3a7-439d-aa5c-7b3b14c8cd0f',
     'NID', '57368483C',
     'William', 'Jones', 'FEMALE', '2000-01-01',
     '+34', '609 290 363');

insert into Customer(user_id,
                     document_type, document,
                     name, surnames, gender, birthdate,
                     phone_code, phone_number,
                     country, road_type, address_name, address_number, portal,
                     floor, location, region, postal_code,
                     accumulated_expenditure, type, license,
                     comments)
values
    ('e2c00c47-e16b-45ac-9dd0-950a105fe67c',
    'NID', '57546224V',
    'Jannet', 'Smith', 'FEMALE', '2000-01-01',
    '+34', '690 209 636',
    'Spain', 'Street', 'todo: Change later', '8', null,
    null, 'Madrid', 'Comunidad de Madrid', '20000',
    574.83, 'GOLD', true,
    null);

insert into Shopping_Cart(id, customer_id)
values
    ('250f629c-4b1d-46db-ae08-17b5fd77e2f9', 'e2c00c47-e16b-45ac-9dd0-950a105fe67c');

insert into Wish_List(id, customer_id)
values
    ('bfca0d8d-a7a4-42ca-9cb1-014782340112', 'e2c00c47-e16b-45ac-9dd0-950a105fe67c');

insert into Product(id, code, name,
                    brand, model, price,
                    rating_number, rating, stock, units_sold, upper_limit, lower_limit, total_earnings,
                    on_sale, on_offer, is_new, discount,
                    description)
values
    ('61c1b256-9ce9-424e-aa10-889e03014a4f', 'XZ-78RTY', 'Sneakers',
     '', '', 99.99,
     3, 4.4, 25, 5, 17, 8, 1099.78,
     true, false, true, 0,
     'These sneakers combine style and functionality. With a breathable mesh upper and a cushioned sole, they provide comfort and support during your physical activities. Plus, their modern, sporty design lets you look fashionable while staying active.'),
    ('9dcff90c-c5bd-4eae-81fd-80fb08d67b98', 'PQ-29LMN', 'Leather Bag',
     '', '', 29.99,
     17, 3.8, 32, 25, 17, 8, 822.82,
     true, true, false, 0.1,
     'This stylish leather bag is the perfect accessory to complement your outfit. Made of high quality genuine leather, it offers durability and strength. With multiple compartments and internal pockets, it gives you more than enough space to carry your belongings in an organized way.'),
    ('4b0bbc56-6fc3-4089-8b8e-64633b2ec527', 'JW-45ABC', 'T-Shirt',
     '', '', 14.95,
     38, 3.2, 73, 47, 20, 10, 746.35,
     false, true, false, 0.2,
     'This soft and comfortable cotton T-shirt is perfect for everyday wear. With a classic design and relaxed fit, it gives you all-day comfort. Available in a variety of colors, you can choose the one that best suits your style.'),
    ('eb0b1182-a2c2-440a-886f-0c64f1f3330b', 'KL-12DEF', 'Headphones',
     '', '', 125.50,
     7, 4.8, 15, 10, 10, 5, 1476.46,
     true, false, false, 0,
     'These wireless headphones offer you an exceptional listening experience. With noise-cancelling technology and premium sound quality, you can immerse yourself in your favorite music without distractions. Their ergonomic and lightweight design makes them comfortable to wear for hours on end.'),
    ('add5bb23-9fa9-45b0-b3b2-c3f9169cc5b4', 'VY-63GHI', 'Clock-Band',
     '', '', 299.99,
     2, 4.75, 10, 4, 8, 3, 1299.99,
     true, true, true, 0.15,
     'This sleek and sophisticated timepiece complements your style with class. With a stainless steel band and a shiny dial, it''s perfect for formal or casual occasions. In addition to displaying the time, it also features additional functions such as a stopwatch and date.');

insert into Cart_Details(cart_id, product_id, units)
    values
        ('250f629c-4b1d-46db-ae08-17b5fd77e2f9', '61c1b256-9ce9-424e-aa10-889e03014a4f', 1),
        ('250f629c-4b1d-46db-ae08-17b5fd77e2f9', 'eb0b1182-a2c2-440a-886f-0c64f1f3330b', 1),
        ('250f629c-4b1d-46db-ae08-17b5fd77e2f9', 'add5bb23-9fa9-45b0-b3b2-c3f9169cc5b4', 1);

insert into Wishlist_Product(wishlist_id, product_id)
    values
        ('bfca0d8d-a7a4-42ca-9cb1-014782340112', '9dcff90c-c5bd-4eae-81fd-80fb08d67b98');
