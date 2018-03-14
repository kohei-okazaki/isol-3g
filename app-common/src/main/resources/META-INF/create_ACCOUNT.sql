CREATE TABLE ACCOUNT (
  USER_ID varchar2(16),
  PASSWORD varchar2(16),
  DELETE_FLAG varchar2(1),
  PASSWORD_EXPIRE date,
  REMARKS varchar2(256),
  FILE_ENCLOSURE_CHAR_FLAG varchar2(1),
  UPDATE_DATE date,
  REG_DATE date;
);

