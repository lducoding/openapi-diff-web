# openAPI-diff-web

openapi 스펙(2.0, 3.0) web에서 편리하게 비교가 가능합니다.
You can conveniently compare the openapi specifications (2.0, 3.0) on the web

[![Docker Cloud Automated build](https://img.shields.io/docker/cloud/automated/openapitools/openapi-diff)](https://hub.docker.com/repository/docker/lducoding/openapi-diff-web)
[![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/openapitools/openapi-diff)](https://hub.docker.com/repository/docker/lducoding/openapi-diff-web)

[![Docker Image Version](https://img.shields.io/docker/v/lducoding/openapi-diff-web)](https://hub.docker.com/r/lducoding/openapi-diff-web/tags)

## 실행환경(Requirements)

* Java 11

## 실행화면(Run Screen)
<img src="https://user-images.githubusercontent.com/72716345/175814321-2e3bc5d4-6894-49cd-8ea6-bd0d16086a80.jpeg"  width="500" height="400"/>



## 특징(Feature)

* openapi 스펙 3.0을 지원합니다.
* 웹에서 편리하게 openapi spec의 변경이력을 확인할 수 있습니다.
* docker를 이용해 최초 파일경로를 마운트 시켜야 합니다.
* 경로의 위치는 상관 없으나 openapi/folder/backup/2.json 의 구조로 만들어야 합니다.
* 경로생성 시 backup폴더의 이름은 변경하면 안됩니다.

* Support for openapi specification 3.0.
* You can conveniently check the change history of the openapi spec on the web.
* You need to mount the first file path using docker.
* The location of the path does not matter, but it must be made in the structure of openapi/folder/backup/2.json .
* When creating a path, the name of the "backup" folder must not be changed.

## 도커로 실행(Run to Docker)

Available on [Docker Hub](https://hub.docker.com/repository/docker/lducoding/openapi-diff-web) as `lducoding/openapi-diff-web`.

```bash
docker run -v /Users/ldu/openapi:/openapi lducoding/openpapi-diff-web
```

## 사용법(Usage)

* 폴더 구조는 openapi(이름 변경가능)/(각종 api별 폴더가 존재)/backup(고정 변경불가!)/(openapi스펙파일들)
* ex) openapi/login/backup/220625.json
* ex) openapi/member/backup/220611.json
* docker에서 경로 설정은 api폴더 들이 모여있는 openapi폴더까지 잡아주면 된다.

* The folder structure is openapi (name can be changed)/(folders for each api exist)/backup (fixed and cannot be changed!)/(openapi specification files)
* ex) openapi/login/backup/220625.json
* ex) openapi/member/backup/220611.json
* To set the path in docker, you just need to grab the openapi folder where the api folders are gathered.

## License

openapi-diff-web is released under the Apache License 2.0.

## Thanks

* [OpenApiTools](https://github.com/OpenAPITools) for this project [openapi-diff](https://github.com/OpenAPITools/openapi-diff) 
  which was a source of inspiration for this tool
