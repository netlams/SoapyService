# SoapyWService
Just using Spring-boot to build my first WSDL Soap Service. :)


## Build
./gradlew bootRun

## Test
curl --header "content-type: text/xml" -d @get-request.xml http://localhost:8080/service
