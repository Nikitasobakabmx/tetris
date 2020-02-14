FROM postgres:9.4
EXPOSE 5432
COPY myInitionalDB.sql /docker-entrypoint-initdb.d/myInitionalDB.sql
ENV POSTGRES_USER gleb
ENV POSTGRES_PASSWORD 111261
ENV POSTGRES_DB gleba
ENV PGDATA=/data
