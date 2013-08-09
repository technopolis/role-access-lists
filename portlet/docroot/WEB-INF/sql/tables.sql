create table opengr_AdminIPConfiguration (
	id_ LONG not null primary key,
	redirectUrl VARCHAR(200) null,
	debug BOOLEAN,
	mode_ INTEGER
);

create table opengr_AdminIPValidationData (
	id_ LONG not null primary key,
	ipAddresses STRING null,
	roles STRING null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	notes TEXT null,
	active_ BOOLEAN
);