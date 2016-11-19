How to run using docker images

first pull image https://hub.docker.com/r/diegosena/hazelcastserver/

run using "docker run -P --name hazelcast diegosena/hazelcastserver"

the pull image https://hub.docker.com/r/diegosena/address/

run using "docker run -i -t -p 8080:8080 -e apikey=<put your api key here> --link hazelcast:hazelcast diegosena/address:latest"

curl "http://localhost:8080/address/{uk|ie}/{postcode|eircode|address-fragment}"

curl "http://localhost:8080/addressgeo/{ie}/{|eircode|address-fragment}"

curl "http://localhost:8080/position/{ie}/{|eircode|address-fragment}"

Optional Parameters:

lines - The number of lines over which to split each address

include - Include extra address fields within the address lines returned 

exclude - Exclude address fields within the address lines returned

identifier - Identify your lookups to make debugging and reviewing stats easier

callback - Use to specify the name of your JSONP callback function

page - For use with searches that return more than 100 results; first page is 0
