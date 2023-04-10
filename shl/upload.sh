curl \
--location 'http://localhost:18081/sendFile' \
--header 'Content-Type: application/json' \
--data '{
    "path": "/Users/hosuk/Downloads",
    "name": "camel-saga-quickstart-master.zip"
}'