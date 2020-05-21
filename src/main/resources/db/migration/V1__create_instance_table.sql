CREATE TABLE instances (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    remote_id varchar(255) NOT NULL UNIQUE,
    name varchar(255) NOT NULL,
    state varchar(50) NOT NULL,
    provider varchar(50) NOT NULL,
    url varchar(255) NOT NULL,
    region varchar(50) NOT NULL,
    locked tinyint(1) DEFAULT 0,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
