#!/bin/bash

echo "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\
	<soapenv:Header />\
	<soapenv:Body>" > /tmp/request.xml

cat $1 | sed s/"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"//g >> /tmp/request.xml
echo "</soapenv:Body>\
</soapenv:Envelope>" >> /tmp/request.xml

curl \
--header "content-type: text/xml; charset=utf-8" \
-H "SOAPAction:" \
--data @/tmp/request.xml \
http://localhost:8080/subscriber/update

