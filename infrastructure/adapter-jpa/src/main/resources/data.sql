-- [ DATA INITIALIZATION ]

-- The Admin and User password is 'aA1?12345678'

--         ('', '', '', 5, 2, '', 'ACTIVE', null, 'GkyRT8YSjzuP4pXwyORoYMmf/LVkmc1AS6ryL4V1CY48ojKesLQeDCqmyvXDFkO4'),
--         ('', '', '', 5, 2, '', 'ACTIVE', null, 'FRTBYFssCPHerLU9Qao+sSL+UWgQlogndbiMphHmCPhn2XWsPJTsLPVeX2I4IB+S'),
insert into Administrator(username, nickname, email, successful_auth, failed_auth, last_connection, status, release_block, id, password)
    values
        ('root',   'Root',   'root@codebay.com',   1, 0, '2023-01-01T00:00:00', 0, null, '5c78e091-59c9-42b9-bf72-a7e148ec46c1', 'tKxUAcWrGz4CR/ubNN5EITsFDXN8cOJUFvvCkFSNYnZRIqyCx64iBG1A9AmD+Gxh'),
        ('master', 'Master', 'master@codebay.com', 0, 0, '2023-01-01T00:00:00', 0, null, '8bbdbe71-6c4c-4760-ad4c-3a8dd049746e', 'aB3euxreaepfn8l1vCEUXvDi+y64HLfX6pgFd3EEcE7uASFLiKHMlIiatB7x7iLb');

insert into Users(username, nickname, email, successful_auth, failed_auth, last_connection, status, release_block, id, password)
    values
        ('jsmith',   'Janie_Smith', 'jane@email.com',         5,  2, '2023-12-20T18:30:00', 0, null, 'e2c00c47-e16b-45ac-9dd0-950a105fe67c', 'P61h6cGgaHMSDTv7F6m0owmLUCQ5vR9pAAOy2WPvMZSW0j1c8rDsvtdlN580nm3I'),
        ('lucasb',   'Lucas-Brown', 'lucas@email.com',        10, 4, '2023-12-22 09:15:00', 0, null, '959bc138-68cc-441e-9b2b-ec2ce523042c', 'UiOrlVjTNvsewKDcsxr3CyeGfhrWbE+RHN5V/H0bgrPUSCtEG6XS49LyNH5tVqJF'),
        ('olitay',   'Oli-Tay',     'oliviataylor@email.com', 6,  3, '2023-12-22 14:20:00', 0, null, 'cffa074b-9d70-4912-9ead-e910733de26a', '2gB/VmLnGnJJdk8UHO3MGmuJqNU5XTP94176GjjuaHvi8NLeOXV17z3SqfXZaY3r'),
        ('mjones',   'MikeyJ',      'mjones@email.com',       12, 6, '2023-12-21T17:30:00', 0, null, '91d98af2-cee5-4bd0-a52e-72a12cd4ec1b', 'S6z51B/mcmZltmRehCL2D4bFFGaKjkSER2BqIxC5/bco9Ey6UWdoeS5PFQve/7aI'),
        ('thompson', 'SaraT',       'sarathompson@email.com', 7,  2, '2023-12-21 12:45:00', 0, NULL, '8e72b3f6-1a9d-4c87-bbfb-2f547eeb4eab', 'K2HxqKqwUonftd9kjnT7sXnU59XUEoxErJCfJNc/LvKucWIZufiFlz0XKcRX0BPZ'),
        ('no_wi',    'Noah',        'noah_wilson@email.com',  9,  1, '2023-12-23 10:45:00', 0, NULL, '9d5d8ea4-4b4e-414d-82cb-0fa2fc5f868f', 'U7bOSItLeGFBoSK24u5ZfccawfTXuoub7QusQZtcM2Y3KgyqZAcsyGMz0hVAdjzz'),
        ('emmas',    'EmSmith',     'esmith@email.com',       5,  2, '2023-12-22 09:15:00', 0, NULL, 'a9df812b-3f4c-41e7-8d6c-ef70c6f61c3f', 'e8RTnsH1UHPOlkprGy7oyrirZnHR1jC9CBAnUY4K67TUU/d1I+zgO+YTM9XEKzyC');
