## ktknowledge_api

## Setup
### Prerequisite
- direnv
- sdkman

### Start server
```shell
$ cp .env.dev .env
$ docker-compose -f docker-compose.dev.yml up -d
$ sdk env install
$ ./gradlew bootRun
```