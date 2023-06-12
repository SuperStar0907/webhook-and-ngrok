
# Working with Webhooks from PagerDuty

1. Using ngrok for opening a local port to listen for the post request from the Webhook subscription of PagerDuty.
2. Using MongoDB atlas to store the data from the payload received.

## Deployment

1. Download `ngrok` and add it to `/usr/bin`. 
2. run `ngrok http 7388` from terminal.
3. In the `application.properties` file, add
        `server.port=7388`
        `spring.data.mongodb.uri=<your_uri_with_database_name_included>`


## API Reference

#### Get all items

```http
  POST /pd-webhook
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `payload` | `Object` | **Required**. webhook payload |


### Acknowledgements

 This readme file is made using [readme.so](https://readme.so/editor)
