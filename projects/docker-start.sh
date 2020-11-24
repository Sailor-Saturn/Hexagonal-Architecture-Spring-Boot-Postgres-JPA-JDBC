#!/usr/bin/env bash

set -eo pipefail

reload_local_compose(){
    docker-compose -f docker-compose/local/docker-compose.yml down 
    docker-compose -f docker-compose/prod/docker-compose.yml down 
    if [ $1 == "all" ]; then
        docker-compose -f docker-compose/local/docker-compose.yml up -d 
    else
        docker-compose -f docker-compose/local/docker-compose.yml up -d $1 
    fi
}

reload_prod_compose(){
    docker-compose -f docker-compose/local/docker-compose.yml down 
    docker-compose -f docker-compose/prod/docker-compose.yml down
    if [ $1 == "all" ]; then
        docker-compose -f docker-compose/prod/docker-compose.yml up -d
    else
        docker-compose -f docker-compose/prod/docker-compose.yml up -d $1 
    fi 
    
}

cleanup(){
    docker-compose -f docker-compose/local/docker-compose.yml down 
    docker-compose -f docker-compose/prod/docker-compose.yml down 
}

purge(){
    read -p "Confirm removing ALL stopped containers and unused images, potentially including ones not relating to this project? " -r 
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        exit 1
    fi
    docker system prune -f
}

usage(){
    echo "Usage:"
    echo "./docker-cenas [prod,dev] {fe,be}"
    echo "if the second arg is ommitted, all images will be updated/pushed"
    echo "Run ./docker-cenas cleanup to stop and delete all containers relating to this project"
    echo "Run ./docker-cenas purge to remove ALL stopped containers and unused images, potentially including ones not relating to this project"
}

dev(){
    echo "Building images locally..."
    echo $1
    if [ -z $1 ]; then
        docker build -t client:0.0.1 ./client
        docker build -t server:0.0.1 ./server
        reload_local_compose "all"
    else 
        case $1 in
            fe)
                docker build -t client:0.0.1 ./client
                echo "Updating running containers..."
                reload_local_compose "frontend"
                ;;
            be)
                docker build -t server:0.0.1 ./server
                echo "Updating running containers..."
                reload_local_compose "backend"
                ;;
            *)
                usage
                ;;
        esac
    fi
}

prod(){
    echo "Building images locally..."
    if [ -z $1 ]; then
        docker build -t client:0.0.1 ./client
        docker build -t server:0.0.1 ./server
        echo "Tagging images for pushing to docker hub..."
        docker tag client:0.0.1 arqsoft101/client:0.0.1
        docker tag server:0.0.1 arqsoft101/server:0.0.1
        echo "Pushing images to docker hub..."
        docker push arqsoft101/client:0.0.1
        docker push arqsoft101/server:0.0.1
        echo "Updating running containers..."
        reload_prod_compose "all"
    else 
        case $1 in
            fe)
                docker build -t client:0.0.1 ./client
                echo "Tagging images for pushing to docker hub..."
                docker tag client:0.0.1 arqsoft101/client:0.0.1
                echo "Pushing images to docker hub..."
                docker push arqsoft101/client:0.0.1
                echo "Updating running containers..."
                reload_prod_compose "frontend"
                ;;
            be)
                docker build -t server:0.0.1 ./server
                echo "Tagging images for pushing to docker hub..."
                docker tag server:0.0.1 arqsoft101/server:0.0.1
                echo "Pushing images to docker hub..."
                docker push arqsoft101/server:0.0.1
                echo "Updating running containers..."
                reload_prod_compose "backend"
                ;;
            *)
                usage;;
        esac
    fi
}


if [ $# -ne 1 ] && [ $# -ne 2 ] ; then
    usage
else
    case $1 in
        prod)
            prod $2
            ;;
        dev)
            dev $2
            ;;
        db)
            cleanup
            docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=postgres -p 5432:5432 -v "$PWD"/db-data:/var/lib/postgresql/data --rm postgres:9.6-alpine
            ;;
        cleanup)
            cleanup
            ;;
        purge)
            purge
            ;;
        *)
            usage
            ;;
    esac
fi
