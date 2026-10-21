# 로컬 실행

## 준비

Java 17, Maven 3.9+, Node 20, Docker Desktop을 준비한다.

```sh
docker compose -f compose.portfolio.yml up -d
```

최초 실행 시 `script/sql/wms.sql`이 학습 전용 MySQL 볼륨에 적용된다.
이미 데이터가 있는 볼륨에는 자동 재적용되지 않는다.
기존 DB나 다른 컨테이너에 SQL을 적용하지 않는다.

`ruoyi-admin-wms/src/main/resources/application-local.yml`은 Git에서 제외된다.
다음 내용을 로컬에 만든다.

`application-dev.yml`을 `application-local.yml`로 복사한 뒤 아래 값만 변경한다.

- JDBC URL: `localhost:3306/ry-vue` → `127.0.0.1:13316/wms_portfolio`
- MySQL password: `wms-local-only`
- Redis port: `16379`
- 서버 바인딩: `server.address: 127.0.0.1`

`spring.config.import`로 dev 설정을 가져오면 가져온 값이 로컬 값을 덮을 수 있으므로,
이 프로젝트에서는 전체 파일을 복사하여 수정한다. 비밀번호는 로컬 학습 컨테이너 전용 예시다.

## 빌드와 실행

백엔드 저장소에서:

```sh
mvn -pl ruoyi-admin-wms -am package -DskipTests
java -jar ruoyi-admin-wms/target/ruoyi-admin-wms.jar --spring.profiles.active=local
```

프런트엔드 저장소에서:

```sh
npm install --registry=https://registry.npmjs.org
npm run dev -- --host 127.0.0.1 --port 5175 --open false
```

프런트엔드의 `/dev-api` 프록시는 `localhost:8080` 백엔드로 연결된다.

## 수량 검증 회귀 테스트

```sh
mvn -pl ruoyi-admin-wms -am test -Dtest=InventoryQuantityTest -Dsurefire.failIfNoSpecifiedTests=false
```

원본 Maven 설정의 기본 테스트 태그는 dev다. 테스트에도 `@Tag("dev")`를 사용했다.
이 테스트는 DB를 모킹한 서비스 단위 테스트이며, 실제 MySQL의 동시성·롤백 증거는 아니다.

## 종료 (데이터 유지)

```sh
docker compose -f compose.portfolio.yml stop
```

Java와 Vite를 실행한 터미널에서 각각 Ctrl+C로 종료한다.

## 실제 DB 통합 테스트 (학습 전용 DB에서만)

```sh
WMS_DB_TEST=1 mvn -pl ruoyi-admin-wms -am test -Dtest=WmsWorkflowIntegrationTest -Dsurefire.failIfNoSpecifiedTests=false
```

`wms_portfolio` DB인지 확인한 후 테스트 전용 창고를 생성한다. 기존 샘플 SKU 하나를
읽기 참조하고, 테스트가 끝나면 자신이 생성한 전표·이력·재고·창고만 정리한다.
HTTP 로그인·화면 조작을 포함한 E2E 테스트는 아니며 Spring 서비스와 실제 MySQL을 검증한다.
