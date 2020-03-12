CREATE TABLE instances (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    state varchar(255) NOT NULL,
    created_at datetime DEFAULT CURRENT_TIMESTAMP,
    last_modified_at datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;