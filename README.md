# Docker Instructions
run 'brew install --cask pgadmin4'

Open terminal
cd to project directory
run 'docker-compose -f docker-compose.dev.yml'

NOTE: It takes a few minutes for Docker to create your environment

After it is up and running, startup pgAdmin
Create a connection in pgAdmin to the PostgreSQL database running Docker (id: warthogs ; pw: warthogs --> this is defined in docker-compose.dev.yml)
Create the table defined in schema-postgresql.sql
Create the data defined in data-postgresql.sql

Run Postman tests and other tests...