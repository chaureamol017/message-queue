#To remove spring boot application image
removeSpringAppImage() {
  docker rm $1
  docker rmi $1
  rm -rf $1/target
}

docker-compose stop
docker rm demo-rabbit

#removeSpringAppImage 'demo-producer'
#removeSpringAppImage 'demo-consumer'

