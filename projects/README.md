# Repository for Project -- Part 2 and Part 3 (group)

## Docker Commands

Make sure you have docker installed on your machine. Make sure you have the following login for docker hub:

First, give access to the script file:

```
    chmod +x docker-cenas.sh
```

On the first run:

```
    ./docker-cenas.sh dev [fe,be]
```

This will pull all containers and run them locally.

If you finish your implementation and you are sure everything is correct run this command:

```
    ./docker-cenas.sh prod [fe,be]
```

This will tag and push your local images (to docker hub). Use the second argument to specify what to push (default is everything).

```
    ./docker-cenas.sh cleanup
```

This will stop and remove all containers relating to the project

```
    ./docker-cenas.sh purge
```

This will remove all images without an associated container running and all stopped containers. Use with care if you have docker resources that are not related to the project.

Only run Postgres:

```
    docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=postgres -p 5432:5432 -v $PWD/db-data:/var/lib/postgresql/data --rm postgres:9.6-alpine

    OR

    ./docker-cenas.sh db
```

Run

```
    docker logs [frontend,backend,postgres] -f
```
