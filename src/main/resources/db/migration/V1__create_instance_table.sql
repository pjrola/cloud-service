CREATE TABLE instances (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    remote_id varchar(255) NOT NULL UNIQUE,
    state varchar(255) NOT NULL,
    provider varchar(255) NOT NULL,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    last_modified_at datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;